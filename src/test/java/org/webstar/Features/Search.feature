Feature: Search Product
@OfferPage
  Scenario Outline: Search experience for product search in both name and offers page
    Given user is on the landing page
    When user searches with shortname <name> and extracts actual name of product
    When user navigates to offer page
    Then user should find the same product in the offers page by searching <name>
    And validate product name in offers page matches the one in landing page

    Examples:
      | name |
      | Tom  |
      | Beet |