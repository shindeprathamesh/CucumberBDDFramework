Feature: Add to cart

  Scenario: Add one quantity from store
    Given User is on the Store Page
    When User adds a "Blue Shoes" to the cart
    Then User should see 1 "Blue Shoes" in the cart
