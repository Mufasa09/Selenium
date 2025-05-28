Feature: Google Search


  Scenario: Search for 'TestNG Cucumber Integration'
    Given I am on the Google homepage
    When I search for "TestNG Cucumber Integration"
    Then search results should be shown
    |key|value|
    |results|Integration of Cucumber with Selenium and TestNG|

