
import Model.ProductModel;
import org.apache.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;

import java.io.FileNotFoundException;

public class TestItarations extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    AllProductsPage allProductsPage;
    CartPage cartPage;
    SignInPage signInPage;

    static String firstProductsUrl;

    @Test
    @Order(1)
    public void SearchAProduct() {
        logger.info("Home page URL & product searching test...");
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("Ceket");
        Assertions.assertTrue(productsPage.isOnProductsPage(),
                "Not on products page!");
    }

    @Test
    @Order(2)
    public void GoToAllProducts() {
        logger.info("Show more Products test...");
        firstProductsUrl = driver.getCurrentUrl();
        System.out.println("First Product List URL: " + firstProductsUrl);
        productsPage.getAllProducts();
        allProductsPage = new AllProductsPage(driver);
        /*Assertions.assertTrue(allProductsPage.isOnAllProductsPage(findUrl),
                "Not display all products!");*/

        Assertions.assertTrue(productsPage.isShowMoreButtonClicked(),
                "Button is not clicked!");

    }

    @Test
    @Order(3)
    public void isUrlChanged() throws InterruptedException {

        logger.info("Showing more products URL change test...");

        System.out.println("Product List Page 2 URL" + driver.getCurrentUrl());

        Assertions.assertTrue(allProductsPage.isOnAllProductsPage(firstProductsUrl),
                "The Url is not changed!");
    }

    @Test
    @Order(4)
    public void selectBodySizeOfFirstDistcountItem() throws InterruptedException {
        logger.info("Selecting a body size of first discount product test...");
        ProductModel productModel = allProductsPage.selectFirstDiscountItem();
        cartPage = new CartPage(driver);
        Thread.sleep(1000);
        Assertions.assertTrue(cartPage.isPriceEqual(productModel));
    }

    @Test
    @Order(5)
    public void compareToPrices() {
        logger.info("Comparing the old and currently product prices test...");
        Assertions.assertTrue(cartPage.compareOldAndLastPrices(),
                "Old price is not more expensive!");
    }

    @Test
    @Order(6)
    public void goToSignInScreen() throws FileNotFoundException, InterruptedException {
        logger.info("Go to sign in page test...");
        signInPage = new SignInPage(driver);
        cartPage.goToSignInScreen();
        Thread.sleep(2000);
        signInPage.fillTheInputs();
    }

    @Test
    @Order(7)
    public void goToHomePage() throws InterruptedException {
        logger.info("Go to home page test...");
        signInPage.goToHomePage();
        Assertions.assertTrue(homePage.isOnHomePage(),
                "Current URL is not home Page URL!");
    }

    @Test
    @Order(8)
    public void goToMyBagAndRemoveProduct() throws InterruptedException {
        logger.info("Go to my bag and remove recently added product test...");
        homePage.goToMyBag();
        Assertions.assertTrue(homePage.isBagEmpty(),
                "The bag is not empty!");
    }

}
