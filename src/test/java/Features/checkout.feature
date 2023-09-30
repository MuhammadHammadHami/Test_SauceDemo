Feature: Checkout Flow
  Scenario Outline: Check user is able to login or not
    Given Navigate to Sauce Demo site for checkout
    When User is able to enter "<username>" in username field for checkout
    When User is able to enter "<password>" in password field for checkout
    Then User is able to see Logo on home page for checkout
    Then User is able to add "<product_name>" to cart for checkout
    And User is able to see "<product_name>" in the cart for checkout
    Then User is able to navigate to checkout page for checkout
    Then User is able to fill checkout information
    | firstname  | lastname  |  zipCode  |
    | demo       | user      |  12345     |
    | demo123    | user123   |  54321     |

    Then User is able to place order
    And Close the browser after checkout
    Examples:
      | username      | password     |  product_name          |
      | standard_user | secret_sauce |  Sauce Labs Backpack   |
      | standard_user | secret_sauce |  Sauce Labs Bike Light   |

