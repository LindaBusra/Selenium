package Tests;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
Apache POI,  where POI stands for (Poor Obfuscation Implementation)  is an API that offers a collection of Java libraries
that helps us to read, write, and manipulate different Microsoft files such as excel sheets, power-point, and word files.

String - getStringCellValue()  [It can be used to read Name of the student from Excel ]     ////Get the address in a variable
Number - getNumericCellValue() [It can be used to read the mobile number of the student]
Date - getDateCellValue() [It can be used to read the Date of Birth of the student]


    ★Workbook-> The excel file
    ★Worksheet->Each open excel tab like Sheet1, Sheet2, etc
    ★Row->Java counts rows if and only if there is data inside. By Default, the number of row is
    0 from Java perspective
    ★Cells-> Java will look at each row and count the number of cell if and only if there is
    data in the cell.
    ★Workbook > Worksheet > Row > Cell. There is no Column from the JAVA perspective. Column
    is the combination of Row and Cell

 */

public class Day11_ReadExcel {


    /*
    Import the apache poi dependency in your pom file
    Create resources directory under java folder(right click on java and
    create the folder)
    Add the excel file on the resources folder
    Create a new class : ReadExcel
    Create a new test method : readExcel()
    Store the path of the file in a string
    Open the file
    Open the workbook using fileinputstream
    Open the first worksheet
    Go to first row
    Go to first cell on that first row and print
    Go to second cell on that first row and print
    Go to 2nd row first cell and assert if the data equal to USA
    Go to 3rd row 2nd cell-chain the row and cell
    Find the number of row
    Find the number of used row
    Print country, capitol key value pairs as map object
     */
    //workbook>worksheet>row>cell

    //If you get multiple data from excel sheet it knowns Data Driven Testing


    @Test
    public void readExcelTest() throws IOException {

        //Store the path of the file in a string
        String pathFile = "./src/test/java/resources/Capitals.xlsx";

        //Open the file
        FileInputStream fis = new FileInputStream(pathFile);        //where is the file

        //Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fis);        //get the excell sheet

        //Open the first worksheet
        Sheet sheet = workbook.getSheet("Sheet1");      //index for sheet is 0
        //workbook.getSheetAt(0);

        //Go to first row
        Row row1 = sheet.getRow(0) ;     //index start from 0, goint to the first row

       //Go to first cell on that first row and print
        Cell cell1 = row1.getCell(0);
        System.out.println("cell:" + cell1);
        System.out.println("cell:" + cell1.toString());   // we can use string manipulation methods   contains....
        System.out.println("cell:" + cell1.getStringCellValue());

        //Go to second cell on that first row and print
        Cell cell2 = sheet.getRow(0).getCell(1);
        System.out.println(cell2);


        //Go to 2nd row first cell and assert if the data equal to USA
        String actual = sheet.getRow(1).getCell(0).toString();
        String expected = "USA";

        Assert.assertEquals(expected, actual);

        //Go to 3rd row 2nd cell-chain the row and cell
        System.out.println(sheet.getRow(2).getCell(1).toString());


        //Find the total number of row
        //To get the last number: getLastRowNum(),  To get the first number : getFirstRowNum()
        int numberOfRow = sheet.getLastRowNum() + 1;
        System.out.println("Total number Of Row in Sheet :" + numberOfRow);       //with header


        //Find the number of used row   //if there is empty row, it does not count it
        int number = workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
        System.out.println("The number of used row:" + number);

        //number of cell
        int numOfCell = sheet.getRow(1).getLastCellNum();
        System.out.println("Number Of Cell in Sheet : " + numOfCell);


        //Print country, capital key value pairs as map object
//        for(int i=0; i<numberOfRow; i++) {
//            System.out.println(sheet.getRow(i).getCell(0).toString() + " : " + sheet.getRow(i).getCell(1).toString());
//        }


        //Create a Map that wil store the country, capital pairs
        Map<String, String> countryCapitals = new HashMap<>();

        for(int i=1; i<numberOfRow; i++) {

            String key = sheet.getRow(i).getCell(0).toString();     //key

            String value = sheet.getRow(i).getCell(1).toString();       //value

            countryCapitals.put(key, value);

        }

        System.out.println(countryCapitals);

    }
}
