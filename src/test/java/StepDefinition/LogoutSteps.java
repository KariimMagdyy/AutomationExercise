package StepDefinition;

import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LogoutSteps {

    HomePage home = new HomePage(Hooks.driver);

    @And("the user clicks the logout button")
    public void Logout(){
        home.Logout();
    }

    @Then("the user returns back to login page")
    public void ReturnToLoginPage(){
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://automationexercise.com/login");
    }
}
