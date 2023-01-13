package MyPractice.FileExistUploadDownload;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class P18_FileDownload extends TestBase {

    //1. https://the-internet.herokuapp.com/download adresine gidelim.
    //2. dummy.txt dosyasını indirelim
    //3. dosyanın başarıyla indirilip indirilmediğini test edelim
    //4. O dosya yolundaki dosyanin var oldugunu assert edelim


    @Test
    public void test(){


        //1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //2. dummy.txt dosyasını indirelim
        WebElement file = driver.findElement(By.linkText("LambdaTest.txt"));
        file.click();

        //3. dosyanın başarıyla indirilip indirilmediğini test edelim
        // dosya downloads'a indirilecektir, bize downloads'un dosya yolu lazim

        String differentPart = System.getProperty("user.home");
        String commanPart = "\\Downloads\\LambdaTest.txt";
        String filePath = differentPart + commanPart;



        //4. O dosya yolundaki dosyanin var oldugunu assert edelim
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

    }


}
