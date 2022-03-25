package pl.testeroprogramowania;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

@Listeners(value = {SampleTestListener.class})
public class FirstTest extends BaseTest {

    @Test @Ignore
    public void firstTest() {
        System.out.println("begin of 1st test");

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.cssSelector("#clickOnMe")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        driver.findElement(By.cssSelector("p"));


        WebElement paragraphCss = driver.findElement(By.cssSelector("p"));

        Assert.assertEquals(paragraphCss.isDisplayed(), true);
        Assert.assertTrue(paragraphCss.isDisplayed(), "element is not displayed");
        Assert.assertEquals(paragraphCss.getText(), "stefan", "text does not match expected one");
        Assert.assertTrue(paragraphCss.getText().startsWith("Dopiero"));
        Assert.assertFalse(paragraphCss.getText().startsWith("się"));


        System.out.println("end of 1st test");
    }

    @Test @Ignore
    public void secondTest() {

        System.out.println("begin of 2nd test");

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.cssSelector("#clickOnMe")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        driver.findElement(By.cssSelector("p"));

        String paragraphText = driver.findElement(By.cssSelector("p")).getText();

        Assert.assertEquals(paragraphText, "Dopiero się pojawiłem!");

        System.out.println("end of 2nd test");
    }

    @Test (priority = 0)
    public void thirdTest() {

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.cssSelector("#clickOnMe")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        driver.findElement(By.cssSelector("p"));


        WebElement paragraphCss = driver.findElement(By.cssSelector("p"));

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(paragraphCss.isDisplayed(), true);
        softAssert.assertTrue(paragraphCss.isDisplayed(), "element is not displayed");
        softAssert.assertEquals(paragraphCss.getText(), "stefan", "text does not match expected one");
        softAssert.assertFalse(paragraphCss.getText().startsWith("Dopiero"));
        softAssert.assertFalse(paragraphCss.getText().startsWith("się"));

        softAssert.assertAll();
    }
}