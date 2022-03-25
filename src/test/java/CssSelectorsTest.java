import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pl.testeroprogramowania.BaseTest;

public class CssSelectorsTest extends BaseTest {

    String baseUrl = "https://testeroprogramowania.github.io/selenium/basics.html";

    @Test
    public void findElementById() {
        driver.get(baseUrl);

        By cssId = By.cssSelector("#clickOnMe");
        driver.findElement(cssId);

        By cssClass = By.cssSelector(".topSecret");
        driver.findElement(cssClass);

        By cssClassValue = By.cssSelector("[class='topSecret']");
        driver.findElement(cssClassValue);

        By cssTagName = By.cssSelector("input");
        driver.findElement(cssTagName);

        By cssAttributeName = By.cssSelector("[name='fname']");
        driver.findElement(cssAttributeName);

        By cssAllElements = By.cssSelector("*");
        driver.findElement(cssAllElements);

        By cssTbody = By.cssSelector("tbody tr");
        driver.findElement(cssTbody);

        By cssUl = By.cssSelector("div ul");
        driver.findElement(cssUl);

        By cssUlUnderDiv = By.cssSelector("div > ul");
        driver.findElement(cssUlUnderDiv);

        By cssTrUnderTbody = By.cssSelector("tbody > tr");
        driver.findElement(cssTrUnderTbody);

        By firstFormAfterLabel = By.cssSelector("label + form");
        driver.findElement(firstFormAfterLabel);

        By allFormsAfterLabel = By.cssSelector("label ~ form");
        driver.findElement(allFormsAfterLabel);

        By attrTag = By.cssSelector("input[name='fname']");
        By attrContains = By.cssSelector("[name*='nam']");
        By attrStartsWith = By.cssSelector("[name^='fn']");
        By attrEndsWith = By.cssSelector("[name$='me']");

        driver.findElement(attrTag);
        driver.findElement(attrContains);
        driver.findElement(attrStartsWith);
        driver.findElement(attrEndsWith);

        By firstChild = By.cssSelector("li:first-child");
        By lastChild = By.cssSelector("li:last-child");
        By fourthChild = By.cssSelector("li:nth-child(4)");

        driver.findElement(firstChild);
        driver.findElement(lastChild);
        driver.findElement(fourthChild);
    }
}
