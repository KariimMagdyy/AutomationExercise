package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountPage extends PageBase{

    public DeleteAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/']")
    WebElement ContinueButton;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    WebElement AccountDeletedMessage;

    public boolean ConfirmationMessage(){
        return AccountDeletedMessage.isDisplayed();
    }

    public void Continue(){
        ContinueButton.click();
    }
}
