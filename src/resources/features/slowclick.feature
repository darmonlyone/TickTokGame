Feature: slow click
  As a player
  I want to wait much long before click on this game

  Background:
    Given player play a fastClickGame

  Scenario: 1 playing slow click
    When player click as 20 sec
    Then time arrays contain 20

  Scenario: 2 playing slow click
    When player click as 15 sec
    And try again with 25 sec
    Then time arrays contain 25
    And time arrays contain 15
    And fastest is 15

  Scenario: 2 playing slow click
    When player click as 30 sec
    And try again with 22 sec
    Then time arrays contain 30
    And time arrays contain 22
    And time arrays not contain 100.00
    And fastest is 22

