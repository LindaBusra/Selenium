package MyPractice.WindowHandleIframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Iframe01 extends TestBase {

        /*
     Iframe Home Work
    1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
    2. “Our Products” butonuna basin
    3. “Cameras product”i tiklayin
    4. Popup mesajini yazdirin
    5. “close” butonuna basin
    6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
    7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
  */

    @Test
    public void test(){

        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");


        //2. “Our Products” butonuna basin
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();
        System.out.println("1");


        //3. “Cameras product”i tiklayin
        driver.findElement(By.id("cameras")).click();
        System.out.println("2");


        //4. Popup mesajini yazdirin
        WebElement popUp = driver.findElement(By.xpath("//div[@class='modal-body']"));
        System.out.println(popUp.getText());
        System.out.println("3");

        //5. “close” butonuna basin
        driver.findElement(By.xpath("//button[text()='Close']"));
        System.out.println("4");


        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[@class='navbar-brand']")).click();
        System.out.println("5");


        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl = "http://webdriveruniversity.com/index.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        System.out.println("6");


    }
}
