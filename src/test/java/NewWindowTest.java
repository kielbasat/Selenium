import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pl.testeroprogramowania.BaseTest;

import java.util.Set;

public class NewWindowTest extends BaseTest {

    By clickMeBtnCss = By.cssSelector("#newPage");
    By cookiesBtn = By.cssSelector("#L2AGLb .QS5gu");
    By inputSearchField = By.cssSelector("input.gLFyf");
    By firstNameInput = By.cssSelector("#fname");

    @Test
    public void newWindow(){
        String baseUrl = "https://testeroprogramowania.github.io/selenium/basics.html";

        driver.get(baseUrl);
        String currentWindowName = driver.getWindowHandle();
        driver.findElement(clickMeBtnCss).click();

        Set<String> windowNames = driver.getWindowHandles();
        for(String windowName : windowNames) {
            if(windowName != currentWindowName)
                driver.switchTo().window(windowName);
        }
        driver.findElement(cookiesBtn).click();
        driver.findElement(inputSearchField).sendKeys("Selenium");
        driver.switchTo().window(currentWindowName);
        driver.findElement(firstNameInput).sendKeys("Tomek");








    }
}
