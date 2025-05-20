package StepDefinition;

import Pages.ContactUsPage;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ContactUsSteps {

    HomePage home = new HomePage(Hooks.driver);
    ContactUsPage contactus = new ContactUsPage(Hooks.driver);
    Alert alert;
    WebDriverWait wait;

    @And("the user clicks on the Contact Us button")
    public void NavigationToContactUs(){
        home.ContactUs();
    }

    @And("the user should see GET IN TOUCH visible")
    public void VerifyGetInTouchText(){
        Assert.assertTrue(contactus.IsGetinTouchVisible(),"Get in touch text is not visible");
    }

    @And("the user enters name, email, subject and message")
    public void FillForm(){
        contactus.ContacUsForm("karim","kmagdy74@gmail.com","test","testing is powerful","C:/Users/kmagd/OneDrive/Desktop/Test.txt");
    }

    @And("the user clicks the Submit button")
    public void ClickSubmit(){
        contactus.ClickSubmit();
    }

    @And("the user accepts the alert")
    public void AcceptAlert(){
        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());
        alert = Hooks.driver.switchTo().alert();
        alert.accept();
    }

    @And("the user should see the success message")
    public void SuccessMessage(){
        Assert.assertTrue(contactus.IsSuccesMessageVisible(),"Success Message is not visible");
    }

    @And("the user clicks the Home button")
    public void ReturnHome(){
        contactus.ReturnHome();
    }

    @Then("the user should be navigated to the home page successfully")
    public void VerifyNavigationToHome(){
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://automationexercise.com/");
    }
}
