package Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.util.List;

public class Day12_WebTables extends TestBase {

    private static Logger logger = LogManager.getLogger(Day12_WebTables.class.getName());

    /*
    we use web tables on the browsers, we use excel sheet in our computers.
    We will write some xpaths for read web tables
     */

    /*
    https://the-internet.herokuapp.com/tables
    Create a class: WebTables
    Task 1 : Print the entire table
    Task 2 : Print All Rows
    Task 3 : Print Last row data only
    Task 4 : Print column 5 data in the table body
    Task 5 : Write a method that accepts 2 parameters
    Parameter 1 = row number
    Parameter 2 = column number
    printData(2,3);  => prints data in 2nd row 3rd column
     */

    @Test
    public void printTable() {


        logger.info("Going to home page");

        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 1 : Print the entire table

        System.out.println("Print entire table :");
        logger.info("Printing the webtable information");

        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        String entireTable = table.getText();
        System.out.println(entireTable);


        //Print All Table Data
        System.out.println("\nAll Table Data :");
        List<WebElement> tableData = driver.findElements(By.xpath("//table[@id='table1']//td"));

        for(WebElement w : tableData) {

            System.out.println(w.getText());
            logger.info(w.getText());
        }

        //We can get specific cell data
        System.out.println("5th data in the table :" + tableData.get(5).getText());

        //table[@id='table1']//tbody//tr  all row
        //table[@id='table1']//tbody//tr/4 only 4th. row
        //table[@id='table1']//tbody//tr[4]//td[5]  -->franks web side
        //table[@id='table1']//tbody//tr[2]//td[3] => fbach@yahoo.com
        //table[@id='table1']//tbody//tr[1]//td[1] => Smith
        //table[@id='table1']//tbody//tr[3]//td[4] => $100.00


    }

    @Test
    public void printRows(){

        //Task2: Print All Rows
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("\nAll rows :");
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));

        int rowNum = 1;
        for(WebElement w : allRows) {

            System.out.println("Row " + rowNum + " --> " + w.getText());
            rowNum++;
        }
        //We can get specific row data
        System.out.println("4th data in the table :" + allRows.get(4).getText());

        //Task 3: Print last row data only
        System.out.println("Last Row Data : "  + allRows.get(allRows.size()-1).getText());

    }

    @Test
    public void printColumns(){

        //Task 4 : Print column 5 data in the table body
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> col5Data = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));

        int colNum = 1;
        for(WebElement w : col5Data) {

            System.out.println("Row " + colNum + " Column 5 --> " + w.getText());
            colNum++;
        }

        }

    //        HOMEWORK
//        Task 5 : Write a method that accepts 2 parameters
//        Parameter 1 = row number
//        Parameter 2 = column number
//        printData(2,3);  => prints data in 2nd row 3rd column
    public void printData(int rowNum, int colNum){


        driver.get("https://the-internet.herokuapp.com/tables");
        String xpath = "//table[@id='table1']//tbody//tr[" + rowNum + "]//td[" + colNum + "]";
        WebElement cellData = driver.findElement(By.xpath(xpath));
        System.out.println(cellData.getText());

    }
    @Test
    public void printDataTest(){

        printData(2,3);//fbach@yahoo.com
        printData(4,1);//Conway
        printData(2,3); //fbach@yahoo.com
        printData(1,1); //Smith
        printData(4,4);
        printData(4,5);

    }
}
