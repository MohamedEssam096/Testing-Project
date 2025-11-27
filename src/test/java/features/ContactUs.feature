Feature: Contact Us Functionality

  @TC04_ContactUs
  Scenario: Submit Contact Us Form
    Given user is on the homepage

    When user clicks on 'Signup / Login' button
    And user enters correct email "1764095802421magid_test2025@example.com" and password "Password123"
    And user clicks 'Login' button
    Then 'Logged in as username' text should be visible at top header

    When user clicks on 'Contact Us' button
    And user enters name "Magid", email "magid_test2025@example.com", subject "Subject Test" and message "This is a test message"
    And user uploads a file
    And user clicks 'Submit' button
    And user clicks OK button on the alert popup
    Then success message 'Success! Your details have been submitted successfully.' should be visible