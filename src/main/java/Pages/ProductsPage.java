package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ProductsPage extends PageBase {

    private static final Logger log = LogManager.getLogger(ProductsPage.class);

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h2.title.text-center")
    WebElement AllProducts;

    @FindBy(css = "a[href='/product_details/1']")
    WebElement ViewProduct_1;

    @FindBy(css = "div.product-information h2")
    WebElement ProductName;

    @FindBy(xpath = "//div[@class='product-information']/p[1]")
    WebElement ProductCategory;

    @FindBy(xpath = "//div[@class='product-information']/span/span")
    WebElement ProductPrice;

    @FindBy(xpath = "//div[@class='product-information']/p[b[text()='Availability:']]")
    WebElement ProductAvailability;

    @FindBy(xpath = "//div[@class='product-information']/p[b[text()='Condition:']]")
    WebElement ProductCondition;

    @FindBy(xpath = "//div[@class='product-information']/p[b[text()='Brand:']]")
    WebElement ProductBrand;

    @FindBy(id = "search_product")
    WebElement SearchProduct;

    @FindBy(css = "button:has(i.fa.fa-search)")
    WebElement SearchIcon;

    @FindBy(xpath = "//h2[@class='title text-center' and text()='Searched Products']")
    WebElement SearchedProducts;

    @FindBy(css = ".productinfo p")
    List<WebElement> ProductNames;

    public boolean IsAllProductsHeaderValid() {
        log.info("Verifying visibility and text of 'ALL PRODUCTS' header");
        return isElementVisible(AllProducts, 3)
                && getElementText(AllProducts, 3).equals("ALL PRODUCTS");
    }

    public void ClickOnViewProduct() {
        log.info("Clicking on 'View Product' button using JavaScript executor");
        js.executeScript("arguments[0].click();", ViewProduct_1);
    }

    public boolean IsProductNameVisible(String Expected_Text) {
        log.info("Verifying product name contains: " + Expected_Text);
        return isElementVisible(ProductName, 3)
                && getElementText(ProductName, 3).contains(Expected_Text);
    }

    public boolean IsProductCategoryVisible(String Expected_Text) {
        log.info("Verifying product category contains: " + Expected_Text);
        return isElementVisible(ProductCategory, 3)
                && getElementText(ProductCategory, 3).contains(Expected_Text);
    }

    public boolean IsProductPriceVisible(String Expected_Text) {
        log.info("Verifying product price contains: " + Expected_Text);
        return isElementVisible(ProductPrice, 3)
                && getElementText(ProductPrice, 3).contains(Expected_Text);
    }

    public boolean IsProductAvailabilityVisible(String Expected_Text) {
        log.info("Verifying product availability contains: " + Expected_Text);
        return isElementVisible(ProductAvailability, 3)
                && getElementText(ProductAvailability, 3).contains(Expected_Text);
    }

    public boolean IsProductConditionVisible(String Expected_Text) {
        log.info("Verifying product condition contains: " + Expected_Text);
        return isElementVisible(ProductCondition, 3)
                && getElementText(ProductCondition, 3).contains(Expected_Text);
    }

    public boolean IsProductBrandVisible(String Expected_Text) {
        log.info("Verifying product brand contains: " + Expected_Text);
        return isElementVisible(ProductBrand, 3)
                && getElementText(ProductBrand, 3).contains(Expected_Text);
    }

    public void Search(String Searched_product) {
        log.info("Performing product search for: " + Searched_product);
        typeText(SearchProduct, Searched_product, 3);
        clickWhenReady(SearchIcon, 3);
    }

    public boolean isSearchedProductsHeaderVisible() {
        log.info("Checking visibility of 'Searched Products' header");
        return isElementVisible(SearchedProducts, 3);
    }

    public void scrollToBottom() {
        log.info("Scrolling to bottom of the page to load all products.");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public boolean waitForProductsToLoad(int timeoutSeconds) {
        try {
            scrollToBottom();  // Scroll to load products
            waitUntilAllVisible(ProductNames,3);
            return true;
        } catch (Exception e) {
            log.error("Timed out waiting for product names to be visible.");
            return false;
        }
    }


    public void logAllProductNames() {
        log.info("Logging all visible product names:");
        for (WebElement product : ProductNames) {
            log.info("→ [" + product.getText().trim() + "]");
        }
    }

    public boolean areAllProductsRelated(String keyword) {
        log.info("Verifying all products in the list contain the keyword: " + keyword);
        for (WebElement product : ProductNames) {
            String name = product.getText().trim();
            if (name.isEmpty()) {
                log.warn("Skipping blank product name");
                continue;
            }
            if (!name.contains(keyword)) {
                log.warn("Product name does not contain keyword: [" + name + "]");
                return false;
            }
        }
        return true;
    }
}
