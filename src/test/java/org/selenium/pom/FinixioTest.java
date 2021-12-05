package org.selenium.pom;

import org.selenium.pom.base.TestSetup;
import org.selenium.pom.objects.TestData;
import org.selenium.pom.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FinixioTest extends TestSetup {

    @Test
    public void calculateCryptoRateForInvestAmount() throws InterruptedException {
        // Test ID: SSR_01
        TestData testData = new TestData();
        TestPage testPage = new TestPage(driver, wait)
                .navigateToURL(testData.gettestUrl());
        String valueOneBeforeChange = testPage.getCalculatedValue(testData.getinvestInitial(),0);
        String valueTwoBeforeChange = testPage.getCalculatedValue(testData.getinvestInitial(),1);
        String valueThreeBeforeChange = testPage.getCalculatedValue(testData.getinvestInitial(),2);
        testPage.changeInvestInput(testData.getInvestInputValue()).clickRefreshButton()
            .detectAmountChange()
            .getNumOfProviders(testData.getnumOfProviders());
        String valueOneAfterChange = testPage.getCalculatedValue(testData.getInvestInputValue(),0);
        String valueTwoAfterChange = testPage.getCalculatedValue(testData.getInvestInputValue(),1);
        String valueThreeAfterChange = testPage.getCalculatedValue(testData.getInvestInputValue(),2);
        Assert.assertNotEquals(valueOneBeforeChange, valueOneAfterChange, "Value for Binance does not change!");
        Assert.assertNotEquals(valueTwoBeforeChange, valueTwoAfterChange, "Value for Coinbase does not change!");
        Assert.assertNotEquals(valueThreeBeforeChange, valueThreeAfterChange, "Value for Etoro does not change!");
    }

    @Test
    public void loadMoreProviders() throws InterruptedException {
        // Test ID: SSR_07
        TestData testData = new TestData();
        TestPage testPage = new TestPage(driver, wait)
                .navigateToURL(testData.gettestUrl())
                .clickLoadMore()
                .getNumOfProviders(testData.getnumOfProviders());
        Assert.assertTrue(testPage.isProviderCountCorrect(testData.getexpectedProviderCount()), "Count of displayed providers is incorrect.");
    }
}
