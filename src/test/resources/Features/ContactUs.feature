Feature: Contact Us form submission

  Scenario: User submits the contact form with details and file upload
    Given the user launches the browser and navigates to the website
    When the user should see the home page successfully
    And the user clicks on the Contact Us button
    And the user should see GET IN TOUCH visible
    And the user enters name, email, subject and message
    And the user clicks the Submit button
    And the user accepts the alert
    And the user should see the success message
    And the user clicks the Home button
    Then the user should be navigated to the home page successfully
