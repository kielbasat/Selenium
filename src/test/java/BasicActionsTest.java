import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionsTest extends BaseTest {

    String baseUrl = "https://testeroprogramowania.github.io/selenium/";
    By basicLinkCss = By.cssSelector("[href='basics.html']");
    By buttonClickMeCss = By.cssSelector("#clickOnMe");
    By firstNameInputCss = By.cssSelector("input[name='fname']");
    By userNameInputByName = By.name("username");
    By termsAndConditionsCheckbox = By.cssSelector("input[type='checkbox']");
    By genderSelector = By.cssSelector("input[value='other']");

    @Test
    public void performAction() {

        driver.get(baseUrl);

        driver.findElement(basicLinkCss).click();
        driver.findElement(firstNameInputCss).sendKeys("Tomek");
        driver.findElement(buttonClickMeCss).click();
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();

        WebElement userNameInput = driver.findElement(userNameInputByName);
        userNameInput.clear();
        userNameInput.sendKeys("admin");
        userNameInput.sendKeys(Keys.ENTER);
        Alert secondAlert = driver.switchTo().alert();
        secondAlert.accept();
        secondAlert.accept();

        driver.findElement(termsAndConditionsCheckbox).click();
        driver.findElement(genderSelector).click();
        driver.findElement(userNameInputByName);

        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCar);
        cars.selectByIndex(2);
        cars.selectByValue("volvo");
        cars.selectByVisibleText("Mercedes");

        List<WebElement> options = cars.getOptions();

        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        HomeWorkBasicActionsTest check = new HomeWorkBasicActionsTest();
        System.out.println(check.selectPicker("Audi", driver.findElement(By.tagName("select"))));
        System.out.println(check.selectPicker("skoda", driver.findElement(By.tagName("select"))));

        WebElement para = driver.findElement(By.cssSelector("p"));

        System.out.println("By text: " + para.getText());
        System.out.println("By text: " + para.getAttribute("value"));
        System.out.println("By text: " + para.getAttribute("textContent"));

    }
}
