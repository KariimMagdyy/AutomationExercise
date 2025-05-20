Feature: User Registration and Deletion on Automation Exercise

  Scenario: Register and delete user account successfully
    Given the user launches the browser and navigates to the website
    When the user should see the home page successfully
    And the user clicks on Signup Login button
    And the user should see New User Signup text
    And the user enters name and email address
    And the user clicks the Signup button
    And the user should see ENTER ACCOUNT INFORMATION section
    And the user fills account details, checkboxes and address details
    And the user clicks the Create Account button
    And the user should see ACCOUNT CREATED message
    And the user clicks the Continue button
    And the user should see Logged in as username
    And the user clicks the Delete Account button
    And the user should see ACCOUNT DELETED message
    And the user clicks the Continue button
    Then the user should see the home page again

