package StepDefinition;

import Pages.*;
import Utils.TestDataGenerator;
import Utils.UserData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RegisterSteps {

    HomePage home = new HomePage(Hooks.driver);
    SignUpAndLoginPage signupLoginPage = new SignUpAndLoginPage(Hooks.driver);
    SignUpPage signupPage = new SignUpPage(Hooks.driver);
    AccountCreationPage accountCreationPage = new AccountCreationPage(Hooks.driver);
    DeleteAccountPage deleteAccountPage = new DeleteAccountPage(Hooks.driver);
    private UserData user = TestDataGenerator.generateRandomUser();


    @Given("the user launches the browser and navigates to the website")
    public void launchBrowserAndNavigateToWebsite() {
        Hooks.driver.get("https://automationexercise.com/");
    }

    @When("the user should see the home page successfully")
    public void verifyHomePageIsVisible() {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://automationexercise.com/");
    }

    @And("the user clicks on Signup Login button")
    public void clickSignupLoginButton() {
        home.signUp_login();
    }

    @And("the user should see New User Signup text")
    public void verifyNewUserSignupTextIsVisible() {
        Assert.assertTrue(signupLoginPage.IsNewUserSignUp_visible(),"New user signup text is not visible");;
    }

    @And("the user enters name and email address")
    public void enterNameAndEmailAddress() {
        signupLoginPage.SignUp_Info("karim", "karimm12@gmail.com");
    }

    @And("the user clicks the Signup button")
    public void clickSignupButton() {
        signupLoginPage.SignUp_click();
    }

    @And("the user should see ENTER ACCOUNT INFORMATION section")
    public void verifyEnterAccountInformationSectionIsVisible() {
        Assert.assertTrue(signupPage.isEnterAccInfo_visible(), "Enter Account Information is not visible");
    }

    @And("the user fills account details, checkboxes and address details")
    public void fillAccountAndAddressDetails() {


        signupPage.CheckTitle();
        Assert.assertTrue(signupPage.isNameCorrect(user.firstName));
        Assert.assertTrue(signupPage.isEmailCorrect(user.email));

        signupPage.Fill_AccountDetails(user.password, "12", "August", "2001",
                user.firstName, user.lastName, "nti", user.address,
                "Canada", user.state, user.city, user.zip, user.mobile);
    }

    @And("the user clicks the Create Account button")
    public void clickCreateAccountButton() {
        signupPage.CreateAccount();
    }

    @And("the user should see ACCOUNT CREATED message")
    public void verifyAccountCreatedMessageIsVisible() {
        Assert.assertTrue(accountCreationPage.CreationMessage(), "Account Created Message is not visible");
    }

    @And("the user clicks the Continue button")
    public void clickContinueButtonAfterAccountCreation() {
        accountCreationPage.Continue();
    }

    @And("the user should see Logged in as username")
    public void verifyLoggedInAsUsernameIsVisible() {
        Assert.assertTrue(home.IsloggedInVisible(), "Logged in as username is not visible");
    }

    @And("the user clicks the Delete Account button")
    public void clickDeleteAccountButton() {
        home.Delete();
    }

    @And("the user should see ACCOUNT DELETED message")
    public void verifyAccountDeletedMessageIsVisible() {
        Assert.assertTrue(deleteAccountPage.ConfirmationMessage(), "Account Deleted Message is not visible");
    }

    @And("the user clicks the Continue button on Delete Account page")
    public void clickContinueButtonAfterAccountDeletion() {
        deleteAccountPage.Continue();
    }

    @Then("the user should see the home page again")
    public void verifyHomePageIsVisibleAgain() {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://automationexercise.com/");
    }
}
