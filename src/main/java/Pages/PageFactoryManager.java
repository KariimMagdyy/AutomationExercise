package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

    private WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public AccountCreationPage getAccountCreationPage() {
        return new AccountCreationPage(driver);
    }

    public ContactUsPage getContactUsPage() {
        return new ContactUsPage(driver);
    }

    public DeleteAccountPage getDeleteAccountPage() {
        return new DeleteAccountPage(driver);
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public ProductsPage getProductsPage() {
        return new ProductsPage(driver);
    }

    public SignUpAndLoginPage getSignUpAndLoginPage() {
        return new SignUpAndLoginPage(driver);
    }

    public SignUpPage getSignUpPage() {
        return new SignUpPage(driver);
    }
}
