Feature: Belly

  Scenario: a few cukes
    Given I have 54 cukes in my belly
    When I wait 1 hour
    Then my belly should growl
