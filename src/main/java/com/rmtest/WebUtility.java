package com.rmtest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Utility Calls fo Reusable Methods
 */
public class WebUtility extends DriverBase {
    private WebDriverWait wait;

    public WebDriverWait waitFor() {
        return wait;
    }

    public void select_dropdown_by_visible_text(WebElement element, String visible_text) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(visible_text);
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        return waitFor().until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        return waitFor().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void handleException(Exception e, String message) {
        if (logger.isInfoEnabled()) {
            logger.info(message);
            e.printStackTrace();
        }
    }

    public void waitForSeconds(double seconds) {
        try {
            Thread.sleep(new Double((seconds * 1000)).longValue());
        } catch (InterruptedException ie) {
            handleException(ie, "Wait got interrupted");
        }
    }

    /**
     * Scroll element using Javascritp
     * @param element
     */
    public void scroll_to_view_element(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
    }
}
