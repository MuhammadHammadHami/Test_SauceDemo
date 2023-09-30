
Feature: Sauce Demo Page | Add to cart

  Scenario Outline: Navigate to home screen
    Given Navigate to Sauce Demo site
    When User is able to Login with credentials
    Then User is able to see Logo on home page
    Then User is able to add "<product_name>" to cart
    And User is able to see "<product_name>" in the cart
    And Close the browser
    Examples:
      | product_name          |
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |