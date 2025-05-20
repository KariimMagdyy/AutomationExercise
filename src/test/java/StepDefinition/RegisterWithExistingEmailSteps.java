package StepDefinition;

import Pages.SignUpAndLoginPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class RegisterWithExistingEmailSteps {

    SignUpAndLoginPage signuplogin = new SignUpAndLoginPage(Hooks.driver);

    @Then("Error Email Address already exist is visible")
    public void ErrorMessage(){
        Assert.assertTrue(signuplogin.EmailAlreadyExistsMessage(),"Email Already Exists message is not visible");
    }
}
