Feature: many plays
  As a player
  I want to click normally with many plays on this game

  Background:
    Given player play a fastClickGame

  Scenario: 7 playing with any click
    When player clicks as [1.5, 1.2, 1.3, 2.2, 1.3, 0.2, 1.2] sec
    Then time arrays contains [1.5, 1.2, 1.3, 2.2, 1.3, 0.2, 1.2]
    And fastest is 0.2

  Scenario: 8 playing with any click fast click
    When player clicks as [0.1, 0.2, 0.3, 0.5, 0.6, 0.77, 0.111, 0.22] sec
    Then time arrays contains [0.1, 0.2, 0.3, 0.5, 0.6, 0.77, 0.111, 0.22]
    And fastest is 0.1

  Scenario: 5 playing with any click slow click
    When player clicks as [15.2, 10, 13.0, 13.5, 20.22] sec
    Then time arrays contains [15.2, 10, 13.0, 13.5, 20.22]
    And fastest is 10.0

