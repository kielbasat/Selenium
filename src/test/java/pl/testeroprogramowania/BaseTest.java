package pl.testeroprogramowania;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseTest {
    public WebDriver driver;

//    @BeforeSuite
//    public void beforeSuite(){
//        System.out.println("beforeSuite");
//    }
//
//    @BeforeClass
//    public void beforeClass(){
//        System.out.println("beforeClass");
//    }
//
//    @BeforeTest
//    public void beforeTest() {
//        System.out.println("running before test");
//    }

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        driver = new ChromeDriver(option);
    }

//    @AfterSuite
//    public void afterSuite(){
//        System.out.println("afterSuite");
//    }
//
//    @AfterClass
//    public void afterClass(){
//        System.out.println("afterClass");
//    }
//
//    @AfterTest
//    public void AfterTest() {
//        System.out.println("running after test");
//    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
