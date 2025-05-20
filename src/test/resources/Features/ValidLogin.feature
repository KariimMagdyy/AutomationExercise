Feature: Valid Login and Delete Account

  Scenario: User logs in and deletes their account successfully
    Given the user launches the browser and navigates to the website
    When the user clicks on the Signup Login button
    And the Login to your account message should be visible
    And the user enters a valid email address and password
    And clicks the login button
    And the message Logged in as username should be visible
    And the user clicks the Delete Account button
    Then the message ACCOUNT DELETED should be visible