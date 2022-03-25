import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pl.testeroprogramowania.BaseTest;

import java.util.List;

public class ElementsTest extends BaseTest {

    String baseUrl = "https://testeroprogramowania.github.io/selenium/basics.html";

    By paragraphCss = By.cssSelector(".topSecret");
    By paragraphSecondCss = By.cssSelector("p");

    @Test
    public void checkHiddenParagraphValue() {


        driver.get(baseUrl);

        System.out.println(elementExist(paragraphCss));
        System.out.println(elementExist(paragraphSecondCss));
        System.out.println(elementExistSecond(paragraphCss));
        System.out.println(elementExistSecond(paragraphSecondCss));
        System.out.println(elementExistThird(paragraphCss));
        System.out.println(elementExistThird(paragraphSecondCss));

        System.out.println("should be false: -> " + driver.findElement(paragraphCss).isDisplayed());
        System.out.println("button = should be true: -> " + driver.findElement(By.cssSelector("button")).isEnabled());
        System.out.println("checkbox = should be false: -> "
                + driver.findElement(By.cssSelector("input[type=checkbox]")).isSelected());
    }

    public boolean elementExist(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean elementExistSecond(By locator) {
        List<WebElement> listOfElements = driver.findElements(locator);
        if (listOfElements.size() > 0)
            return true;
        else
            return false;
    }

    public boolean elementExistThird(By locator) {
        return driver.findElements(locator).size() > 0;
    }



}