package rightMove.stepDefinitions;

import rightMove.PageObjects.PageAssertions;
import rightMove.PageObjects.RM_Search_filters;
import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import rightMove.PageObjects.RM_HomePage;
import rightMove.PageObjects.RM_Search_Results_Page;
import rightMove.testRunners.TestRunner;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class Steps_hooks {
    WebDriver driver;
    public PageAssertions pageAssertions;
    public RM_HomePage rm_homePage;
    public RM_Search_Results_Page rm_search_results_page;
    public RM_Search_filters rm_search_filters;
    String scenarioName;

    @Before()
    public void beforeScenarioMethod(Scenario scenario){
        driver= TestRunner.getWebDriver();
        create_objects_for_page_classes();
        scenarioName=scenario.getName();

    }
    @After()
    public void afterScenarioMethod(Scenario scenario){
        if (scenario.isFailed()) {
            String rootPath = System.getProperty("user.dir") + "/target/Test-Reports/screenShots/"+scenario.getName()+".png";
            System.out.println(rootPath);
            try {
                File srcFiler = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(srcFiler, new File(rootPath));
                Reporter.addScreenCaptureFromPath(rootPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            scenario.write("Scenario Failed");
        } else {
            scenario.write("Scenario Passed");
        }
    }
    private void create_objects_for_page_classes() {
        pageAssertions=new PageAssertions();
        rm_homePage=new RM_HomePage();
        rm_search_filters=new RM_Search_filters();
        rm_search_results_page=new RM_Search_Results_Page();
    }
}
