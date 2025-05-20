package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import org.openqa.selenium.Alert;



import java.time.Duration;

public abstract class PageBase {

    protected WebDriver driver;
    JavascriptExecutor js;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // 🔒 Internal reusable wait for visibility
    private WebElement waitUntilVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected List<WebElement> waitUntilAllVisible(List<WebElement> elements, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    // 🔒 Internal reusable wait for clickability
    private WebElement waitUntilClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected Alert waitForAlert(int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.alertIsPresent());
    }


    // Check visibility
    public boolean isElementVisible(WebElement element, int timeoutInSeconds) {
        try {
            return waitUntilVisible(element, timeoutInSeconds).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    // Get text from element
    public String getElementText(WebElement element, int timeoutInSeconds) {
        try {
            return waitUntilVisible(element, timeoutInSeconds).getText();
        } catch (TimeoutException | NoSuchElementException e) {
            return "";
        }
    }

    // Click element when ready
    public void clickWhenReady(WebElement element, int timeoutInSeconds) {
        waitUntilClickable(element, timeoutInSeconds).click();
    }

    // Clear and type into field
    public void typeText(WebElement element, String text, int timeoutInSeconds) {
        WebElement input = waitUntilVisible(element, timeoutInSeconds);
        input.clear();
        input.sendKeys(text);
    }

    // Check if element contains specific text
    public boolean doesElementContainText(WebElement element, String expectedText, int timeoutInSeconds) {
        return getElementText(element, timeoutInSeconds).contains(expectedText);
    }

    // Scrolling using JaveScriptExecutor
    public void ScrollToElement(WebElement element){
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void selectByVisibleText(WebElement dropdownElement, String visibleText, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(dropdownElement));
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(visibleText);
    }

    protected void clickWithJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    protected void setValueWithJS(WebElement element, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + value + "';", element);
    }


    protected void acceptAlert(int wait_time) {
        waitForAlert(wait_time);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }



}
