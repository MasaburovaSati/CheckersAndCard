package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CheckersGamePage;
import utilities.Config;
import utilities.Driver;
import utilities.Flow;


public class Checkers_steps {
    CheckersGamePage checkersGamePage = new CheckersGamePage();


    @Given("user goes to the Checkers game website")
    public void user_goes_to_the_checkers_game_website() {
        Driver.getDriver().get(Config.getValue("checkersURL"));

    }
    @When("user confirm that the site is up")
    public void user_confirm_that_the_site_is_up() {

        Assert.assertTrue(checkersGamePage.checkersText.isDisplayed());
    }
    @Then("user makes five legal moves as orange and takes a blue piece")
    public void user_makes_five_legal_moves_as_orange_and_takes_a_blue_piece() {

        checkersGamePage.checker1.click();
        checkersGamePage.greyMove.click();

        checkersGamePage.waitForTurn();
        checkersGamePage.checker2.click();
        checkersGamePage.checker1.click();
        checkersGamePage.waitForTurn();
        checkersGamePage.checkers3.click();
        checkersGamePage.greyMove3.click();
        checkersGamePage.waitForTurn();
        checkersGamePage.checkers4.click();
        checkersGamePage.greyMove4.click();
        checkersGamePage.waitForTurn();
        checkersGamePage.checkers5.click();
        checkersGamePage.greyMove5.click();

    }

    @When("user restart the game after five moves")
    public void user_restart_the_game_after_five_moves() {

        checkersGamePage.restartBtn.click();
    }
    @Then("user should confirm that the game has been successfully restarted")
    public void user_should_confirm_that_the_game_has_been_successfully_restarted() {

        String message = "Select an orange piece to move.";
        Assert.assertEquals(checkersGamePage.message.getText().trim(), message);
    }
}
