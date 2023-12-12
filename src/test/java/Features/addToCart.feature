
Feature: Sauce Demo Page | Add to cart

  Scenario Outline: Navigate to home screen
    Given Navigate to Sauce Demo site
    When User is able to enter "<username>" in username field
    When User is able to enter "<password>" in password field
    Then User is able to see Logo on home page
    Then User is able to add "<product_name>" to cart
    And User is able to see "<product_name>" in the cart
    And Close the browser
    Examples:
      | username      | password     |  product_name          |
      | standard_user | secret_sauce |  Sauce Labs Backpack   |
      | standard_user | secret_sauce |  Sauce Labs Bike Light |