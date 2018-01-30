package rightMove.PageObjects;

import rightMove.browserFactory.RM_DriverBase;
import rightMove.browserFactory.WebUtility;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RM_Search_Results_Page extends RM_DriverBase {
    Logger logger = Logger.getLogger("RM_Search_Results_Page");
    /**
     * Search Result Page Elements
     */
    @FindBy(css = "h1.searchTitle-heading")
    private WebElement search_title;
    @FindBy(css = "select#sortType")
    private WebElement sort_order_list;
    @FindBy(xpath = "//div[@data-test='propertyCard-1']")
    private WebElement first_non_featured_property;

    /**
     * Verify Search is displayed
     */
    public boolean verify_search_displayed_with_location(String location) {
        boolean is_search_displayed = false;
        String search_heading = search_title.getText();
        String sale_title = "For Sale in " + location;
        String rent_title = "To Rent in " + location;
        if (search_heading.contains(sale_title) || search_heading.contains(rent_title)) {
            is_search_displayed = true;
            logger.info("Search Result Displayed with Location " + location);
        }
        return is_search_displayed;
    }

    /**
     * Select Sort Order
     *
     * @param sort_order
     */
    public void select_sort_order(String sort_order) {
        WebUtility.select_dropdown_by_visible_text(sort_order_list, sort_order);
        logger.info("Sort Order Selected : " + sort_order);
    }

    public void click_on_non_featured_property(){
        first_non_featured_property.click();
        logger.info("Clicked on Frist NON Featured property");
    }


}

