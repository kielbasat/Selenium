package pl.testeroprogramowania;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import static pl.testeroprogramowania.DriverFactory.driver;

public class SampleTestListener implements ITestListener{

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("I'm starting test");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("I'm taking screenshot");

        driver = DriverFactory.getDriver();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File getScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(getScreenshot, new File("src/test/resources/screenshot1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}