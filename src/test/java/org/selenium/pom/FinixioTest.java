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
                .navigateToURL(testData.gettestUrl())
                .changeInvestInput(testData.getInvestInputValue())
                .clickRefreshButton()
                .detectAmountChange(testData.getInvestInputValue())
                .getNumOfProviders(testData.getnumOfProviders());
        Assert.assertTrue(testPage.isAmountRecalculated(testData.getCalculatedAmountBinance()), "Value for Binance is correct.");
        Assert.assertTrue(testPage.isAmountRecalculated(testData.getCalculatedAmountCoinbase()), "Value for Coinbase is correct.");
        Assert.assertTrue(testPage.isAmountRecalculated(testData.getCalculatedAmountEtoro()), "Value for Etoro is correct.");

    }

    @Test
    public void loadMoreProviders() throws InterruptedException {
        // Test ID: SSR_07
        TestData testData = new TestData();
        TestPage testPage = new TestPage(driver, wait)
                .navigateToURL(testData.gettestUrl())
                .clickLoadMore()
                .getNumOfProviders(testData.getnumOfProviders());
        Assert.assertTrue(testPage.isAmountRecalculated(testData.getCalculatedAmountCoinCorner()), "Value for CoinCorner is correct.");
    }
}
