import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImageTest extends BaseTest {
    @Test
    public void imageExist() {
        driver.get("https://testeroprogramowania.github.io/selenium/image.html");
        WebElement image = driver.findElement(By.cssSelector("#smileImage"));
        String imageHigh = image.getAttribute("naturalHeight");

        Assert.assertEquals(imageHigh, "0");

    }
}
