package Tests;

import Pages.HomePage;
import Pages.PageFactoryManager;
import Test_Utils.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Navigation")
@Feature("Test Cases Page")
public class TestCasesPageTest extends BaseTest {

    private HomePage homepage;
    private PageFactoryManager factory;

    @BeforeMethod
    public void initialize(){
        factory = new PageFactoryManager(getDriver());
        homepage = factory.getHomePage();
    }

    @Test(description = "Navigate to Test Cases page and verify the URL")
    @Severity(SeverityLevel.TRIVIAL)
    public void NavigationToTestCasesPage(){
        homepage.GoToHome();
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://automationexercise.com/");
        homepage.ClickOnTestCases();
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://automationexercise.com/test_cases");
    }
}