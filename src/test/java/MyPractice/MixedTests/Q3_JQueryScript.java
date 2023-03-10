package MyPractice.MixedTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q3_JQueryScript {

    /*
    Question: // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
    //-->Task1 Find Dropdown on Multi Selection
    //-->Task2 Find  all Dropdown Elements on page
    //-->Task3 printout DropDown Elements' number
    //-->Task4 choose dropdown elements and printout dropdown elements' name  until choise 6
     */


    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

    }

    @Test
    public void test(){

        //-->Task1 Find Dropdown on Multi Selection
        // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

        //Find Dropdown on Multi Selection
        driver.findElement(By.id("justAnInputBox")).click();

        //Find  all Dropdown Elements on page
        List<WebElement> options = driver.findElements(By.xpath("//span[@class ='comboTreeItemTitle']"));

        //printout DropDown Elements' number
        System.out.println("Number of the dropdown options : " +  options.size());

        //choose dropdown elements and printout dropdown elements' name  until choise 6
        for(int i =0; i<options.size(); i++){
            System.out.println(options.get(i).getText());

            if(options.get(i).getText().equals("choice 6")){
                options.get(i).click();
                break;
            }
        }



    }
}
