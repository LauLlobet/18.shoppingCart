Feature: Cart
  Scenario Outline: Items are added to the shopping cart
    Given a shopping cart
    Given that the database has item "The Hobbit" at 5 euros
    Given that the database has item "Breaking Bad" at 7 euros
    Given I add <hobbits> units of "The Hobbit" to the cart of "John"
    Given I add <bb> units of "Breaking Bad" to the cart of "John"
    When I get the basket of "John"
    Then the basket price is <price>

    Examples:
      | hobbits | bb  | price |
      |   0     |  0  |  0    |
      |   0     |  2  |  14   |
      |   1     |  0  |  5    |
      |   2     |  5  |  45   |