package com.rmtest.pages;

import com.rmtest.DriverBase;
import com.rmtest.WebUtility;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;


public class HomePage extends DriverBase {
    WebUtility webUtility;
    SearchFilters searchFilters;
    SearchResults searchResults;

    public HomePage(WebUtility webUtility, SearchFilters searchFilters, SearchResults searchResults) {
        this.webUtility = webUtility;
        this.searchFilters = searchFilters;
        this.searchResults = searchResults;
    }

    Logger logger = Logger.getLogger("HomePage");
    /**
     * WebElements of Home Page (@FindBy using Page Factory)
     */
    @FindBy(css = "img[id='rm-site-logo']")
    private WebElement go_to_homepage;
    @FindBy(css = "span[class='block strapline-intro']")
    WebElement homepage_status;
    @FindBy(css = "input#searchLocation")
    private WebElement search_text_box;
    @FindBy(css = "button#buy")
    private WebElement for_sale_button;
    @FindBy(css = "button#rent")
    private WebElement to_rent_button;


    @FindBy(css = "button[type='submit']")
    List<WebElement> buttons;


    /**
     * Verify Home Page
     */
    public boolean verify_home_page() {
        boolean is_home_page_displayed = false;
        String homeText = "Find your Happy";
        try {
            if (homepage_status.getText().trim().equalsIgnoreCase(homeText)) {
                is_home_page_displayed = true;
                logger.info("Home Page Displayed");
            }
        } catch (Exception e) {
            go_to_homepage.click();
            if (homepage_status.getText().trim().equalsIgnoreCase(homeText)) {
                is_home_page_displayed = true;
                logger.info("Home Page Displayed");
            }
        }
        return is_home_page_displayed;
    }

    /**
     * Enter Location to the Search Box
     *
     * @param location
     */
    public void enter_location_to_search_box(String location) {
        search_text_box.sendKeys(location);
        logger.info("Location Entered: " + location);
    }

    public void click_on_button(String name_of_button) {
        switch (name_of_button) {
            case "For sale": {
                for_sale_button.click();
                break;
            }
            case "To rent": {
                to_rent_button.click();
                break;
            }
            case "Find properties": {
                searchFilters.click_on_find_property_button();
                break;
            }
        }
    }

    /**
     * Click of Button
     *
     * @param name_of_button
     */
    public void click_button_of_choice(String name_of_button) {
        webUtility.waitForSeconds(2);
        for (WebElement specific_button : buttons) {
                if (specific_button.getText().trim().equalsIgnoreCase(name_of_button)) {
                    specific_button.click();
                }
        }
    }
}
