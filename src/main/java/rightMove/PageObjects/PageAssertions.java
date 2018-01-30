package rightMove.PageObjects;

import rightMove.browserFactory.RM_DriverBase;

/**
 * Page Assertion and Verification
 */
public class PageAssertions extends RM_DriverBase {
    public  boolean assert_page(String page_name){
        boolean is_page_displayed=false;
        switch (page_name) {
            case "Home": {
                is_page_displayed=new RM_HomePage().verify_home_page();
                break;
            }
            case "Sales Filter": {
              is_page_displayed=new RM_Search_filters().verify_sale_filters_displayed();
                break;
            }
            case "Letting Filter": {
            is_page_displayed=new RM_Search_filters().verify_letting_filters_displayed();
                break;
            }
        }
        return is_page_displayed;
    }
}

