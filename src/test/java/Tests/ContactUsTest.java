package Tests;

import Pages.ContactUsPage;
import Pages.HomePage;
import Pages.PageFactoryManager;
import Utils.BaseTest;
import Utils.TestDataGenerator;
import Utils.UserData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Contact Us")
@Feature("Submit Contact Form")
public class ContactUsTest extends BaseTest {

    private ContactUsPage contactus;
    private HomePage home;
    private PageFactoryManager factory;
    private UserData user;

    @BeforeMethod
    public void initialize(){
        factory = new PageFactoryManager(getDriver());
        contactus = factory.getContactUsPage();
        home = factory.getHomePage();
        user = TestDataGenerator.generateRandomUser();
    }

    @Test(description = "Submit the Contact Us form with valid data and file upload")
    @Severity(SeverityLevel.NORMAL)
    public void ContactUsForm(){
        home.ContactUs();
        Assert.assertTrue(contactus.IsGetinTouchVisible(),"Get in touch is not visible");;
        contactus.ContacUsForm(user.firstName, user.email, "Test Subject",
                "Test Automation is good","C:/Users/kmagd/OneDrive/Desktop/Test.txt");
        contactus.ClickSubmit();
        contactus.AcceptAlert();
        Assert.assertTrue(contactus.IsSuccesMessageVisible(),"Success Message is not visible");;
        contactus.ReturnHome();
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://automationexercise.com/");
    }
}