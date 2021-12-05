package org.selenium.pom.objects;

public class TestData {
    // This class stores all data used in tests
    private final String investInputValue = "2137";
    private final String investInitial = "3000";
    private final String numOfProviders = "4";
    private final String testUrl = "https://staging:staging@staging.buyshares.co.uk/test-ssr/";
    private final int expectedProviderCount = 4;

    public TestData() {}

    // These methods return test data defined above.
    public String getInvestInputValue() {
        return investInputValue;
    }
    public String getinvestInitial() {
        return investInitial;
    }
    public String gettestUrl() {
        return testUrl;
    }
    public int getexpectedProviderCount() {return expectedProviderCount;}
    public String getnumOfProviders() {
        return numOfProviders;
    }
}
