Feature: fast click
  As a player
  I want to click fast on this game

  Background:
    Given player play a game

  Scenario: 1 playing fast
    When player click as 0.1 sec
    Then time arrays contain 0.1

  Scenario: 2 playing fast
    When player click as 0.5 sec
    And try again with 0.3 sec
    Then time arrays contain 0.1
    And time arrays contain 0.2

  Scenario: 2 playing fast
    When player click as 0.1 sec
    And try again with 0.2 sec
    Then time arrays contain 0.1
    And time arrays contain 0.2


#  When
#  Then
#  And