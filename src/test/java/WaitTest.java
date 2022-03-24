import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class WaitTest extends TestBase {
    @Test
    public void sleepTest() throws InterruptedException {

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.cssSelector("#clickOnMe")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("p"));
    }

    @Test
    public void implicitWait() {

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("#clickOnMe")).click();
        driver.findElement(By.cssSelector("p"));
    }

    @Test
    public void explicitWait() {

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.cssSelector("#clickOnMe")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        driver.findElement(By.cssSelector("p"));
    }

    @Test
    public void fluentWait() {

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.cssSelector("#clickOnMe")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(5));
        wait.pollingEvery(Duration.ofMillis(500));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        driver.findElement(By.cssSelector("p"));

        waitForElementToExist(By.cssSelector("p"));
    }

    public void waitForElementToExist(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(5));
        wait.pollingEvery(Duration.ofMillis(500));

        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                List<WebElement> elements = driver.findElements(locator);
                if (elements.size() > 0) {
                    System.out.println("Element jest na stronie");
                    return true;
                } else {
                    System.out.println("Element nie jest na stronie");
                    return false;
                }
            }
        });

        wait.until(driver ->  {
                List<WebElement> elements = driver.findElements(locator);
                if (elements.size() > 0) {
                    System.out.println("Element jest na stronie");
                    return true;
                } else {
                    System.out.println("Element nie jest na stronie");
                    return false;
                }
        });
    }
}
