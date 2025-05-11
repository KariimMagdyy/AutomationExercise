package Tests;

import Pages.HomePage;
import Pages.PageBase;
import Pages.SignUpAndLoginPage;
import Pages.SignUpPage;
import Utils.Setup;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest extends Setup {

    SignUpPage signup;

    @BeforeMethod
    public void initialize(){
        signup = new SignUpPage(driver);

        HomePage homepage = new HomePage(driver);
        homepage.signUp_login();

        SignUpAndLoginPage signup = new SignUpAndLoginPage(driver);
        signup.Enter_info("karim","kmagdy12@gmail.com");
        signup.SignUp_click();
    }

    @Test
    public void Fill_AccDetails(){

        Assert.assertTrue(signup.isEnterAccInfo_visible(),"Enter Account Information is not visible");
        signup.CheckTitle();
        Assert.assertEquals(signup.CheckName(),"karim");
        Assert.assertEquals(signup.CheckEmail(),"kmagdy12@gmail.com");

        signup.AccountDetails("123456", "12", "8", "2001",
                "karim", "magdy", "nti", "18 automation street", "12 manual street",
                "Canada", "canadian state", "canadian city", "123456", "012xxxxxxxx");

    }

}
