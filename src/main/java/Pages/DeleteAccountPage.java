package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountPage extends PageBase{

    public DeleteAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Continue")
    WebElement ContinueButton;

    @FindBy(css = "h2[data-qa='account-deleted']")
    WebElement AccountDeletedMessage;

    public boolean ConfirmationMessage() {
        return isElementVisible(AccountDeletedMessage,5);
    }

    public void Continue(){
        clickWithJS(ContinueButton);
    }
}
