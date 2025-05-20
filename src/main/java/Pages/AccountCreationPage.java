package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreationPage extends PageBase {

    public AccountCreationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h2[data-qa='account-created']")
    WebElement AccountCreated;

    @FindBy(css = "a[data-qa='continue-button']")
    WebElement ContinueButton;

    public boolean CreationMessage(){
        return isElementVisible(AccountCreated,3);
    }

    public void Continue(){
        clickWhenReady(ContinueButton,3);
    }
}