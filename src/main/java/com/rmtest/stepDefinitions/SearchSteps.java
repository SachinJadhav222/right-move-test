package com.rmtest.stepDefinitions;

import com.rmtest.pages.HomePage;
import com.rmtest.pages.SearchResults;
import com.rmtest.pages.SearchFilters;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

/**
 * Step Definitions for cucumber files
 * @author SJadhav
 */
public class SearchSteps {

    HomePage homePage;
    SearchFilters searchFilters;
    SearchResults searchResults;
    // Hooks hooks;

    public SearchSteps(HomePage homePage, SearchFilters searchFilters, SearchResults searchResults) {
        this.homePage = homePage;
        this.searchFilters = searchFilters;
        this.searchResults = searchResults;
        // this.hooks = hooks;
    }

    @Then("^I enter the location \"([^\"]*)\"$")
    public void iEnterTheLocation(String location) {
        homePage.enter_location_to_search_box(location);
    }

    @Then("^I click on \"([^\"]*)\" Button$")
    public void iClickOnButton(String button_name) {
        homePage.click_on_button(button_name);
       // homePage.click_button_of_choice(button_name);
    }

    @Then("^I select search radius \"([^\"]*)\"$")
    public void iSelectSearchRadius(String radius) {
        searchFilters.select_radius(radius);
    }

    @Then("^I select Price range minimum: \"([^\"]*)\" and maximum : \"([^\"]*)\"$")
    public void iSelectPriceRangeMinimumAndMaximum(String min_price, String max_price) {
        searchFilters.select_price_range(min_price, max_price);
    }

    @Then("^I select No of rooms minimum:\"([^\"]*)\"  and maximum: \"([^\"]*)\"$")
    public void iSelectNoOfRoomsMinimumAndMaximum(String min_room, String max_room) {
        searchFilters.select_no_of_bedrooms(min_room, max_room);
    }

    @Then("^I select Property Types \"([^\"]*)\"$")
    public void iSelectPropertyTypes(String property_type) {
        searchFilters.select_type_of_property(property_type);
    }


    @Then("^I change sort order to \"([^\"]*)\"$")
    public void iChangeSortOrderTo(String sort_order) {
        searchResults.select_sort_order(sort_order);
    }

    @Then("^I select first Non Featured Property$")
    public void iSelectFirstNonFeaturedProperty() {
        searchResults.click_on_non_featured_property();
    }

    @Then("^I can see the list of properties$")
    public void iCanSeeTheListOfProperties() {
        Assert.assertTrue(searchResults.list_of_properties_visible_on_page());
    }


    @And("^I land successfully on property page$")
    public void iLandSuccessfullyOnPropertyPage() {
  Assert.assertTrue(searchResults.verify_property_dsplayed());
    }

    @Given("^I am on \"([^\"]*)\" Page$")
    public void iAmOnPages(String page_name) {
        switch (page_name) {
            case "Home": {
              Assert.assertTrue(homePage.verify_home_page());
                break;
            }
            case "Letting Filter": {
             Assert.assertTrue(searchFilters.verify_letting_filters_displayed());
                break;
            }
            case "Sales Filter": {
             Assert.assertTrue(searchFilters.verify_sale_filters_displayed());
                    break;
            }
            case "Search Result":{
             Assert.assertTrue(searchResults.verify_search_result_displayed());
                break;
            }
            }

        }
    }
