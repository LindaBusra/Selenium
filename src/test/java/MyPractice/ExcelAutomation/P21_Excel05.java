package MyPractice.ExcelAutomation;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;

public class P21_Excel05 extends TestBase {

        @Test
        public void readExcelTesti() throws IOException {

            //1. Dosya yolunu bir String degiskene atayalim
            String pathFile = "src/test/java/resources/countries.xlsx";

            //2. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
            FileInputStream fis = new FileInputStream(pathFile);

            //3. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
            // WorkbookFactory.create(fileInputStream)
            Workbook workbook = WorkbookFactory.create(fis);

            //4.  sayfa 2'ye gidip, satir sayisinin 24, kullanilan satir sayisinin ise 12 oldugunu test edin
            int lastRowNum = workbook.getSheet("Sheet2").getLastRowNum();
            int expectedRowNum = 24;
            Assert.assertEquals(expectedRowNum, lastRowNum + 1);

            int numberOfUsedRow = workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
            int expectedNumberOfUsedRow = 12;
            Assert.assertEquals(expectedNumberOfUsedRow, numberOfUsedRow);









        }
}
