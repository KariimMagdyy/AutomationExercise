package StepDefinition;

import Pages.HomePage;
import Pages.PageFactoryManager;
import Pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ViewProductSteps {

    PageFactoryManager factory = new PageFactoryManager(Hooks.driver);
    HomePage home = factory.getHomePage();
    ProductsPage products = factory.getProductsPage();

    @And("the user clicks on Products button")
    public void ClickOnProducts(){
        home.ClickOnProducts();
    }

    @And("the user should be navigated to ALL PRODUCTS page successfully")
    public void NavigationToAllProducts(){
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://automationexercise.com/products");
    }

    @And("the user should see that the product list is visible")
    public void VerifyProductList(){
        Assert.assertTrue(products.IsAllProductsHeaderValid(),"Products Header is not visible");
    }

    @And("the user clicks on View Product of fisrt product")
    public void ClickOnViewProduct(){
        products.ClickOnViewProduct();
    }

    @And("the user is landed to product detail page")
    public void NavigationToProductDetails(){
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://automationexercise.com/product_details/1");
    }

    @Then("the user should see the product details: name, category, price, availability, condition, brand")
    public void VerifyProductDetails(){
        Assert.assertTrue(products.IsProductNameVisible("Blue Top"),"Product Name is not visible");
        Assert.assertTrue(products.IsProductCategoryVisible("Category"),"Product Category is not visible");
        Assert.assertTrue(products.IsProductPriceVisible("Rs."),"Product Price is not visible");
        Assert.assertTrue(products.IsProductAvailabilityVisible("Availability"),"Product Availability is not visible");
        Assert.assertTrue(products.IsProductConditionVisible("Condition"),"Product Condition is not visible");
        Assert.assertTrue(products.IsProductBrandVisible("Brand"),"Product Brand is not visible");

    }
}
