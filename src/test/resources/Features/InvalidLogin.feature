Feature: Invalid Login Functionality

  Scenario: Login with incorrect email and password
    Given the user launches the browser and navigates to the website
    When the user clicks on the Signup Login button
    And the Login to your account message should be visible
    And the user enters incorrect email address and password
    And clicks the login button
    Then an error message Your email or password is incorrect should be visible
