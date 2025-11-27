Feature: Place Order Functionality

  @TC06_PlaceOrder
  Scenario: Place Order: Login and Purchase
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

    When user clicks 'Proceed To Checkout' button
    And user enters description in comment area "Order placed by Magid" and clicks 'Place Order'
    And user enters payment details: Name "Magid", CardNumber "123456789012", CVC "311", Expiration "12" and "2025"
    And user clicks 'Pay and Confirm Order' button
    Then the order success message "ORDER PLACED!" should be visible