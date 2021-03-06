package testNG_Theory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExceptionTest {

    @DataProvider
    public Object[][] wrongData() {
        return new Object[][]{
                {"Hello, World!!!"},
                {"0x245"},
                {"1798237199878129387197238"},
        };
    }

    @Test(dataProvider = "wrongData", expectedExceptions = NumberFormatException.class,
            expectedExceptionsMessageRegExp = "^For input string: \"(.*)\"$")
    public void testParse(String data) {
        Integer.parseInt(data);
    }
}