package MyPractice.WebTable;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P20_WebTable04 extends TestBase {

    //   devami icin : https://github.com/gokhanagar/Selenium/blob/master/jUnit/src/test/java/day13_cookies_webTables/WebtablesHW.java


    //  1. “https://demoqa.com/webtables” sayfasina gidin
    //  2. Tablodaki sutun basliklarini yazdirin
    //  3. Tablodaki department isimlerini yazdirin   ?????
    //  4. 3.sutunun basligini yazdirin
    //  5. Tablodaki tum datalari yazdirin
    //  6. Tabloda kac cell (data) oldugunu yazdirin
    //  7. Tablodaki satir sayisini yazdirin
    //  8. Tablodaki sutun sayisini yazdirin
    //  9. Tablodaki 3.kolonu yazdirin
    //  10. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
    // 11. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

    @Test
    public void test() {

        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");


        //  2. Tablodaki sutun basliklarini yazdirin
        List<WebElement> headList = driver.findElements(By.xpath("//div[@class='rt-tr']//div[@role='columnheader']"));

        for (WebElement each : headList) {
            System.out.println(each.getText());
        }

        System.out.println("------------------------------------------------------------------");


        //  3. Tablodaki department isimlerini yazdirin   ?????

        int departmentNo = 0;

        for (int i = 0; i < headList.size(); i++) {

            if (headList.get(i).getText().equals("Department")) {

                departmentNo = i;
            }
        }
        System.out.println(departmentNo);

        List<WebElement> departmentList = driver.findElements(By.xpath("(//div[@class='rt-table']//div[@class='rt-td'][" + (departmentNo + 1) + "])"));

        for (WebElement each : departmentList) {
            System.out.println(each.getText());
        }



        //  4. 3.sutunun basligini yazdirin
        System.out.println(headList.get(2).getText());


        //  5. Tablodaki tum datalari yazdirin
        WebElement table = driver.findElement(By.xpath("//div[@class='rt-table']"));
        System.out.println("All data in the table :" + table.getText());



        //  6. Tabloda kac cell (data) oldugunu yazdirin
        WebElement cellList = driver.findElement(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']//div[@class='rt-td']"));


        //  7. Tablodaki satir sayisini yazdirin
        WebElement rowList = driver.findElement(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("the number of row : " + rowList.getSize());

        //  8. Tablodaki sutun sayisini yazdirin


        //  9. Tablodaki 3.kolonu yazdirin


        //  10. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin


        // 11. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin





    }
}