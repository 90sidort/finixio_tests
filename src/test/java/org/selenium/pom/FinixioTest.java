package org.selenium.pom;

import org.selenium.pom.base.TestSetup;
import org.selenium.pom.objects.TestData;
import org.selenium.pom.pages.*;
import org.testng.annotations.Test;

public class FinixioTest extends TestSetup {

    @Test
    public void calculateCryptoRateForInvestAmount() throws InterruptedException {
        // Test ID: SSR_01
        TestData testData = new TestData();
        new TestPage(driver, wait)
                .navigateToURL(testData.gettestUrl())
                .changeInvestInput(testData.getInvestInputValue())
                .clickRefreshButton()
                .detectAmountChange(testData.getInvestInputValue())
                .checkCalculatedAmount(testData.getCalculatedAmountBinance())
                .checkCalculatedAmount(testData.getCalculatedAmountCoinbase())
                .checkCalculatedAmount(testData.getCalculatedAmountEtoro())
                .getNumOfProviders(testData.getnumOfProviders());
    }

    @Test
    public void loadMoreProviders() throws InterruptedException {
        // Test ID: SSR_07
        TestData testData = new TestData();
        new TestPage(driver, wait)
                .navigateToURL(testData.gettestUrl())
                .clickLoadMore()
                .checkCalculatedAmount(testData.getCalculatedAmountCoinCorner())
                .getNumOfProviders(testData.getnumOfProviders());
    }
}
