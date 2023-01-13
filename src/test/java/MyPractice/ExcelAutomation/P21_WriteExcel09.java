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

public class P21_WriteExcel09 extends TestBase {
    //1) Yeni bir Class olusturalim WriteExcel
    //2) Yeni bir test method olusturalim writeExcelTest()
    //3) Adimlari takip ederek 1.satira kadar gidelim


    @Test
    public void test() throws IOException {

    String pathOfFile =  "src/test/java/resources/countries.xlsx";
    FileInputStream fis = new FileInputStream(pathOfFile);
    Workbook workbook = WorkbookFactory.create(fis);


   //4) 5.hucreye yeni bir cell olusturalim
   //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        workbook.getSheet("Sheet1").getRow(0).createCell(4).setCellValue("Nufus");
        System.out.println("1");

    //6) 2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sheet1").getRow(1).createCell(4).setCellValue("1500000");
        System.out.println("2");

    //7) 10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sheet1").getRow(6).createCell(4).setCellValue("15000");
        System.out.println("3");

    //8) Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(pathOfFile);
        workbook.write(fos);
        System.out.println("4");

    //9)Dosyayi kapatalim
        fis.close();
        fos.close();


    }


}





