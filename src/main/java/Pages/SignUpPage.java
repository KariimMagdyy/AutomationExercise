package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends PageBase{

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[contains(., 'Enter Account Information')]")
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
        return isElementVisible(Enter_Acc_info,3);
    }

    public void CheckTitle(){
        clickWhenReady(Title,3);
    }

    public boolean isNameCorrect(String expectedName) {
        return EnteredName.getAttribute("value").equals(expectedName);
    }

    public boolean isEmailCorrect(String expectedEmail) {
        return Email.getAttribute("value").equals(expectedEmail);
    }

    public void Fill_AccountDetails(String pass, String day, String month, String year,
                              String firstname, String lastname, String companyName,
                              String address1, String country, String state, String city,
                              String code, String number){

        setValueWithJS(password,pass);

        selectByVisibleText(Birthday,day,3);
        selectByVisibleText(Birthmonth,month,3);
        selectByVisibleText(Birthyear,year,3);

        clickWithJS(newsletter);
        clickWithJS(SpecialOffers);

        typeText(FirstName,firstname,3);
        typeText(LastName,lastname,3);
        typeText(company,companyName,3);
        typeText(Address1,address1,3);

        selectByVisibleText(Country,country,3);

        typeText(State,state,3);
        typeText(City,city,3);
        typeText(ZipCode,code,3);
        typeText(MobileNumber,number,3);
    }

    public void CreateAccount(){
        clickWithJS(CreateAccount);
    }

}
