Feature: Place Orders
  Scenario: Search experience for product search in both name and offers page
    Given user is on the landing page
    When user searches with shortname "Tom" and extracts actual name of product
    Then user should find the same product in the offers page by using the shortname