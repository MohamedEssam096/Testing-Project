Feature: User Login Functionality

  @TC02_Login @Positive
  Scenario: Login User with correct email and password
    Given user is on the homepage
    When user clicks on 'Signup / Login' button
    And user enters correct email "1764095802421magid_test2025@example.com" and password "Password123"
    And user clicks 'Login' button
    Then 'Logged in as username' text should be visible at top header

  @TC02_Login @Negative
  Scenario: Login User with incorrect email and password
    Given user is on the homepage
    When user clicks on 'Signup / Login' button
    And user enters incorrect email "wrongemail@example.com" and password "WrongPass123"
    And user clicks 'Login' button
    Then error message "Your email or password is incorrect!" should be visible