Feature: normal click
  As a player
  I want to click normally on this game

  Background:
    Given player play a fastClickGame

  Scenario: 1 playing normal click
    When player click as 1.00 sec
    Then time arrays contain 1.00

  Scenario: 2 playing normal click
    When player click as 2.2 sec
    And try again with 2.3 sec
    Then time arrays contain 2.3
    And time arrays not contain 2.5
    And fastest is 2.2

  Scenario: 3 playing normal click
    When player click as 2.6 sec
    And try again with 1.2 sec
    And try again with 1.6 sec
    Then time arrays contain 1.2
    And time arrays contain 2.6
    And time arrays not contain 1.9

