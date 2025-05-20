package Test_Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    // Thread-safe WebDriver instance
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeClass
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        options.addArguments("--ignore-certificate-errors");

        WebDriver localDriver = new ChromeDriver(options);
        localDriver.manage().window().maximize();
        localDriver.get("https://automationexercise.com/");

        driver.set(localDriver);
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterClass
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); // Prevent memory leaks
        }
    }
}
