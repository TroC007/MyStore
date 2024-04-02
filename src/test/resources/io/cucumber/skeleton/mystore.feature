Feature: MyStore Addresses Tests

  Scenario: New address
    Given I go to log page
    And I log in
    When I choose addresses tile
    And I create new address
    And I type new data
    And I check written data
    When I delete address
    And I verify deleting


#  Scenario Outline: Check written data