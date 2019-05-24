Feature: fast click
  As a player
  I want to click fast on this game

  Background:
    Given player play a fastClickGame

  Scenario: 1 playing fast click
    When player click as 0.1 sec
    Then time arrays contain 0.1
    And fastest is 0.1

  Scenario: 2 playing fast click
    When player click as 0.5 sec
    And try again with 0.3 sec
    Then time arrays not contain 0.1
    And time arrays contain 0.3
    And fastest is 0.3

  Scenario: 2 playing fast click
    When player click as 0.1 sec
    And try again with 0.2 sec
    Then time arrays contain 0.1
    And time arrays not contain 0.5
    And fastest is 0.1
