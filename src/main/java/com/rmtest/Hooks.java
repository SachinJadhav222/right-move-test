package com.rmtest;
import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Cucumber Hooks, contains @Before and @After methods gets executed before and after each cucumber scenario
 * @author SJadhav
 */

public class Hooks {
    WebDriver driver;
    String scenarioName;
    DriverBase driverBase;
    public Hooks(DriverBase driverBase)
    {
        this.driverBase =driverBase;
    }

    @Before()
    public void beforeScenarioMethod(Scenario scenario){
       driver=driverBase.getDriver();
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

}
