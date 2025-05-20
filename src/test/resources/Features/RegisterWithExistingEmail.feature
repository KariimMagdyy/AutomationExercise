Feature: Register User with an existing email

  Scenario: user enters name and already registered email then an error should appears
    Given the user launches the browser and navigates to the website
    When the user clicks on the Signup Login button
    And the user should see New User Signup text
    And the user enters name and email address
    And the user clicks the Signup button
    Then Error Email Address already exist is visible