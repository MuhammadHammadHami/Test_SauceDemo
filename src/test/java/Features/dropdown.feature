Feature: The dropdown functionality

  @s1
  Scenario: Verify the dropdown functionality on sauce demo using sendkeys()
    Given Navigate to Sauce Demo site
    When User is able to Login with credentials
    Then User is able to see Logo on home page
    Then User is able to change item sorting dropdown using SendKeys
    And Close the browser
@s2
  Scenario: Verify the dropdown functionality on sauce demo using select class
    Given Navigate to Sauce Demo site
    When User is able to Login with credentials
    Then User is able to see Logo on home page
    Then User is able to change item sorting dropdown using select class
    And Close the browser