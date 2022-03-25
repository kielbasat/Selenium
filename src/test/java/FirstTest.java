import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTest extends BaseTest {

    @Test
    public void firstTest() {
        System.out.println("begin of 1st test");

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.cssSelector("#clickOnMe")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        driver.findElement(By.cssSelector("p"));

        String paragraphText = driver.findElement(By.cssSelector("p")).getText();

        Assert.assertEquals(paragraphText,"Dopiero się pojawiłem!");

        System.out.println("end of 1st test");
    }
    @Test
    public void secondTest() {

        System.out.println("begin of 2nd test");

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.cssSelector("#clickOnMe")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        driver.findElement(By.cssSelector("p"));

        String paragraphText = driver.findElement(By.cssSelector("p")).getText();

        Assert.assertEquals(paragraphText,"Dopiero się pojawiłem!");

        System.out.println("end of 2nd test");
    }
}