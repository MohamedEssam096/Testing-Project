Feature: User Registration Functionality

  @TC01_Register
  Scenario: TC01 User Registration Flow
    Given user is on the homepage
    When user clicks on 'Signup / Login' button
    And user enters valid name "Magid" and email address "magid_test2025@example.com"
    And user clicks 'Signup' button
    And user fills valid details in the registration form
    And user clicks 'Create Account' button
    Then 'ACCOUNT CREATED!' message should be visible
    When user clicks 'Continue' button
    Then user should be redirected to the homepage