package rightMove.testRunners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import rightMove.automationConstants.RM_Constants;
import rightMove.browserFactory.RM_DriverBase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * This is Test Runner using Selenium Class with Extent Report Configuration
 *
 * @author sjadhav
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/rightMove/featureFiles"},
        glue = {"rightMove.stepDefinitions"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/Test-Reports/Test-Report.html"},
        format = {"pretty", "html:target/cucumberReports/Destination"},
        tags = {"@search_for_rent"}
)
public class TestRunner {
    @BeforeClass
    public static void setup() {
        try {
            new RM_DriverBase().openBrowser();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void teardown() {
        new RM_DriverBase().closeBrowser();
        Reporter.loadXMLConfig(new File("src/test/resources/configuration/extent-config.xml"));
        Reporter.setSystemInfo("QA Analyst :", System.getProperty("user.name"));
        Reporter.setSystemInfo("Operating System :", "Window");
        Reporter.setSystemInfo("Web Test Tool :", "Selenium WebDriver");
        Reporter.setSystemInfo("Test Browser :", RM_Constants.BROWSER);
        Reporter.setTestRunnerOutput("RightMove test runner output message");
    }

    /**
     * This method will return WebDriver
     *
     * @return -WebDriver
     */
    public static WebDriver getWebDriver() {
        return new RM_DriverBase().getWebDriver();
    }
}
