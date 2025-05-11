package Tests;

import Pages.HomePage;
import Utils.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest extends Setup {

    HomePage homepage;

    @BeforeMethod
    public void initialize(){
        homepage = new HomePage(driver);
    }

    @Test(priority = 1)
    public void verifyHome(){
        homepage.Home_Verification();
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
    }

    @Test(priority = 2)
    public void signUplogin_button(){
        homepage.signUp_login();
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");
    }

    @Test(priority = 3)
    public void NewUserSignUp(){
        Assert.assertTrue(homepage.Is_NewUserSignUp_visibile(),"New User SignUp is not visible");
    }



}
