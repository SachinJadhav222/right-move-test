package com.rmtest.pages;

import com.rmtest.DriverBase;
import com.rmtest.WebUtility;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Search Results
 * @author SJadhav
 */
public class SearchResults extends DriverBase {

  WebUtility webUtility;

    public SearchResults(WebUtility webUtility)
    {
        this.webUtility = webUtility;
    }

    Logger logger = Logger.getLogger("SearchResults");
    String property_details=null;

    /**
     * Search Result Page Elements
     */
    @FindBy(css = "h1.searchTitle-heading")
    private WebElement search_title;
    @FindBy(css = "select#sortType")
    private WebElement sort_order_list;
    @FindBy(css = "div[data-test='propertyCard-1']>div>div>a")
    private WebElement first_non_featured_property;
    @FindBy(css="div[data-test='propertyCard-1']>div>div>div>div>a>h2")
    private WebElement property_title;
    @FindBy(css="div[class='left']>h1")
    private WebElement displayed_property_heading;

    @FindBy(css="div[id='l-searchResults'] div[class='l-searchResult is-list']")
    List<WebElement> listOfProperties;


    /**
     * Verify Search is displayed
     */
    public boolean verify_search_result_displayed()
    {
        boolean is_search_displayed = false;
        String search_heading = search_title.getText();
        String sale_title = "For Sale";
        String rent_title = "To Rent";
        if (search_heading.contains(sale_title) || search_heading.contains(rent_title))
        {
            is_search_displayed = true;
            logger.info("Search Result Displayed");
        }
        return is_search_displayed;
    }

    /**
     * Select Sort Order
     *
     * @param sort_order
     */
    public void select_sort_order(String sort_order)
    {
        webUtility.select_dropdown_by_visible_text(sort_order_list, sort_order);
        logger.info("Sort Order Selected : " + sort_order);
    }

    /**
     * Click on Frist NON feature property
     */
    public void click_on_non_featured_property()
    {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", first_non_featured_property);
        webUtility.waitForSeconds(2);
        property_details=property_title.getText();
        first_non_featured_property.click();
        logger.info("Clicked on First NON Featured property");
    }

    /**
     * Verify if the list of properties displayed
     * @return
     */
    public boolean list_of_properties_visible_on_page()
    {
        boolean is_properties_displayed= false;
        if (listOfProperties!=null)
        {
            if (listOfProperties.size() >= 1)
            {
                logger.info("There is atleast 1 property visible on the page");
                is_properties_displayed= true;
            }
        }
       if (logger.isInfoEnabled())
            {
                logger.info("There is no property on this page");
            }

        return is_properties_displayed;
    }

    /**
     * Verify property detaisl are displayed after clicking the property in the search list
     * @return
     */
    public boolean verify_property_dsplayed(){
        boolean is_property_displayed=false;
        logger.info(property_details);
        logger.info(displayed_property_heading.getText());
        if(displayed_property_heading.getText().contains(property_details)){
            is_property_displayed=true;
            logger.info("Property Displayed :"+property_details);
        }
        return is_property_displayed;
    }
}

