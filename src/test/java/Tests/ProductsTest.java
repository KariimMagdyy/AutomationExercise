package Tests;

import Pages.HomePage;
import Pages.PageFactoryManager;
import Pages.ProductsPage;
import Test_Utils.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Product Management")
@Feature("View and Search Products")
public class ProductsTest extends BaseTest {

    private PageFactoryManager factory;
    private HomePage home;
    private ProductsPage products;

    @BeforeMethod
    public void init(){
        factory = new PageFactoryManager(getDriver());
        home = factory.getHomePage();
        products = factory.getProductsPage();
    }

    @Test(description = "Verify visibility of all products and detailed product information")
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyAllProducts_And_ProductDetails(){
        home.GoToHome();
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://automationexercise.com/");
        home.ClickOnProducts();
        Assert.assertTrue(products.IsAllProductsHeaderValid(),"All products header is not visible");
        products.ClickOnViewProduct();

        Assert.assertTrue(products.IsProductNameVisible("Blue Top"),"Product Name is not visible");
        Assert.assertTrue(products.IsProductCategoryVisible("Category"),"Product Category is not visible");
        Assert.assertTrue(products.IsProductPriceVisible("Rs."),"Product price is not visible");
        Assert.assertTrue(products.IsProductAvailabilityVisible("Availability"),"Product Availability is not visible");
        Assert.assertTrue(products.IsProductConditionVisible("Condition"),"Product Condition is not visible");
        Assert.assertTrue(products.IsProductBrandVisible("Brand"),"Product Brand is not visible");
    }

    @Test(description = "Search for a product and validate search results")
    @Severity(SeverityLevel.NORMAL)
    public void Search_Product() {
        home.GoToHome();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://automationexercise.com/");
        home.ClickOnProducts();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://automationexercise.com/products");

        products.Search("Top");
        Assert.assertTrue(products.isSearchedProductsHeaderVisible(), "Searched Products Header is not visible");

        Assert.assertTrue(products.waitForProductsToLoad(5), "Product names did not load properly");
        products.logAllProductNames();

        Assert.assertTrue(products.areAllProductsRelated("Top"), "Not all product names contain 'Top'");
    }
}