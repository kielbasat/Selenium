import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SecondTest extends BaseTest {

    @Test
    public void firstTest() {

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.cssSelector("#clickOnMe")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        driver.findElement(By.cssSelector("p"));

        String paragraphText = driver.findElement(By.cssSelector("p")).getText();

        Assert.assertEquals(paragraphText,"Dopiero się pojawiłem!");
    }

    @Test
    public void secondTest() {

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.cssSelector("#clickOnMe")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        driver.findElement(By.cssSelector("p"));

        String paragraphText = driver.findElement(By.cssSelector("p")).getText();

        Assert.assertEquals(paragraphText,"Dopiero się pojawiłem!");
    }
}