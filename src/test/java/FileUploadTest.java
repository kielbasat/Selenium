import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class FileUploadTest extends TestBase {

    int randomNumber = (int) (Math.random()*1000);

    @Test
    public void uploadFile() throws IOException {

        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        TakesScreenshot screenshot = (TakesScreenshot) driver;

        String beforeFileName = "beforeUpload" + randomNumber + ".png";
        File before = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(before, new File("src/test/resources/" + beforeFileName));

        driver.findElement(By.cssSelector("#myFile")).sendKeys("C:\\Users\\kielbast\\Documents\\sample.txt");

        String afterFileName = "afterUpload" + randomNumber + ".png";
        File after = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(after, new File("src/test/resources/" + afterFileName));

        LocalDate nowDate = LocalDate.now();
        String afterFileNameDate = "afterUpload" + nowDate + ".png";
        File afterDate = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(afterDate, new File("src/test/resources/" + afterFileNameDate));








    }
}
