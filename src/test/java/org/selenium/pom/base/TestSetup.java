package org.selenium.pom.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.factory.DriverManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestSetup {
    // This class defines what happens before and after each test case
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void startDriver(){
        // This method starts driver and passes wait time
        driver = new DriverManager().initializeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void quitDriver(ITestResult result) throws IOException {
        // This method quits driver and in case of fail it takes screenshot
        if (result.getStatus() == ITestResult.FAILURE) {
            File destFile = new File(
                    "screen" + File.separator +
                            result.getTestClass().getRealClass().getSimpleName() +
                            "_" + result.getMethod().getMethodName() + ".png");
            takeScreenshot(destFile);
        }
        driver.quit();
    }

    private void takeScreenshot(File destinationFile) throws IOException {
        // This method is used to take screenshot and save it to screen folder
        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, destinationFile);
    }
}
