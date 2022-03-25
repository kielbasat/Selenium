import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pl.testeroprogramowania.BaseTest;

import java.util.List;

public class SelectorTest extends BaseTest {

    String baseUrl = "https://testeroprogramowania.github.io/selenium/basics.html";

    @Test
    public void findElementById() {
        driver.get(baseUrl);
        By buttonId = By.id("clickOnMe");
        WebElement clickOnMeBtn = driver.findElement(buttonId);
    }

    @Test
    public void findElementByName() {
        driver.get(baseUrl);
        By fieldName = By.name("fname");
        driver.findElement(fieldName);
    }

    @Test
    public void findElementByClass() {
        driver.get(baseUrl);
        By paragraphClassName = By.className("topSecret");
        driver.findElement(paragraphClassName);
    }

    @Test
    public void findElementByTagName() {
        driver.get(baseUrl);
        By inputLocator = By.tagName("input");
        driver.findElement(inputLocator);
    }

    @Test
    public void findElementsByTagName() {
        driver.get(baseUrl);
        By inputLocator = By.tagName("input");
        List<WebElement> inputs = driver.findElements(inputLocator);
        System.out.println(inputs.size());
    }

    @Test
    public void findElementsByLinkText() {
        driver.get(baseUrl);
        By linkText = By.linkText("Visit W3Schools.com!");
        driver.findElement(linkText);
        By partialLinkText = By.partialLinkText("Visit W3Schools.com");
        driver.findElement(partialLinkText);
    }
}

