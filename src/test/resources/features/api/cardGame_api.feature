Feature: Card game
  @card
  Scenario: Deal 3 card to 2 players
#    When user navigates to card game site
#    Then user verifies site is up
    And user picks deck of card
    And user deals three card to two players
    Then user verifies blackjack card