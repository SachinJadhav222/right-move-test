@search_for_rent
Feature: Search the property for rent
  As a user
  I want to search property for rent

  Background:
    Given I Check and Verify that I am on "Home" Page

  @rm
  Scenario: User search the property for sale in Area
    Then I enter the location "RM8"
    Then I click on "To rent" Button
    Then I Check and Verify that I am on "Letting Filter" Page
    Then I select search radius "Within 1 mile"
    Then I select Price range minimum: "500 PCM" and maximum : "1,500 PCM"
    Then I select No of rooms minimum:"1"  and maximum: "3"
    Then I select Property Types "Houses"
    Then I click on "Find Property" Button
    Then I Check and Verify that search result displayed with location "RM8"
    Then I change sort order to "Lowest Price"
    Then I select first Non Featured Property



