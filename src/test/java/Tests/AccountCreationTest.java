package Tests;

import Pages.*;
import Utils.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountCreationTest extends Setup {

    AccountCreationPage accountcreation;
    HomePage home;

    @BeforeMethod
    public void initialize() {
        home = new HomePage(driver);
        home.signUp_login();

        SignUpAndLoginPage signuplogin = new SignUpAndLoginPage(driver);
        signuplogin.Enter_info("karim","kmagdy1@gmail.com");
        signuplogin.SignUp_click();

        SignUpPage signup = new SignUpPage(driver);
        signup.AccountDetails("123456", "12", "8", "2001",
                "karim", "magdy", "nti", "18 automation street", "12 manual street",
                "Canada", "canadian state", "canadian city", "123456", "012xxxxxxxx");


        accountcreation = new AccountCreationPage(driver);
    }

    @Test
    public void Check_ACC_Creation(){
        Assert.assertTrue(accountcreation.CreationMessage(),"ACCOUNT CREATED message is not visible");
        accountcreation.Continue();
        home.IsloggedInVisible();
    }

}