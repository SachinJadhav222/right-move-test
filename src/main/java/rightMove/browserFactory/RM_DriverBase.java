package rightMove.browserFactory;

import rightMove.automationConstants.RM_Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RM_DriverBase {
    public static WebDriver driver;

    public RM_DriverBase() {
        PageFactory.initElements(driver, this);
    }

    Logger logger = Logger.getLogger("RM_DriverBase");

    public void openBrowser() throws IOException {

        switch (RM_Constants.BROWSER) {
            case "Chrome": {
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                driver = new ChromeDriver();
                logger.info("Chrome Browser Started");
                break;
            }
            case "Firefox": {
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                driver = new FirefoxDriver();
                logger.info("Firefox Browser Started");
                break;
            }

        }
        driver.get(RM_Constants.URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    public void closeBrowser() {
        driver.quit();
        logger.info(RM_Constants.BROWSER + " Browser is Closed");
    }

    /**
     * Get the Web Driver
     *
     * @return
     */
    public WebDriver getWebDriver() {
        return driver;
    }

}
