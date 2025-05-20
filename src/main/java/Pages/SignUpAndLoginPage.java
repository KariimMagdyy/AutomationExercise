package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/h2")
    WebElement LogintoYourAccount;

    @FindBy(css = "input[data-qa='login-email']")
    WebElement LoginEmail;

    @FindBy(css = "input[data-qa='login-password']")
    WebElement LoginPass;

    @FindBy(css = "button[data-qa='login-button']")
    WebElement LoginButton;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    WebElement ErrorMessage;

    @FindBy(xpath = "//h2[contains(.,'New User Signup!')]")
    WebElement NewUserSignup;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    WebElement EmailExists_Message;

    public boolean IsNewUserSignUp_visible(){
        return NewUserSignup.isDisplayed();
    }

    public void SignUp_Info(String name,String email){
        setValueWithJS(Name,name);
        setValueWithJS(Email,email);
    }

    public void SignUp_click(){
        clickWhenReady(SignUp,3);
    }

    public boolean LoginInToYourAccount(){
        return isElementVisible(LogintoYourAccount,3);
    }

    public boolean ErrorMessageVerification(){
        return isElementVisible(ErrorMessage,3);
    }

    public void ValidLogin(String email, String pass){
        typeText(LoginEmail,email,3);
        typeText(LoginPass,pass,3);
    }

    public void InvalidLogin(String email, String pass){
        typeText(LoginEmail,email,3);
        typeText(LoginPass,pass,3);
    }

    public void ClickLogin(){
        clickWhenReady(LoginButton,3);
    }

    public boolean EmailAlreadyExistsMessage(){
        return isElementVisible(EmailExists_Message,3);
    }

}