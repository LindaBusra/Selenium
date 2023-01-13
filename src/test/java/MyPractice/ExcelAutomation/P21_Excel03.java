package MyPractice.ExcelAutomation;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;

public class P21_Excel03 extends TestBase {

    @Test
    public void readExcelTest() throws IOException {

        //1. Dosya yolunu bir String degiskene atayalim
        String filePath = "src/test/java/resources/countries.xlsx";


        //2. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(filePath);

        //3. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim    //WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //4. Company_country sutununu yazdiralim
        int numberOfRow = workbook.getSheet("Sheet1").getLastRowNum();
        System.out.println("Satir sayisi : " + numberOfRow);        ////row number without header

        for (int i = 0; i <= numberOfRow; i++) {
            String cellData = workbook.getSheet("Sheet1").getRow(i).getCell(2).toString();
            System.out.println(cellData);
        }


        //Physical Number Of Rows
        int physicalNumberOfRows = workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
        System.out.println(physicalNumberOfRows);           //row number with header




    }

    }