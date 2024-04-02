Feature: Login tests

  Scenario: Log to website - correct credentials
#    Given I open browser
    And I go to login page
    When I type login "tomsmith"
    And I type password "SuperSecretPassword!"
    And I click login button
    Then I am logged in

  Scenario: Log to website - incorrect credentials
#    Given I open browser
    And I go to login page
    When I type login "tomsmith"
    And I type password "IncorrectPassword"
    And I click login button
    Then I am not logged in

    #'Scenario Outline:' - Scenariusz uniwersalny służący do parametryzacji wartości (zamiast tych dwóch scenariuszy powyżej), wartościami będą parametry
    # wpisanie parametrów: "<nazwa_parametru>"
    # poniżej też parametry
    # tabelka z Examples zrobić można ręcznie, albo sam Selenium utworzy schemat tabelki za pomocą 'Alt + Enter' na podkreślonym na czerwono 'Scenario Outline:', ale nie może byc jeszcze nawet słowa 'Examples'

  Scenario Outline: Check credentials
#    Given I open browser
    #usunąłem powyższy krok, bo użyłem "@Before' w definicjach kroków ('LoginSteps.java')
    Given I go to login page
    # w wierszu powyżej Given zastąpił And, dlatego w LoginSteps
    When I type login "<login>" and password "<password>"
# usunąłem trzy poniższe kroki zastępując je jednym krokiem powyższym, to co robię to jest 'refactoring'
  #    When I type login "<login>"
#    And I type password "<password>"
#    And I click login button
    Then <expectedResult>
    Examples:
      | login    | password             | expectedResult     |
      | tomsmith | SuperSecretPassword! | I am logged in     |
      | tomsmith | IncorrectPassword    | I am not logged in |