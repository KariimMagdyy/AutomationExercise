package StepDefinition;

import Pages.SignUpAndLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class InvalidLoginSteps {

    SignUpAndLoginPage signuplogin = new SignUpAndLoginPage(Hooks.driver);


    @And("the user enters incorrect email address and password")
    public void InvalidLogin(){
        signuplogin.InvalidLogin("kmagdy74@gmail.com","123456");
    }

    @Then("an error message Your email or password is incorrect should be visible")
    public void ErrorMessage(){
        signuplogin.ErrorMessageVerification();
    }
}
