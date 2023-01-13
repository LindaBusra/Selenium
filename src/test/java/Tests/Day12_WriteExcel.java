package Tests;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day12_WriteExcel extends TestBase {
    /*
    Create a new class: WriteExcel
    Create a new method: writeExcel()
    Store the path of the file as string and open the file
    Open the workbook
    Open the first worksheet
    Go to the first row
    Create a cell on the 3rd column (2nd index) on the first row
    Write “POPULATION” on that cell
    Create a cell on the 2nd row 3rd cell(index2), and write 150000
    Create a cell on the 3rd row 3rd cell(index2), and write 250000
    Create a cell on the 4th row 3rd cell(index2), and write 54000
    Write and save the workbook
    Close the file
    Close the workbook
     */

    //https://www.seleniumeasy.com/jxl-tutorials/set-data-with-formatting-styles-into-excel-sheet

    @Test
    public void excelWriteTest() throws IOException {

        //Store the path of the file in a string
        String pathFile = "./src/test/java/resources/Capital.xlsx";

        //Open the workbook using fileinputstream
        FileInputStream fis = new FileInputStream(pathFile);
        Workbook workbook = WorkbookFactory.create(fis);

        //Open the first worksheet
        Sheet sheet = workbook.getSheet("Sheet1");

        //Go to first row
        Row row = sheet.getRow(0);

        //Create a cell on the 3rd column (2nd index) on the first row
        Cell cell = row.getCell(2);


        //Write “POPULATION” on that cell
        row.createCell(2).setCellValue("Population");

        //Create a cell on the 2nd row 3rd cell(index2), and write 150000
        sheet.getRow(1).createCell(2).setCellValue("150000");

        //Create a cell on the 3rd row 3rd cell(index2), and write 250000
        sheet.getRow(2).createCell(2).setCellValue("250000");

        //Create a cell on the 4th row 3rd cell(index2), and write 54000
        sheet.getRow(3).createCell(2).setCellValue("54000");

        //Write and save the workbook
        FileOutputStream fos = new FileOutputStream(pathFile);      //for save excel sheet (without this I can not create anything)
        workbook.write(fos);


        //Close the file
        fis.close();    //FileInputStream
        fos.close();    //FileOutputStream

        //Close the workbook
        workbook.close();






    }
}