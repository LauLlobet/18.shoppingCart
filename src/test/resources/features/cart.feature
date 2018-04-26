Feature: Cart

  Background:

    Given a user of a shopping basket "John"
    And a "The Hobbit" product is avaliable at 5 euros
    And a "Breaking Bad" product is avaliable at 7 euros

  Scenario Outline: Items are added to the shopping cart

    Given I add <hobbitunits> units of "The Hobbit" to the shopping basket
    And I add <breakingbadunits> units of "Breaking Bad" to the shopping basket
    When I check the content of the shopping basket
    Then it contains the following price:<price>

    Examples:
      | hobbitunits | breakingbadunits  | price |
      |   0          |  0               |  0    |
      |   0          |  2               |  14   |
      |   1          |  0               |  5    |
      |   2          |  5               |  45   |

