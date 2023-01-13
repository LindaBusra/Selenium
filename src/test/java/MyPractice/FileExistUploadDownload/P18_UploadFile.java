package MyPractice.FileExistUploadDownload;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P18_UploadFile extends TestBase {

    @Test
    public void test01() throws InterruptedException {


        //https://the-internet.herokuapp.com/upload adresine gidelim

        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim, Yuklemek istediginiz dosyayi secelim.

        /* bu islemi selenium ile yapma imkanimiz yok cunku web tabanli bir uygulama degil
        bu durumda sendKeys() imdadimiza yetisir. eger chooseFile butonuna var olan bir dosyanin dosya yolunu yollarsaniz
        secme islemi otomatik olarak yapilmis olacaktir.   */



        // 1.adim choose file butonunu locate edelim
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        System.out.println("1");

        // 2.adim yuklenecek doyanin dosya yolunu olusturalim.  //"C:\Users\busra\Downloads\LambdaTest.txt"

        String differentPart = System.getProperty("user.home");
        String commanPart = "\\Downloads\\LambdaTest.txt";
        String filePath = differentPart + commanPart;
        System.out.println("2");

        // 3. adim sendKeys ile dosya yolunu, secme butonuna yollayalim
        chooseFile.sendKeys(filePath);
        System.out.println("3");

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        System.out.println("4");

        //“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploaded = driver.findElement(By.xpath("//*[text()='File Uploaded!']"));
        Assert.assertTrue(fileUploaded.isDisplayed());
        System.out.println("5");


    }
}
