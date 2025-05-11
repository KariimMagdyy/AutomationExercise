package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage extends PageBase {

    public AccountCreationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    WebElement AccountCreated;

    @FindBy(css = "a[href='/']")
    WebElement ContinueButton;

    public boolean CreationMessage(){
        return AccountCreated.isDisplayed();
    }

    public void Continue(){
        ContinueButton.click();
    }
}