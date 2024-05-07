package testng.testcases;

import org.saucedemo.contexts.CustomerDTO;
import org.saucedemo.pages.CheckoutPage;
import org.saucedemo.pages.LoginPage;
import org.saucedemo.pages.ProductsPage;
import org.saucedemo.pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartCheckoutTest extends BaseTest {
    // TODO: Data provider
    String dtUsername = "standard_user";
    String dtPassword = "secret_sauce";

    String prod1 = "Sauce Labs Onesie";
    String prod2 = "Test.allTheThings() T-Shirt (Red)";

    @Test
    public void addToCartCheckoutTest() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("John");
        customerDTO.setLastName("Doe");
        customerDTO.setZipCode("79000");

        new LoginPage(driver).login(dtUsername, dtPassword);
        new ProductsPage(driver).add(prod1).add(prod2);

        CheckoutPage checkoutPage = new ShoppingCartPage(driver)
                .open()
                .checkout()
                .setInformation(customerDTO)
                .finish();
        Assert.assertTrue(checkoutPage.isCheckoutComplete());

    }
}
