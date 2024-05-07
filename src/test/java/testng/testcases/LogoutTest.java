package testng.testcases;

import org.saucedemo.enums.AppMenu;
import org.saucedemo.pages.HeaderPage;
import org.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    String dtUsername = "standard_user";
    String dtPassword = "secret_sauce";

    @Test
    public void logoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(dtUsername, dtPassword);

        new HeaderPage(driver).navigateToMenu(AppMenu.LOGOUT);
        Assert.assertTrue(loginPage.isAt());
    }
}
