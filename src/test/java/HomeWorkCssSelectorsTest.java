import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pl.testeroprogramowania.BaseTest;

import static org.testng.Assert.assertEquals;

public class HomeWorkCssSelectorsTest extends BaseTest {

    By cookiesAgreeBtn = By.cssSelector("#L2AGLb");
    By luckyBtn = By.cssSelector("div.FPdoLc input.RNmpXc");
    By searchField = By.cssSelector(".gLFyf");

    @Test
    public void googleLuckySearch(){
        driver.get("https://www.google.pl/");

        driver.findElement(cookiesAgreeBtn).click();
        driver.findElement(searchField).sendKeys("Selenium");
        driver.findElement(luckyBtn).click();

        assertEquals(driver.getCurrentUrl(), "https://www.selenium.dev/");

    }
}
