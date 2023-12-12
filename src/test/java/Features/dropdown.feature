Feature: The dropdown functionality

  @s1
 Scenario Outline: Verify the dropdown functionality on sauce demo using sendkeys()
    Given Navigate to Sauce Demo site
    When User is able to enter "<username>" in username field
    When User is able to enter "<password>" in password field
    Then User is able to see Logo on home page
    Then User is able to change item sorting dropdown using SendKeys
    And Close the browser

    Examples:
      | username      | password     |  product_name          |
      | standard_user | secret_sauce |  Sauce Labs Backpack   |
      | standard_user | secret_sauce |  Sauce Labs Bike Light |
@s2
  Scenario: Verify the dropdown functionality on sauce demo using select class
    Given Navigate to Sauce Demo site
    When User is able to Login with credentials
    Then User is able to see Logo on home page
    Then User is able to change item sorting dropdown using select class
    And Close the browser