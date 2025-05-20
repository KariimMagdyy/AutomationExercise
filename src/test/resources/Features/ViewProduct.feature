Feature: Verify All Products and product detail page

  Scenario: User navigates to products page and view product details

    Given the user launches the browser and navigates to the website
    When the user should see the home page successfully
    And the user clicks on Products button
    And the user should be navigated to ALL PRODUCTS page successfully
    And the user should see that the product list is visible
    And the user clicks on View Product of fisrt product
    And the user is landed to product detail page
    Then the user should see the product details: name, category, price, availability, condition, brand
