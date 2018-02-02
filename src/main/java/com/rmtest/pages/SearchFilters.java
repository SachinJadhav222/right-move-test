package com.rmtest.pages;

import com.rmtest.DriverBase;
import com.rmtest.WebUtility;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchFilters extends DriverBase {
    WebUtility webUtility;
    public SearchFilters(WebUtility webUtility)
    {
        this.webUtility = webUtility;
    }
    Logger logger = Logger.getLogger("SearchFilters");

    /**
     * Search Filter Page Elements using Page Factory
     */
    @FindBy(css = "button#submit")
    private WebElement find_property_button;
    @FindBy(css = "select#radius")
    private WebElement radius_dropdown;
    @FindBy(css = "select#minPrice")
    private WebElement price_range_min;
    @FindBy(css = "select#maxPrice")
    private WebElement price_range_max;
    @FindBy(css = "select#minBedrooms")
    private WebElement no_of_bedroom_min;
    @FindBy(css = "select#maxBedrooms")
    private WebElement no_of_bedroom_max;
    @FindBy(css = "select#displayPropertyType")
    private WebElement type_of_property;
    @FindBy(css = "select#maxDaysSinceAdded")
    private WebElement added_to_site;

    @FindBy(css="div#buyingsearchcriteria")
    private WebElement sales_filter_page;
    @FindBy(css="div#lettingsearchcriteria")
    private WebElement letting_filter_page;



    public  boolean verify_sale_filters_displayed(){
        boolean is_sales_filters_displayed=false;
        if(sales_filter_page.isDisplayed()){
            is_sales_filters_displayed=true;
            logger.info("Sales Filter Displayed");
        }
        return is_sales_filters_displayed;
    }
    public  boolean verify_letting_filters_displayed(){
        boolean is_letting_filters_displayed=false;
        if(letting_filter_page.isDisplayed()){
            is_letting_filters_displayed=true;
            logger.info("Letting Filter Displayed");
        }
        return is_letting_filters_displayed;
    }
    /**
     * Find Property Button
     */
    public void click_on_find_property_button() {
        find_property_button.click();
        logger.info(" Clicked on Find Property Button");
    }

    /**
     * Select Radius
     *
     * @param radius
     */
    public void select_radius(String radius) {
        webUtility.select_dropdown_by_visible_text(radius_dropdown, radius);
        logger.info("Search Radius selected: " + radius);
    }

    /**
     * Select Min and Max Price Rage
     *
     * @param min_price
     * @param max_price
     */
    public void select_price_range(String min_price, String max_price) {
        webUtility.select_dropdown_by_visible_text(price_range_min, min_price);
        logger.info("Min Price Selected: " + min_price);
        webUtility.select_dropdown_by_visible_text(price_range_max, max_price);
        logger.info("Max Price Selected: " + max_price);
    }

    /**
     * Select No of Bed Rooms
     *
     * @param min_room
     * @param max_room
     */
    public void select_no_of_bedrooms(String min_room, String max_room) {
        webUtility.select_dropdown_by_visible_text(no_of_bedroom_min, min_room);
        logger.info("Min Bed Rooms Selected: " + min_room);
        webUtility.select_dropdown_by_visible_text(no_of_bedroom_max, max_room);
        logger.info("Max Bed Rooms Selected: " + max_room);
    }

    /**
     * Selcttype of property
     *
     * @param property_type
     */
    public void select_type_of_property(String property_type) {
        webUtility.select_dropdown_by_visible_text(type_of_property, property_type);
        logger.info("Type of property selected: " + property_type);
    }

    /**
     * Select when is the property added to the website
     *
     * @param when_added
     */
    public void select_when_added_to_site(String when_added) {
        webUtility.select_dropdown_by_visible_text(added_to_site, when_added);
        logger.info("Select whne property added to the site: " + when_added);
    }
}
