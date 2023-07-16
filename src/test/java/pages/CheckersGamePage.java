package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.Flow;


public class CheckersGamePage {

        public CheckersGamePage(){
                PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(name = "space02")
        public WebElement checker1;

        @FindBy(xpath = "//h1[.='Checkers']")
        public WebElement checkersText;

        @FindBy(name = "space13")
        public WebElement greyMove;

        @FindBy(name = "space11")
        public WebElement checker2;

        @FindBy(name = "space62")
        public WebElement checkers3;

        @FindBy(name = "space73")
        public WebElement greyMove3;

        @FindBy(name = "space42")
        public WebElement checkers4;

        @FindBy(name = "space24")
        public WebElement greyMove4;

        @FindBy(name = "space13")
        public WebElement checkers5;

        @FindBy(name = "space04")
        public WebElement greyMove5;

        @FindBy(xpath = "//a[.='Restart...']")
        public WebElement restartBtn;

        @FindBy(id = "message")
        public WebElement message;

        public void waitForTurn(){
                String text = "Make a move.";
                boolean turn = false;
                while(!turn){
                        Flow.wait(1000);
                        if (message.getText().trim().equals(text)){
                                Flow.wait(1000);
                                break;
                        }
                }
        }

    }

