import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.out.println("running before test");
    }

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        driver = new ChromeDriver(option);
        System.out.println("running before method");
    }

    @AfterTest
    public void AfterTest() {
        System.out.println("running after test");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        System.out.println("running after method");
    }
}
