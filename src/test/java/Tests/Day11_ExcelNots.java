package Tests;

public class Day11_ExcelNots {

    /*
    With Java, microsoft files can be used to get data for automation. We will use excel.
    When you get data from external source(excel), it is known as DDT(DATA DRIVEN TESTING).
    When we change the data, the test case also changes. We control the test case by
    just controlling the test data.

    Excel can be used to create Data Driven Framework, or to do Data Driven Testing
    Excel is useful to store multiple data. We can get that data in the excel as external resource
    and use in automation scenarios.
    This is similar to cucumber (Scenario Outlines).
    Excel reports are popular and useful in projects.

    ★Workbook-> The excel file
    ★Worksheet->Each open excel tab like Sheet1, Sheet2, etc
    ★Row->Java counts rows if and only if there is data inside. By Default, the number of row is
    0 from Java perspective
    ★Cells-> Java will look at each row and count the number of cell if and only if there is
    data in the cell.
    ★Workbook > Worksheet > Row > Cell. There is no Column from the JAVA perspective. Column
    is the combination of Row and Cell

    ● Apache POI is the Java API to access microsoft offices.
    ● Poi.apache.org -> the official documentation is there
    ● To use excel, do the following:

     Go to https://mvnrepository.com/ ,get the apache poi dependency, and add to your pom.xml

     */
}
