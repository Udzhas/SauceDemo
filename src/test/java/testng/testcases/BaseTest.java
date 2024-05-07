package testng.testcases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.saucedemo.config.EnvironmentVariables;
import org.saucedemo.enums.Browsers;
import org.saucedemo.utils.BrowserFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import testng.listeners.TestStatusListener;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Objects;

@Listeners(TestStatusListener.class)
public abstract class BaseTest {

    // use static WebDriver instance for generating screenshot
    protected WebDriver driver;
    private Browsers browser = Browsers.CHROME;
    private String url = "https://www.saucedemo.com/";

    @BeforeSuite
    public void setup() {
        File dir = new File("/Users/yuriydzhas/IdeaProjects/SauceDemo/Screenshots");
        try {
            for (File file : Objects.requireNonNull(dir.listFiles())) {
                file.delete();
            }
        } catch (Exception ignored) {
        }
        driver = BrowserFactory.launch(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EnvironmentVariables.WAIT_IMPLICIT));
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void failedScreenshot(String testMethodName) {

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date d = new Date();

        String timeStamp = d.toString().replace(":", "_").replace(" ", "_");
        try {
            FileUtils.copyFile(srcFile, new File("/Users/yuriydzhas/IdeaProjects/SauceDemo/Screenshots/"
                    + testMethodName + "_ " + timeStamp + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
