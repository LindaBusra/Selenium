package MyPractice.ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;



public class P21_Excel01 {


     //1. apache poi dependency’i pom file’a ekleyelim
    //2. Java klasoru altinda resources klasoru olusturalim
    //3. Excel dosyamizi resources klasorune ekleyelim
    //4. excelAutomation isminde bir package olusturalim
    //5. ReadExcel isminde bir class olusturalim
    //6. readExcel() method olusturalim
    //7. Dosya yolunu bir String degiskene atayalim
    //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim

    //https://github.com/gokhanagar/Selenium/blob/master/jUnit/src/test/java/day14_excel/C01_ReadExcel.java

    @Test
    public void test() throws IOException {


        //7. Dosya yolunu bir String degiskene atayalim
        String filePath = "src/test/java/resources/countries.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(filePath);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim //WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //10. sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sheet1");

        //11. row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3);

        //12. Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(2);
        System.out.println(cell);

        //3.indexteki satirin 2.indexteki datanin Norway oldguunu test edin
        String expectedData = "Norway";
        String actualData = cell.toString();

        Assert.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData, cell.getStringCellValue());


        //or
        String actualData1 = workbook.getSheet("Sheet1").
                getRow(3).getCell(2).toString();
        System.out.println(actualData1);


    }

}
