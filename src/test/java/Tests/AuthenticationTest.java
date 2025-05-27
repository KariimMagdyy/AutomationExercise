package Tests;

import Pages.*;
import Utils.BaseTest;
import Utils.UserData;
import Utils.TestDataGenerator;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Authentication")
@Feature("User Registration and Login")
public class AuthenticationTest extends BaseTest {

    private SignUpPage signup;
    private PageFactoryManager factory;
    private HomePage home;
    private SignUpAndLoginPage signup_login;
    private AccountCreationPage accountcreated;
    private DeleteAccountPage delete;
    private UserData user;

    @BeforeMethod
    public void initialize() {
        factory = new PageFactoryManager(getDriver());
        signup = factory.getSignUpPage();
        home = factory.getHomePage();
        signup_login = factory.getSignUpAndLoginPage();
        accountcreated = factory.getAccountCreationPage();
        delete = factory.getDeleteAccountPage();
        user = TestDataGenerator.generateRandomUser();

        home.GoToHome();
    }

    @Step("Registering new user")
    private void registerNewUser(UserData user) {
        home.signUp_login();
        signup_login.SignUp_Info(user.firstName, user.email);
        signup_login.SignUp_click();
        signup.CheckTitle();
        signup.Fill_AccountDetails(user.password, "12", "August", "2001",
                user.firstName, user.lastName, user.company, user.address,
                "Canada", user.state, user.city, user.zip, user.mobile);
        signup.CreateAccount();
        accountcreated.Continue();
    }

    @Test(description = "Register a new user with valid data")
    @Severity(SeverityLevel.CRITICAL)
    public void RegisterNewUser() {
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://automationexercise.com/", "Home URL mismatch");
        home.signUp_login();
        Assert.assertTrue(signup_login.IsNewUserSignUp_visible(), "New user signup is not visible");
        signup_login.SignUp_Info(user.firstName, user.email);
        signup_login.SignUp_click();
        Assert.assertTrue(signup.isEnterAccInfo_visible(), "Enter Account Information is not visible");
        signup.CheckTitle();
        Assert.assertTrue(signup.isNameCorrect(user.firstName), "Entered Name is not correct");
        Assert.assertTrue(signup.isEmailCorrect(user.email), "Entered Email is not correct");

        signup.Fill_AccountDetails(user.password, "12", "August", "2001",
                user.firstName, user.lastName, "nti", user.address,
                "Canada", user.state, user.city, user.zip, user.mobile);
        signup.CreateAccount();
        Assert.assertTrue(accountcreated.CreationMessage(), "ACCOUNT CREATED message is not visible");
        accountcreated.Continue();
        Assert.assertTrue(home.IsloggedInVisible(), "Logged in as username is not visible");
    }

    @Test(description = "Register and then log in with correct credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void Valid_Login() {
        registerNewUser(user);
        home.Logout();
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://automationexercise.com/login");
        Assert.assertTrue(signup_login.LoginInToYourAccount(), "Login to your account message is not visible");
        signup_login.ValidLogin(user.email, user.password);
        signup_login.ClickLogin();
        Assert.assertTrue(home.IsloggedInVisible(), "Logged in as username is not visible");
    }

    @Test(description = "Attempt login with incorrect credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void InvalidLogin() {
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://automationexercise.com/", "Home URL mismatch");
        home.signUp_login();
        Assert.assertTrue(signup_login.LoginInToYourAccount(), "Login to your account message is not visible");
        signup_login.InvalidLogin(user.email, user.password);
        signup_login.ClickLogin();
        Assert.assertTrue(signup_login.ErrorMessageVerification(), "Error 'Your email or password is incorrect!' is not visible");
    }

    @Test(description = "Register a user and attempt to register again with same email")
    @Severity(SeverityLevel.CRITICAL)
    public void RegisterWithExistingEmail() {
        registerNewUser(user);
        home.Logout();
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://automationexercise.com/login");
        signup_login.SignUp_Info(user.firstName, user.email);
        signup_login.SignUp_click();
        Assert.assertTrue(signup_login.EmailAlreadyExistsMessage(), "Email Already Exists Message is not visible");
    }

    @AfterMethod
    public void CleanUp(){
        if(home.IsloggedInVisible()){
            home.Delete();
            Assert.assertTrue(delete.ConfirmationMessage(),"Account Deleted message is not visible");
            delete.Continue();
        }
    }
}