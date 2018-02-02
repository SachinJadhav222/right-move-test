package com.rmtest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Utility Class for Reusable Methods
 * @author SJadhav
 */
public class WebUtility extends DriverBase {
    private WebDriverWait wait;

    /**
     * Webdriver waits
     * @return
     */
    public WebDriverWait waitFor() {
        return wait;
    }

    public void select_dropdown_by_visible_text(WebElement element, String visible_text) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(visible_text);
    }

    /**
     * wait for the element till it is visible
     * @param element
     * @return
     */
    public WebElement waitForElementToBeVisible(WebElement element) {
        return waitFor().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waitn for the element till it is clickable
     * @param element
     * @return
     */
    public WebElement waitForElementToBeClickable(WebElement element) {
        return waitFor().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Exception Handling
     * @param e
     * @param message
     */
    public void handleException(Exception e, String message) {
        if (logger.isInfoEnabled()) {
            logger.info(message);
            e.printStackTrace();
        }
    }

    /**
     * Enternal waits (not recommended to use unless is very needed)
     * @param seconds
     */
    public void waitForSeconds(double seconds) {
        try {
            Thread.sleep(new Double((seconds * 1000)).longValue());
        } catch (InterruptedException ie) {
            handleException(ie, "Wait got interrupted");
        }
    }
}
