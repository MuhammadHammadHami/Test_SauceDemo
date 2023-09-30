@s1

# 1st Login with data from the function
Feature: Sauce Demo Page
  Scenario: Navigate to home screen
    Given Navigate to Sauce Demo site
    When User is able to Login with credentials
    Then User is able to see Logo on home page
    And Close the browser

# This text case will run 2 times
# 1st Login with valid credentials
# 2nd Login with invalid credentials
    @login
  Scenario Outline: Check user is able to login or not
    Given Navigate to Sauce Demo site
    When User is able to enter "<username>" in username field
    When User is able to enter "<password>" in password field
    Then User is able to see Logo on home page
    And Close the browser
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | abc           | abc          |