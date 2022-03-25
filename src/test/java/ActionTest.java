import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionTest extends BaseTest {

    //By twiceClickBtn = By.cssSelector("#bottom");


    @Test
    public void ActionPerform(){


        Actions actions = new Actions(driver);
        //driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");
        //actions.contextClick().perform();
        //actions.contextClick(driver.findElement(twiceClickBtn)).perform();
        //actions.doubleClick(driver.findElement(twiceClickBtn)).perform();

        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        actions.moveToElement(driver.findElement(By.tagName("h1"))).perform();
    }
}
