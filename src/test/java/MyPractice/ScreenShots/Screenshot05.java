package MyPractice.ScreenShots;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot05 extends TestBase {

    ////amazona gidip nutella aratalim ve sonuc sayisinin oldugu web elementin fotografini cekelim

    @Test
    public void test() throws IOException {


        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella", Keys.ENTER);

        //take screenshot
        WebElement resultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        File resultTextImage = resultText.getScreenshotAs(OutputType.FILE);

        //save the image to path
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());  //getting the curreent local date and time
        String path = System.getProperty("user.dir")+ "/test-output/Screenshots/"+currentTime+".png";//Where we save the image
        FileUtils.copyFile(resultTextImage, new File(path));
        System.out.println("passed");


    }

}
