package MyPractice.ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class P21_Excel04 {

    //        //https://www.toolsqa.com/selenium-webdriver/excel-in-selenium/   See!!!

    @Test
    public void readExcel() throws IOException {

        //Store the path of the file in a string
        String pathFile = "src/test/java/resources/countries.xlsx";

        //Open the workbook using fileinputstream
        FileInputStream fis = new FileInputStream(pathFile);

        //Open the first worksheet
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sheet1");

        //Go to first row
        Row row = sheet.getRow(0);

        //Go to first cell on that first row and print
        Cell cell = row.getCell(0);

        //Go to second cell on that first row and print
        System.out.println(row.getCell(1));


        //Go to 2nd row first cell and assert if the data equal to Oracle
        String actualData = sheet.getRow(1).getCell(0).toString();
        String expectedData = "Oracle";
        Assert.assertTrue(actualData.equals(expectedData));


        //Find the number of row
        int numberOfRow = sheet.getLastRowNum();
        System.out.println("Number Of Row in Sheet :" + numberOfRow);       //it gives the number of row, without header


        //Find the number of used row
        int usedRow = sheet.getPhysicalNumberOfRows();
        System.out.println("the number of used row : " + usedRow);      //it gives the number of row, with header


        //number of cell, get cell count in a row
        int numberOfCell = sheet.getRow(0).getLastCellNum();
        System.out.println("Number of cell : " + numberOfCell);


        //iterate over all the row to print the data present in each cell.
        for(int i=0; i<=numberOfRow; i++) {

            System.out.println("Data in row" + (i) + " is:");

            for(int j=0; j<numberOfCell; j++) {
                System.out.println(sheet.getRow(i).getCell(j).getStringCellValue() + " ");
            }
            System.out.println();
        }



    }
}
