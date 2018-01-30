package rightMove.stepDefinitions;

import rightMove.PageObjects.PageAssertions;
import rightMove.PageObjects.RM_Search_Results_Page;
import rightMove.PageObjects.RM_Search_filters;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import rightMove.PageObjects.RM_HomePage;

public class Search_steps {
    PageAssertions pageAssertions;
    RM_HomePage rm_homePage;
    RM_Search_filters rm_search_filters;
    RM_Search_Results_Page rm_search_results_page;
    Steps_hooks hooks;

    public Search_steps(Steps_hooks hooks) {
        pageAssertions=hooks.pageAssertions;
        rm_homePage = hooks.rm_homePage;
        rm_search_filters = hooks.rm_search_filters;
        rm_search_results_page = hooks.rm_search_results_page;
        this.hooks = hooks;
    }

    @Given("^I Check and Verify that I am on \"([^\"]*)\" Page$")
    public void iCheckAndVerifyThatIAmOnPage(String page_name) {
   Assert.assertTrue(pageAssertions.assert_page(page_name));
    }

    @Then("^I enter the location \"([^\"]*)\"$")
    public void iEnterTheLocation(String location) {
        rm_homePage.enter_location_to_search_box(location);
    }

    @Then("^I click on \"([^\"]*)\" Button$")
    public void iClickOnButton(String sale_rent_button) {
        rm_homePage.click_sales_or_rent_button(sale_rent_button);
    }

    @Then("^I select search radius \"([^\"]*)\"$")
    public void iSelectSearchRadius(String radius) {
        rm_search_filters.select_radius(radius);
    }

    @Then("^I select Price range minimum: \"([^\"]*)\" and maximum : \"([^\"]*)\"$")
    public void iSelectPriceRangeMinimumAndMaximum(String min_price, String max_price) {
        rm_search_filters.select_price_range(min_price, max_price);
    }

    @Then("^I select No of rooms minimum:\"([^\"]*)\"  and maximum: \"([^\"]*)\"$")
    public void iSelectNoOfRoomsMinimumAndMaximum(String min_room, String max_room) {
        rm_search_filters.select_no_of_bedrooms(min_room, max_room);
    }

    @Then("^I select Property Types \"([^\"]*)\"$")
    public void iSelectPropertyTypes(String property_type) {
        rm_search_filters.select_type_of_property(property_type);
    }


    @Then("^I change sort order to \"([^\"]*)\"$")
    public void iChangeSortOrderTo(String sort_order) {
        rm_search_results_page.select_sort_order(sort_order);
    }

    @Then("^I select first Non Featured Property$")
    public void iSelectFirstNonFeaturedProperty() {
rm_search_results_page.click_on_non_featured_property();
    }


    @Then("^I Check and Verify that search result displayed with location \"([^\"]*)\"$")
    public void iCheckAndVerifyThatSearchResultDisplayedWithLocation(String location)  {
        Assert.assertTrue(rm_search_results_page.verify_search_displayed_with_location(location));
    }
}
