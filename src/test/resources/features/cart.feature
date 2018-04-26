Feature: Cart
  Scenario: Items are added to the shopping cart
    Given a shopping cart
    Given I add 2 units of "The Hobbit" to the cart of "John"
    Given I add 5 units of "Breaking Bad" to the cart of "John"
    When I get the basket of "John"
    Then the basket price is 45

