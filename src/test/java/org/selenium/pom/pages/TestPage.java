package org.selenium.pom.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.base.BasePage;

public class TestPage extends BasePage {
    //// This class contains all methods for test cases associated with Test page

    // Page elements selectors - constants for elements used in methods
    private final By investInput = By.cssSelector("input[label=\"Invest\"]");
    private final By refreshButton = By.xpath("//button[contains(text(),'Refresh')]");
    private final By moreFilters = By.xpath("//button[contains(text(),'Load more +')]");
    private final By changedAmount = By.xpath("//*[text()='for £2137 you get']");
    private final By displayedProviders = By.xpath("//div[contains(text(),'What we like')][ancestor::div[@id='crypto507']]");

    // Page elements selectors - functions that return elements that might be different
    public By getExpectedProvidersNo(String amount) {
        return By.xpath( "//p[text()='" + amount + " Providers that match your filters']");
    }
    public By getConvertedAmount(String amount) {
        return By.xpath("//*[text()='for £" + amount + " you get']/following-sibling::div");
    }

    public TestPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // This method is responsible for navigating to test page
    public TestPage navigateToURL(String urlBrowser) {
        loadURL(urlBrowser);
        return this;
    }

    // This method is responsible for cleaning invest input and populating it with new value
    public TestPage changeInvestInput(String amountToConvert) throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(investInput));
        WebElement amountInput = driver.findElement(investInput);
        amountInput.clear();
        // Unfortunately web driver standard send keys is too quick for input so some waiting time
        // has to be added between keystrokes
        for (int i = 0; i < amountToConvert.length(); i++) {
            amountInput.sendKeys(amountToConvert.substring(i, i+1));
            Thread.sleep(100);
        }
        return this;
    }

    // This method is responsible for clicking refresh button
    public TestPage clickRefreshButton() {
        wait.until(ExpectedConditions.elementToBeClickable(refreshButton));
        WebElement calculateBttn = driver.findElement(refreshButton);
        calculateBttn.click();
        return this;
    }

    // This method is responsible for checking if new input was accepted
    public TestPage detectAmountChange() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(changedAmount));
        return this;
    }

    // This method reads converted rate and returns it as a string so
    // it can be latter compared
    public String getCalculatedValue(String amount, int index) {
        By currentAmount = getConvertedAmount(amount);
        wait.until(ExpectedConditions.presenceOfElementLocated(currentAmount));
        WebElement valueFromConversion = driver.findElements(currentAmount).get(index);
        String conversionValueText = valueFromConversion.getText();
        return conversionValueText;
    }

    // This method checks if count of loaded providers is equal
    // to expected value
    public boolean isProviderCountCorrect(int expectedCount) {
        int displayedCount = driver.findElements(displayedProviders).size();
        boolean isCountCorrect = displayedCount == expectedCount;
        return isCountCorrect;
    }

    // This method is responsible for reading providers number
    public TestPage getNumOfProviders(String expectedNoOfProviders) {
        By providersNumber = getExpectedProvidersNo(expectedNoOfProviders);
        wait.until(ExpectedConditions.visibilityOfElementLocated(providersNumber));
        return this;
    }

    // This method is responsible for clicking Load More+ button
    public TestPage clickLoadMore() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(moreFilters));
        // Unfortunately javascript is the only way to scroll to the element.
        // Thread sleep is used because then element is clicked to early
        ((JavascriptExecutor) driver).executeScript("scroll(0, 550)");
        Thread.sleep(1000);
        WebElement calculateBttn = driver.findElement(moreFilters);
        calculateBttn.click();
        return this;
    }
}

