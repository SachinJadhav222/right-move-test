package com.rmtest;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * This is Test Runner using Selenium Class with Extent Report Configuration
 * @author SJadhav
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/Test-Reports/Test-Report.html"},
        features = "classpath:featurefiles",
        glue = "classpath:",
        format = {"pretty", "html:target/cucumberReports/Destination"},
        tags = "@rm"
)
public class CucumberTest {
    @BeforeClass
    public static void setup() {
        try {
            new DriverBase().openBrowser();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void teardown() {
        new DriverBase().closeBrowser();
        Reporter.loadXMLConfig(new File("src/test/resources/extent-report-config.xml"));
        Reporter.setSystemInfo("QA Analyst :", System.getProperty("user.name"));
        Reporter.setSystemInfo("Operating System :", "Window");
        Reporter.setSystemInfo("Web Test Tool :", "Selenium WebDriver");
        Reporter.setSystemInfo("Test Browser :", "chrome");
        Reporter.setTestRunnerOutput("RightMove test runner output message");
    }

    /**
     * This method will return WebDriver
     *
     * @return -WebDriver
     */
    public static WebDriver getWebDriver() {
        return new DriverBase().getDriver();
    }
}
