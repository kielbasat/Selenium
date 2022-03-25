import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BasicsHomeWorkTest extends BaseTest {

    String baseUrl = "https://testeroprogramowania.github.io/selenium/basics.html";

    @Test
    public void checkHeadingText() throws IOException {

        driver.get(baseUrl);

        WebElement heading = driver.findElement(By.tagName("h1"));
        Actions action = new Actions(driver);
        action.moveToElement(heading).perform();

        String headingText = heading.getText();
        Assert.assertEquals(headingText, "Witaj na stronie testowej");

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File headingScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(headingScreenshot, new File("src/test/resources/screen.png"));
    }

    @Test
    public void getBtnText() {

        driver.get(baseUrl);
        WebElement clickMeBtn = driver.findElement(By.cssSelector("#clickOnMe"));
        Assert.assertEquals(clickMeBtn.getText(), "Kliknij mnie!");
    }

    @Test
    public void checkValueInFirstNameInput() {
        driver.get(baseUrl);
        WebElement firstNameInput = driver.findElement(By.name("fname"));
        firstNameInput.click();
        firstNameInput.sendKeys("Selenium");
        Assert.assertEquals(firstNameInput.getAttribute("value"), "Selenium");
    }

    @Test
    public void getLinkText() {
        driver.get(baseUrl);
        WebElement linkText = driver.findElement(By.cssSelector("a[href='https://www.w3schools.com'"));
        System.out.println(linkText.getText());

        Assert.assertEquals(linkText.getText(), "Visit W3Schools.com!");

        linkText.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.w3schools.com/");
    }

    @Test
    public void getTableTextValue() {
        driver.get(baseUrl);
        WebElement firstRecordInTable = driver.findElement(By.cssSelector("tbody th:first-child"));
        System.out.println(firstRecordInTable.getText());
    }

    @Test
    public void selectSaabFromDropdown() {
        driver.get(baseUrl);
        WebElement selector = driver.findElement(By.cssSelector("select"));

        Select select = new Select(selector);
        select.selectByIndex(1);

        List<WebElement> option = select.getOptions();
        String currentCar = option.get(1).getText();

        Assert.assertEquals(currentCar, "Saab");
    }

    @Test
    public void selectCheckBox() {
        driver.get(baseUrl);
        WebElement checkbox = driver.findElement(By.cssSelector("input[type=checkbox]"));
        checkbox.click();
    }

    @Test
    public void selectRadioBtn() {
        driver.get(baseUrl);
        WebElement radioBtn = driver.findElement(By.cssSelector("input[value=male]"));
        radioBtn.click();
        String maleGender = radioBtn.getAttribute("value");

        Assert.assertEquals(maleGender, "male");
    }

    @Test
    public void checkUsernameInputValue() {
        driver.get(baseUrl);
        WebElement usernameInput = driver.findElement(By.cssSelector("[name=username]"));
        usernameInput.clear();
        usernameInput.sendKeys("Tomek");
        String valueProvided = usernameInput.getAttribute("value");
        Assert.assertEquals(valueProvided, "Tomek");
    }
    @Test
    public void checkHiddenParagraphValue() {
        driver.get(baseUrl);
        WebElement paragraph = driver.findElement(By.cssSelector(".topSecret"));

        String paragraphAttributeValue = paragraph.getAttribute("textContent");

        Assert.assertEquals(paragraphAttributeValue, "This paragraph should be hidden.");
    }
    @Test
    public void checkChildElement() {
        driver.get(baseUrl);
        WebElement listElementValue = driver.findElement(By.cssSelector("ul>li li:first-child"));
        String childTextValue = listElementValue.getText();

        Assert.assertEquals(childTextValue, "Child");
    }

}

