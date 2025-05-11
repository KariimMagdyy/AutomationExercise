package Tests;

import Pages.*;
import Utils.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DeleteAccountTest extends Setup {

    AccountCreationPage accountcreation;
    HomePage home;
    DeleteAccountPage delete;

    @BeforeMethod
    public void initialize() {
        home = new HomePage(driver);
        home.signUp_login();

        SignUpAndLoginPage signuplogin = new SignUpAndLoginPage(driver);
        signuplogin.Enter_info("karim", "kmagdy3@gmail.com");
        signuplogin.SignUp_click();

        SignUpPage signup = new SignUpPage(driver);
        signup.AccountDetails("123456", "12", "8", "2001",
                "karim", "magdy", "nti", "18 automation street", "12 manual street",
                "Canada", "canadian state", "canadian city", "123456", "012xxxxxxxx");


        accountcreation = new AccountCreationPage(driver);
        accountcreation.Continue();

        delete = new DeleteAccountPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void DeleteAccount(){
        home.Delete();
        Assert.assertTrue(delete.ConfirmationMessage(), "ACCOUNT DELETED is not visible");
        delete.Continue();
    }



}