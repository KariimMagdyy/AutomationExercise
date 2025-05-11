package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class SignUpPage extends PageBase{

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/h2/b")
    WebElement Enter_Acc_info;

    @FindBy(id = "id_gender1")
    WebElement Title;

    @FindBy(id = "name")
    WebElement EnteredName;

    @FindBy(id = "email")
    WebElement Email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "days")
    WebElement Birthday;

    @FindBy(id = "months")
    WebElement Birthmonth;

    @FindBy(id = "years")
    WebElement Birthyear;

    @FindBy(id = "newsletter")
    WebElement newsletter;

    @FindBy(id = "optin")
    WebElement SpecialOffers;

    @FindBy(id = "first_name")
    WebElement FirstName;

    @FindBy(id = "last_name")
    WebElement LastName;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement Address1;

    @FindBy(id = "address2")
    WebElement Address2;

    @FindBy(id = "country")
    WebElement Country;

    @FindBy(id = "state")
    WebElement State;

    @FindBy(id = "city")
    WebElement City;

    @FindBy(id = "zipcode")
    WebElement ZipCode;

    @FindBy(id = "mobile_number")
    WebElement MobileNumber;

    @FindBy(css = "button[data-qa='create-account']")
    WebElement CreateAccount;



    public boolean isEnterAccInfo_visible(){
        return Enter_Acc_info.isDisplayed();
    }

    public void CheckTitle(){
        Title.click();
    }

    public String CheckName(){
        return EnteredName.getAttribute("value");
    }

    public String CheckEmail(){
        return Email.getAttribute("value");
    }

    public void AccountDetails(String pass, String day, String month, String year,
                              String firstname, String lastname, String companyName,
                              String address1, String address2, String country, String state, String city,
                              String code, String number){

        password.sendKeys(pass);

        Select select_day = new Select(Birthday);
        select_day.selectByValue(day);

        Select select_month = new Select(Birthmonth);
        select_month.selectByValue(month);

        Select select_year = new Select(Birthyear);
        select_year.selectByValue(year);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(newsletter)).click();
        wait.until(ExpectedConditions.elementToBeClickable(SpecialOffers)).click();

        FirstName.sendKeys(firstname);
        LastName.sendKeys(lastname);
        company.sendKeys(companyName);
        Address1.sendKeys(address1);
        Address2.sendKeys(address2);

        Select select = new Select(Country);
        select.selectByValue(country);

        State.sendKeys(state);
        City.sendKeys(city);
        ZipCode.sendKeys(code);
        MobileNumber.sendKeys(number);

        CreateAccount.click();

    }

}
