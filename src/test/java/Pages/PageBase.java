package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    public WebDriver driver;

    public PageBase(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

}
