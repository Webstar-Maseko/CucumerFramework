Feature: Cart
  @PlaceOrder
  Scenario Outline: User add items to cart and checks out
    Given user is on the landing page
    When user searches with shortname <name> and extracts actual name of product
    Then user increases the cart quantity by "3" and add items to cart
    And user view the cart and proceeds to checkout
    Then verify the product name in the cart matches the one that was searched

    Examples:
      |name|
      |Tomato|
      |Beet  |
