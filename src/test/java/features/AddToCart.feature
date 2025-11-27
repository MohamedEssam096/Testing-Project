Feature: Shopping Cart Functionality

  @TC05_AddToCart
  Scenario: Add Products to Cart
    Given user is on the homepage
    When user clicks on 'Signup / Login' button
    And user enters correct email "1764095802421magid_test2025@example.com" and password "Password123"
    And user clicks 'Login' button
    Then 'Logged in as username' text should be visible at top header

    When user clicks on 'Products' button
    And user clicks on 'View Product' for the first product
    And user clicks 'Add to cart' button
    And user clicks 'View Cart' link in the modal
    Then the product should be visible in the cart page