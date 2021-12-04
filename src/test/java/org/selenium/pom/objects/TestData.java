package org.selenium.pom.objects;

public class TestData {
    // This class stores all data used in tests
    private final String investInputValue = "2137";
    private final String calculatedAmountBinance = "3218.3735";
    private final String calculatedAmountCoinbase = "7945.5284";
    private final String calculatedAmountEtoro = "3131.6004";
    private final String calculatedAmountCoinCorner = "4503.9652";
    private final String numOfProviders = "4";
    private final String testUrl = "https://staging:staging@staging.buyshares.co.uk/test-ssr/";

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
    public String getCalculatedAmountCoinCorner() {
        return calculatedAmountCoinCorner;
    }
    public String getnumOfProviders() {
        return numOfProviders;
    }
}
