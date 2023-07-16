package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Config;
import utilities.Driver;
import utilities.Flow;

public class CardGame_steps {
    String deckId;

    @When("user navigates to card game site")
    public void user_navigates_to_card_game_site() {
        Driver.getDriver().get(Config.getValue("cardGameUrl"));
    }
    @Then("user verifies site is up")
    public void user_verifies_site_is_up() {

       WebElement header=  Driver.getDriver().findElement(By.xpath("//h1[.='Deck of Cards']"));
        Assert.assertTrue(header.isDisplayed());
        Flow.wait(1000);
        Driver.quitBrowser();
    }
    @Then("user picks deck of card")
    public void user_picks_deck_of_card() {
        Response response = RestAssured.get("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1");
        Assert.assertEquals(response.statusCode(), 200);
         deckId = response.jsonPath().get("deck_id");
    }
    @Then("user deals three card to two players")
    public void user_deals_three_card_to_two_players() {
        System.out.println("\nFirst Player cards\n");
        String url = "https://deckofcardsapi.com/api/deck/" + deckId + "/draw/?count=3";
        Response firstPlayer = RestAssured.get(url);
        System.out.println(firstPlayer.asPrettyString());
        System.out.println("\nSecond Player cards\n");
        Response secondPlayer = RestAssured.get(url);
        System.out.println(secondPlayer.asPrettyString());

        String card1 = firstPlayer.jsonPath().get("cards[0].value");
        System.out.println(card1);
    }
    @Then("user verifies blackjack card")
    public void user_verifies_blackjack_card() {
          String url = "https://deckofcardsapi.com/api/deck/<<deck_id>>/draw/?count=2";
          Response response = RestAssured.get(url);
          Assert.assertEquals(response.statusCode(), 200);

        String firstPlayer = response.jsonPath().get("cards[0].value");
        String secondPlayer = response.jsonPath().get("cards[1].value");

        boolean hasBlackjackCard = isBlackjackCard(firstPlayer) || isBlackjackCard(secondPlayer);

        Assert.assertEquals("At least one blackjack card is drawn.", hasBlackjackCard);
    }

    private boolean isBlackjackCard(String card) {
        return card.equals("10") || card.equals("JACK")
                || card.equals("QUEEN") || card.equals("KING");
    }
}