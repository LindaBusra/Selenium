package MyPractice.ScreenShots;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Screenshot04 extends TestBase{


    @Test
    public void test() throws IOException {

        //amazon sayfasina gidip tum sayfanin fotografini cekelim
        driver.get("https://www.amazon.com");
        TakesScreenshot ts = (TakesScreenshot) driver;

        LocalDateTime dateNow = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String date= dateNow.format(dtf);

        File tumSayfaResim = new File(System.getProperty("user.dir")+ "/test-output/Screenshots/" + date + ".jpeg");

        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya, tumSayfaResim);





    }
}
