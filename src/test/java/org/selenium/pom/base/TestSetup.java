package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestSetup {
    // This class defines what happens before and after each test case
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void startDriver(){
        driver = new DriverManager().initializeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
}
