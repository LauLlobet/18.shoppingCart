Feature: Cart
  Scenario Outline: Items are added to the shopping cart

    Given a shopping cart service
    And the inventory has item "The Hobbit" at 5 euros
    And the inventory has item "Breaking Bad" at 7 euros

    When I add <hobbits> units of "The Hobbit" to the cart of "John"
    And I add <bb> units of "Breaking Bad" to the cart of "John"

    And I get the basket of "John"
    Then the basket price is <price>

    Examples:
      | hobbits | bb  | price |
      |   0     |  0  |  0    |
      |   0     |  2  |  14   |
      |   1     |  0  |  5    |
      |   2     |  5  |  45   |

  Scenario:

    Given a shopping cart service
    When I get the basket of "John"
    Then the basket price is 0
