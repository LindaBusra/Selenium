package MyPractice.ExcelAutomation;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;
import utilities.TestBase;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

public class P21_Excel07 extends TestBase {

    @Test
    public void readExcelTest() throws IOException {

        //1. Dosya yolunu bir degsikene atadim
        String filePath = "src/test/java/resources/Capitals.xlsx";

        //2. FileInputStream objesine parametre olarak dosya yolunu girdim
        FileInputStream fis = new FileInputStream(filePath);

        //3. Workbook objesi olusturdum
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sheet1");

        // 1. adim: satir sayisini bul
        int numberOfRow = workbook.getSheet("Sheet1").getLastRowNum();

        //2. adim : sutun sayisini bul
        Row row = workbook.getSheet("Sheet1").getRow(0);
        int numberOfCell = row.getLastCellNum();

        System.out.println("Number Of Rows: " + numberOfRow);
        System.out.println("Number Of Cells: " + numberOfCell);


        //son satiri alamiyorum !!!!

        String[][] countries = new String[numberOfRow][numberOfCell];
        for (int i = 0; i < numberOfRow; i++) {
            for (int j = 0; j < numberOfCell; j++) {
                countries[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();

            }
        }

        System.out.println(Arrays.deepToString(countries));


        //Soru: Fransa'nin başkenti neresidir?
        for (int i = 0; i < numberOfRow; i++) {
            if (countries[i][0].equals("France")) {
                System.out.println("France's hovedstad is :" + countries[i][1]);
            }
        }
    }

}