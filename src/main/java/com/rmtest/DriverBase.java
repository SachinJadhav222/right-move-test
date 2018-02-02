package com.rmtest;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Driver Base (Extended to all the page and utility class)
 * @author SJadhav
 */
public class DriverBase {
    public static WebDriver driver;

    public DriverBase() {
        PageFactory.initElements(driver, this);
    }

    Logger logger = Logger.getLogger("DriverBase");

    /**
     * Open the browser
     * @throws IOException
     */
    public void openBrowser() throws IOException
    {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/system.properties");
        properties.load(fileInputStream);
        String url=properties.getProperty("url");
        String browser=properties.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
            logger.info("The Chrome browser properties taken");
        }

        else if (browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            logger.info("The Firefox browser properties taken");
            driver = new FirefoxDriver();
        }

       driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * Close the Browser
     */
    public void closeBrowser()
    {
        driver.quit();
    }

    /**
     * Get the Web Driver
     *
     * @return
     */
    public WebDriver getDriver() {
        return driver;
    }

}
