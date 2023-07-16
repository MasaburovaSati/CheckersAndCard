Feature: Checkers Game
  @game
  Scenario: Verifying the the making five legal moves as Orange
    Given user goes to the Checkers game website
    Then user confirm that the site is up
    And user makes five legal moves as orange and takes a blue piece
    When user restart the game after five moves
    Then user should confirm that the game has been successfully restarted
