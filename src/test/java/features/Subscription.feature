Feature: Subscription Functionality

  @TC07_Subscription
  Scenario: Verify Subscription in Home Page
    Given user is on the homepage
    When user clicks on 'Signup / Login' button
    And user enters correct email "1764095802421magid_test2025@example.com" and password "Password123"
    And user clicks 'Login' button
    Then 'Logged in as username' text should be visible at top header

    When user scrolls down to footer
    And user enters valid email address "magid_sub@example.com" in subscription input
    And user clicks the arrow button
    Then subscription success message 'You have been successfully subscribed!' should be visible