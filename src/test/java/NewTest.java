import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewTest extends TestBase {


    @Test
    public void newTest() {

        driver.get("https://www.google.pl/");
        driver.findElement(By.cssSelector(".EM1Mrb")).click();
        WebElement searchBar = driver.findElement(By.cssSelector("div>.gLFyf"));
        searchBar.click();
        searchBar.sendKeys("gulugulu video");
        searchBar.sendKeys(Keys.ENTER);

        WebElement movieElement = driver.findElement(By.cssSelector(".PhiYYd .twQ0Be"));

        Assert.assertTrue(movieElement.isDisplayed());
    }

    @Test
    public void openGooglePage() {
        driver.get("https://www.google.pl/");
        driver.findElement(By.cssSelector("#L2AGLb")).click();
        WebElement inputField = driver.findElement(By.cssSelector("input.gLFyf"));
        inputField.sendKeys("Selenium");
        inputField.sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement linkForFirstResult = driver.findElement(By.cssSelector(".DKV0Md"));


        Boolean isFirstLinkDisplayed = linkForFirstResult.isDisplayed();
        Assert.assertTrue(isFirstLinkDisplayed);

    }
}

