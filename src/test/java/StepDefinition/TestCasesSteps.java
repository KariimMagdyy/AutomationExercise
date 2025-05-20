package StepDefinition;

import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class TestCasesSteps {

    HomePage home = new HomePage(Hooks.driver);

    @And("the user clicks on the Test Cases button")
    public void ClickOnTestCases(){
        home.ClickOnTestCases();
    }

    @Then("the user should be navigated to the test cases page successfully")
    public void VerifyNavigationToTestCasesPage(){
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://automationexercise.com/test_cases");
    }
}
