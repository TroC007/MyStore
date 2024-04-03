Feature: MyStore Addresses Tests

  Scenario Outline: Check written data
    Given I go to log page
    And I log in
    When I choose addresses tile
    And I create new address
    And I type new data "<alias>" "<address>" "<city>" "<postal>"
    And I check written data
    When I delete address
    And I verify deleting
    Examples:
      | alias    | address   | city      | postal |
      | Spokojny | Wieczna 5 | Wieliczka | 32-998 |