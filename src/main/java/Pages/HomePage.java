package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver){

        super(driver);
    }

    @FindBy(css = "a[href='/']")
    WebElement Home;

    @FindBy(css = "a[href='/login']")
    WebElement SignUp_login;

    @FindBy(css = "i.fa.fa-user")
    WebElement LoggedInAs;

    @FindBy(css = "a[href='/delete_account']")
    WebElement DeleteAccount;

    @FindBy(linkText = "Logout")
    WebElement Logout;

    @FindBy(css = "a[href='/contact_us']")
    WebElement Contact_us;

    @FindBy(css = "a[href='/test_cases']")
    WebElement TestCasesIcon;

    @FindBy(css = "a[href='/products']")
    WebElement Products;


    public void GoToHome(){
        clickWhenReady(Home,3);
    }


    public void signUp_login(){
        clickWhenReady(SignUp_login,3);
    }

    public boolean IsloggedInVisible(){
        return isElementVisible(LoggedInAs,3);
    }

    public void Delete(){
        clickWithJS(DeleteAccount);
    }

    public void Logout(){
        clickWhenReady(Logout,3);
    }

    public void ContactUs(){
        clickWhenReady(Contact_us,3);
    }

    public void ClickOnTestCases(){
        clickWhenReady(TestCasesIcon,3);
    }

    public void ClickOnProducts(){
        clickWhenReady(Products,3);
    }

}
