package org.selenium.pom.objects;

public class TestData {
    // This class stores all data used in tests
    private final String investInputValue = "2137";
    private final String calculatedAmountBinance = "2860.7764";
    private final String calculatedAmountCoinbase = "7974.2094";
    private final String calculatedAmountEtoro = "2802.3189";
    private final String numOfProviders = "4";
    private final String testUrl = "https://staging:staging@staging.buyshares.co.uk/test-ssr/";
    private final int expectedProviderCount = 4;

    public TestData() {}

    // These methods return test data defined above.
    public String getInvestInputValue() {
        return investInputValue;
    }
    public String gettestUrl() {
        return testUrl;
    }
    public String getCalculatedAmountBinance() {
        return calculatedAmountBinance;
    }
    public String getCalculatedAmountCoinbase() {
        return calculatedAmountCoinbase;
    }
    public String getCalculatedAmountEtoro() {
        return calculatedAmountEtoro;
    }
    public int getexpectedProviderCount() {return expectedProviderCount;}
    public String getnumOfProviders() {
        return numOfProviders;
    }
}
