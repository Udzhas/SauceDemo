package testng.testcases;

import org.saucedemo.pages.HeaderPage;
import org.saucedemo.pages.LoginPage;
import org.saucedemo.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartCountTest extends BaseTest {
    String dtUsername = "standard_user";
    String dtPassword = "secret_sauce";
    String prod1 = "Sauce Labs Onesie";

    @Test
    private void addToCartCountTest() {
        new LoginPage(driver).login(dtUsername, dtPassword);
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.add(prod1);

        HeaderPage headerPage = new HeaderPage(driver);
        Assert.assertEquals(headerPage.getCartCount(), 1, "Verifying cart count");
    }
}
