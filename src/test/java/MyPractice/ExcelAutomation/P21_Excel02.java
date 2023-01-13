package MyPractice.ExcelAutomation;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;


public class P21_Excel02 extends TestBase {

    @Test
    public void readExcelTesti() throws IOException {

// Create a method that takes the row and column values as parameters and returns the data in that cell as a String.

        //for example row =5, column 2
        int row=5;
        int cell=2;

        String actualData = getData(row-1,cell-1);
        String expectedData = "Ankara";
        Assert.assertEquals(expectedData, actualData);
        System.out.println("Test passed");

    }



    public static String getData(int rowNo, int cellNo) throws IOException {

        String filePath = "src/test/java/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        String data = workbook.getSheet("Sheet1").getRow(rowNo).getCell(cellNo).toString();

        return data;

    }
}