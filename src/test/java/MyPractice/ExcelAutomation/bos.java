package MyPractice.ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Tests.Day11_ExtentReports.extentReportsSetUp;


public class bos extends TestBase {



    @Test
    public void test()  throws IOException {

        //n11 sitesine gidildi.
        driver.get("https://www.n11.com");
//        driver.manage().deleteAllCookies();
//        driver.findElement(By.xpath("//button[@class='dn-slide-deny-btn']")).click();

        //Actions ile Mağazalar yazısının üstüne gelindi.


        //Açılan menü-de Mağazaları gör tıklandı.


        //Açılan sayfada Tüm Mağazalar tıklandı


        //A harfi ile başlayan mağazalar Liste aktarıldı.


        // workbook'da N11 adında sheet oluşturuldu.


        // Sheet içinde satır-1,hücre-1 Mağazalar olarak isimlendirildi



        //For loop içinde N11 ismindeki sheet çağrıldı, her satırın 1-ci hücresine
        // a harfiyle başlayan mağazaların isimleri aktarıldı.


        //Dosyayi kaydedelim


        //Dosyayi kapatalim


    }

}
