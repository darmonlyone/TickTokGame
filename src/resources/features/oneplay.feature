Feature: play one time with normal click
  As a player
  I want play one time on this game and close it

  Background:
    Given player play a fastClickGame

  Scenario: 1 playing normal click
    When player click as 1.2 sec
    Then time arrays contain 1.2

  Scenario: 1 playing normal click
    When player click as 1.5 sec
    Then time arrays contain 1.5

  Scenario: 1 playing normal click
    When player click as 1.6 sec
    Then time arrays contain 1.6

  Scenario: 1 playing normal click
    When player click as 0.4 sec
    Then time arrays contain 0.4

  Scenario: 1 playing normal click
    When player click as 0.8 sec
    Then time arrays contain 0.8
