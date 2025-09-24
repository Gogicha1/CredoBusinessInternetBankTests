package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "languages")
    public Object[][] languages() {
        return new Object[][] {
                {"ka"},
                {"en"},
                {"ru"}
        };
    }
}
