package StepDefinition;

import Pages.DeleteAccountPage;
import Pages.HomePage;
import Pages.SignUpAndLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidLoginSteps {

    HomePage home = new HomePage(Hooks.driver);
    SignUpAndLoginPage signuplogin = new SignUpAndLoginPage(Hooks.driver);
    DeleteAccountPage delete = new DeleteAccountPage(Hooks.driver);


    @When("the user clicks on the Signup Login button")
    public void ClickOnSignUpLogin(){
        home.signUp_login();
    }

    @And("the Login to your account message should be visible")
    public void verifyLoginToYourAccountMessage(){
        signuplogin.LoginInToYourAccount();
    }

    @And("the user enters a valid email address and password")
    public void ValidLogin(){
        signuplogin.ValidLogin("karim12@gmail.com","123456");
    }

    @And("clicks the login button")
    public void ClickLogin(){
        signuplogin.ClickLogin();
    }

    @And("the message Logged in as username should be visible")
    public void VerifyLoggedInAs(){
        home.IsloggedInVisible();
    }

    @Then("the message ACCOUNT DELETED should be visible")
    public void VerifyAccountDeleted(){
        delete.ConfirmationMessage();
    }
}
