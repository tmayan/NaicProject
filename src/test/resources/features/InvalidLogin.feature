Feature: Login into Naic website

  As a user
  I should be able to see error message when enter the invalid credentials

  Scenario:Login with invalid credentials
    Given user is at the login page
    When user enter the invalid password and credentials
    Then user should able to see error message with "Login failed, please try again."


