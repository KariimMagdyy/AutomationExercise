Feature: Logout functionality

  Scenario: User logs in with correct email and password then return back to login page
    Given the user launches the browser and navigates to the website
    When the user clicks on the Signup Login button
    And the Login to your account message should be visible
    And the user enters a valid email address and password
    And clicks the login button
    And the message Logged in as username should be visible
    And the user clicks the logout button
    Then the user returns back to login page
