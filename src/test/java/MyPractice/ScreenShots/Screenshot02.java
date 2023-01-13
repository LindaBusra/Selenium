package MyPractice.ScreenShots;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot02 extends TestBase {

    ////screenshot of amazon image

    @Test
    public void test1() throws IOException {

        driver.get("https://www.amazon.com/");

        //take screenshot
        WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));
        File logoImage = amazonLogo.getScreenshotAs(OutputType.FILE);

        //save the image to path
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());  //getting the curreent local date and time
        String path = System.getProperty("user.dir")+ "/test-output/Screenshots/"+currentTime+".png";//Where we save the image
        FileUtils.copyFile(logoImage, new File(path));


    }

    @Test
    public void test2() throws IOException {

        driver.get("https://www.amazon.com/");

        //take screenshot
        WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));
        File logoImage = amazonLogo.getScreenshotAs(OutputType.FILE);

        //save the image to path
        File signInButtonFile = amazonLogo.getScreenshotAs(OutputType.FILE);
        File signInButtonDestFile = new File("amazonLogo.png");
        FileUtils.copyFile(signInButtonFile, signInButtonDestFile);

    }
}
