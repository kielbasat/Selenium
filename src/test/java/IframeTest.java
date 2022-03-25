import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest {

    String baseUrl = "https://testeroprogramowania.github.io/selenium/iframe.html";
    By firstNameInputCss = By.cssSelector("#fname");
    By h1IframeCss = By.tagName("h1");
    By h1MainPageCss = By.tagName("h1");

    @Test
    public void iFrameTest() {

        driver.get(baseUrl);
        WebElement iFrameElement = driver.findElement(By.cssSelector("[src='basics.html']"));
        driver.switchTo().frame(iFrameElement);
        //driver.switchTo().frame(0);
        driver.findElement(firstNameInputCss);
        String h1IframeText = driver.findElement(h1IframeCss).getText();

        driver.switchTo().defaultContent();
        String h1MainPageText = driver.findElement(h1MainPageCss).getText();

        Assert.assertEquals(h1IframeText, "Witaj na stronie testowej");
        Assert.assertEquals(h1MainPageText, "To jest test iframe");
    }
}
