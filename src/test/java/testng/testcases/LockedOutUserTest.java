package testng.testcases;

import org.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LockedOutUserTest extends BaseTest {
    String dtUsername = "locked_out_user";
    String dtPassword = "secret_sauce";

    @Test
    public void lockedOutUserTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(dtUsername, dtPassword);
        Assert.assertTrue(loginPage.isUserLockedOut());
    }
}
