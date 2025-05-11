package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpAndLoginPage extends PageBase {

    public SignUpAndLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[data-qa='signup-name']")
    WebElement Name;

    @FindBy(css = "input[data-qa='signup-email']")
    WebElement Email;

    @FindBy(css = "button[data-qa='signup-button']")
    WebElement SignUp;


    public void Enter_info(String name,String email){
        Name.sendKeys(name);
        Email.sendKeys(email);
    }

    public void SignUp_click(){
        SignUp.click();
    }

}