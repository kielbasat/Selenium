package pl.testeroprogramowania;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FourthTest extends BaseTest {

    @Test(dataProvider = "data")
    public void dpTest(String value, String number) {
        System.out.println(value);
        System.out.println(number);
    }

    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        return new Object[][] {{"I am first test","1st"},{"Im second test", "2nd"},{"Im third test", "3rd"},
                {"Im fourth test", "4th"}};
        }
    }
