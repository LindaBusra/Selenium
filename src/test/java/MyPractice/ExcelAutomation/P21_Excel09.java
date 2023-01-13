package MyPractice.ExcelAutomation;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class P21_Excel09 extends TestBase {

    @Test
    public void test01() throws IOException {


        //n11 sitesine gidildi.
        driver.get("https://www.n11.com");
//        driver.manage().deleteAllCookies();
//        driver.findElement(By.xpath("//button[@class='dn-slide-deny-btn']")).click();

        //Actions ile Anne & Bebek'e gelindi.  Açılan menüde Bebek-Giyim'e tıklandı.
        Actions action = new Actions(driver);

        WebElement anneBebek = driver.findElement(By.xpath("//span[text()='Anne & Bebek']"));
        action.moveToElement(anneBebek);
        System.out.println("1");

        WebElement bebekGiyim = driver.findElement(By.xpath("//span[text()='Bebek Giyim']"));
        action.moveToElement(anneBebek).click(bebekGiyim).perform();
        System.out.println("2");

        WebElement yas3 = driver.findElement(By.xpath("//a[@data-id='1']"));
        yas3.click();
        System.out.println("3");


        //tum urunler listeye aktarilsin.
        List<WebElement> bebeGiyimList = driver.findElements(By.xpath("//h3[@class='productName']"));

        System.out.println("4");

        // workbook'da N11 adında sheet oluşturuldu.
        String dosyaYolu = "src/test/java/resources/n11Alisveris.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        // Sheet içinde satır-1,hücre-1 BebeGiyim olarak isimlendirildi
        workbook.getSheet("Sheet1").
                createRow(0).
                createCell(0).
                setCellValue("BebeGiyim");
        System.out.println("5");


        //For loop içinde N11 ismindeki sheet çağrıldı, her satırın 1-ci hücresine
        //bebeGiyimListesindeki urunlerin isimleri aktarıldı.

        for (int i = 0; i < bebeGiyimList.size(); i++) {

            workbook.getSheet("Sheet1").
                    createRow(i + 1).
                    createCell(0).
                    setCellValue(bebeGiyimList.get(i).toString());

        }
        System.out.println("6");

        //Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        System.out.println("7");

        //Dosyayi kapatalim
        fis.close();
        fos.close();


    }


}





