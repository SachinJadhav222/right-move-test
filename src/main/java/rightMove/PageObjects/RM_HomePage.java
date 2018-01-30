package rightMove.PageObjects;

import rightMove.browserFactory.RM_DriverBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RM_HomePage extends RM_DriverBase {
    Logger logger = Logger.getLogger("RM_HomePage");
    /**
     * WebElements of Home Page (@FindBy using Page Factory)
     */
    @FindBy(css = "a.globalHeader-logo")
    private WebElement go_to_homepage;
    @FindBy(css = "input#searchLocation")
    private WebElement search_text_box;
    @FindBy(css = "button#buy")
    private WebElement for_sale_button;
    @FindBy(css = "button#rent")
    private WebElement to_rent_button;

    /**
     * Verify Home Page
     */
    public boolean verify_home_page() {
        boolean is_home_page_displayed = false;
        try {
            if (driver.getTitle().contains("Rightmove - UK's number one property website for properties for sale and to rent")) {
                is_home_page_displayed = true;
                logger.info("page: Home");
            }
        } catch (Exception e) {
            go_to_homepage.click();

            // if(driver.getTitle().contains("Rightmove - UK's number one property website for properties for sale and to rent"))
            {
                is_home_page_displayed = true;
                logger.info("page: Home");
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

    /**
     * Click on Button (for sale, to rent or find property button
     *
     * @param sales_rent_button
     */
    public void click_sales_or_rent_button(String sales_rent_button) {
        switch (sales_rent_button) {
            case "For sale": {
                for_sale_button.click();
                logger.info("Clicked on Sales");
                break;
            }
            case "To rent": {
                to_rent_button.click();
                logger.info("Clicked on Rent");
                break;
            }
            case "Find Property": {
                new RM_Search_filters().click_on_find_property_button();
                break;
            }
        }
    }

}
