package Pages;

import Utils.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "a[href='/']")
    WebElement Home;

    @FindBy(css = "a[href='/login']")
    WebElement NewUserSignUp;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    WebElement SignUp_login;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/text()")
    WebElement LoggedInAs;

    @FindBy(css = "a[href='/delete_account']")
    WebElement DeleteAccount;



    public void Home_Verification(){
        Home.click();
    }

    public boolean Is_NewUserSignUp_visibile(){
        return NewUserSignUp.isDisplayed();
    }

    public void signUp_login(){
        SignUp_login.click();
    }

    public boolean IsloggedInVisible(){
        return LoggedInAs.isDisplayed();
    }

    public void Delete(){
        DeleteAccount.click();
    }

}
