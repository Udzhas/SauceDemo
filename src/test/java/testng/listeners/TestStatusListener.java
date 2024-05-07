package testng.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import testng.testcases.BaseTest;

public class TestStatusListener extends BaseTest implements ITestListener {
//     private BaseTest baseTest = new BaseTest();
    public void onTestFailure(ITestResult result) {
        System.out.println("Test case failed!");
        try {
            failedScreenshot(result.getTestName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

