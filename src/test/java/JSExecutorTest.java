import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pl.testeroprogramowania.BaseTest;

public class JSExecutorTest extends BaseTest {
    @Test
    public void executeJS(){

        String baseUrl = "https://testeroprogramowania.github.io/selenium/";
        driver.get(baseUrl);
        WebElement basePageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", basePageLink);

        WebElement firstName = driver.findElement(By.name("fname"));
        executor.executeScript("arguments[0].setAttribute('value', 'Tomek')", firstName);
    }
}
