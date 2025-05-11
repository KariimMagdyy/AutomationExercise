package Tests;

import Pages.HomePage;
import Pages.SignUpAndLoginPage;
import Utils.Setup;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpAndLoginTest extends Setup {

    SignUpAndLoginPage signup_login;

    @BeforeMethod
    public void initialize(){

        HomePage homepage = new HomePage(driver);
        homepage.signUp_login();

        signup_login = new SignUpAndLoginPage(driver);
    }

    @Test
    public void Enter_info(){

        signup_login.Enter_info("Karim","Kmagdy@gmail.com");
        signup_login.SignUp_click();

    }

}
