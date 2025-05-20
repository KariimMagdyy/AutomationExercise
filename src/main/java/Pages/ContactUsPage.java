package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;

public class ContactUsPage extends PageBase{

    public ContactUsPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "h2.title.text-center")
    WebElement GetInTouch;

    @FindBy(css = "input[data-qa='name']")
    WebElement Name;

    @FindBy(css = "input[data-qa='email']")
    WebElement Email;

    @FindBy(css = "input[data-qa='subject']")
    WebElement Subject;

    @FindBy(id = "message")
    WebElement Message;

    @FindBy(name = "upload_file")
    WebElement ChooseFile;

    @FindBy(name = "submit")
    public WebElement Submit;

    @FindBy(xpath = "//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]")
    WebElement SuccessMessage;

    @FindBy(xpath = "//*[@id=\"form-section\"]/a/span")
    WebElement ReturnHomeButton;

    public void ContacUsForm(String name, String email, String subject, String message, String filepath){
        typeText(Name,name,3);
        typeText(Email,email,3);
        typeText(Subject,subject,3);
        typeText(Message,message,3);
        typeText(ChooseFile,filepath,3);

    }

    public boolean IsGetinTouchVisible(){
        return isElementVisible(GetInTouch,3);
    }

    public boolean IsSuccesMessageVisible(){
        return isElementVisible(SuccessMessage,3);
    }

    public void ReturnHome(){
        clickWhenReady(ReturnHomeButton,3);
    }

    public void ClickSubmit(){
        ScrollToElement(Submit);
        clickWhenReady(Submit,3);
    }

    public void AcceptAlert(){
        acceptAlert(3);
    }
}
