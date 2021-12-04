package org.selenium.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BasePage {
    // This class will be extended by specific POMs and will expose driver and wait
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void loadURL(String url) {
        driver.get(url);
    }

    public boolean isElementDisplayed(By by) {
        try
        {
            setTimeout(3);
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e)
        {
            return false;
        }
        finally
        {
            setTimeout(15);
        }
    }

    public void setTimeout(int timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }
}
