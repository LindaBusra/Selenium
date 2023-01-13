package MyPractice.ExcelAutomation;

import org.apache.poi.ss.usermodel.Sheet;
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


public class P21_Excel06 extends TestBase {

    @Test
    public void readExcelTest() throws IOException {


        //1. Dosya yolunu bir String degiskene atayalim
        String filePath = "src/test/java/resources/countries.xlsx";

        //2. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(filePath);

        //3. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sheet1");

        //satir sayisi
        int numOfRow = workbook.getSheet("Sheet1").getLastRowNum();
        System.out.println("Number of Row:" + numOfRow);
        int numOfCell = workbook.getSheet("Sheet1").getRow(0).getLastCellNum();
        System.out.println("Number of Cell:" + numOfCell);

        //map'e yerlestirme

        Map<String, String> companies = new HashMap<>();

        for(int i=0; i<=numOfRow; i++) {

            String key = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();

            String value = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString() + "," +
                    workbook.getSheet("Sheet1").getRow(i).getCell(2).toString() + "," +
                    workbook.getSheet("Sheet1").getRow(i).getCell(3).toString();

            companies.put(key, value);
            System.out.println(key + " , " + value);
        }

        System.out.println(companies);




        //Multidimensional array'e yerlestirme:  !!!  bir satir eksik cikariyor,  <=numOfRows dedigimde ise hata veriyor

        String[][] countries = new String[numOfRow][numOfCell];
        for (int i = 0; i <numOfRow; i++) {
            for (int j = 0; j <numOfCell; j++) {
                countries[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();

            }
        }

        System.out.println(Arrays.deepToString(countries));



        // Listede Google oldugunu test edelim
        Assert.assertTrue(companies.keySet().contains("Google"));



    }
    }