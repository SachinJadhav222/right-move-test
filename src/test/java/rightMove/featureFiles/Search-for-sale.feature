@search_for_sale
Feature: Search the property for sale
  As a user
  I want to search property for sale

  Background:
    Given I Check and Verify that I am on "Home" Page

  @rm
  Scenario: User search the property for sale in Area
    Then I enter the location "RM8"
    Then I click on "For sale" Button
    Then I Check and Verify that I am on "Sales Filter" Page
    Then I select search radius "Within 1 mile"
    Then I select Price range minimum: "50,000" and maximum : "500,000"
    Then I select No of rooms minimum:"1"  and maximum: "3"
    Then I select Property Types "Houses"
    Then I click on "Find Property" Button
    Then I Check and Verify that search result displayed with location "RM8"
    Then I change sort order to "Newest Listed"
    Then I select first Non Featured Property



