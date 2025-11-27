Feature: User Logout Functionality

  @TC03_Logout
  Scenario: Logout User
    # 1. خطوات تسجيل الدخول (Pre-condition)
    Given user is on the homepage
    When user clicks on 'Signup / Login' button
    And user enters correct email "1764095802421magid_test2025@example.com" and password "Password123"
    And user clicks 'Login' button
    Then 'Logged in as username' text should be visible at top header

    # 2. خطوات تسجيل الخروج (Test Steps)
    When user waits for 5 seconds
    And user clicks on 'Logout' button
    Then user should be redirected to the login page