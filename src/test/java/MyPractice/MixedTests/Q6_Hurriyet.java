package MyPractice.MixedTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q6_Hurriyet extends TestBase {


    @Test
    public void test() throws InterruptedException {

        //2. Navigate to url 'http://https://www.hurriyet.com.tr/'
        driver.get("https://www.hurriyet.com.tr/");
        driver.findElement(By.xpath(("//p[@class='fc-button-label']"))).click();
        System.out.println("izin vere tiklandi");
        Thread.sleep(5000);
        WebElement iframe= driver.findElement(By.xpath("//iframe[@src='https://www.hurriyet.com.tr/netmera_worker.html#origin=https%3A%2F%2Fwww.hurriyet.com.tr&wSrc=https%3A%2F%2Fntm.netmera-web.com%2Fwsdk2%2Ffbox.js%3Fv%3D4.2.15&cb_msg=fbox_ready']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//div[@class='btn-notification btn-secondary']")).click();
        System.out.println("daha sonraya tiklandi");
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("SPOR ARENA")).click();
        driver.findElement(By.linkText("Fenerbahçe")).click();   //
        driver.findElement(By.xpath(("//span[@class='swiper-pagination-bullet'][4]"))).click();
        /*
        1-http://https://www.hurriyet.com.tr/  sayfasina gidin
        2-sirasiyla gelen uyarailari kapatin
        3-en ust menudeki Spor Arena'ya gidin.
        4-Burda istediginiz takimin amblemine tiklayin.
        5-gelen sayfada orta kisimdaki haberlerden birinin acilmaisni sgalayin.
         */


    }
}