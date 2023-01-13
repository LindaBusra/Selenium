package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day03_Checkbox {

    WebDriver driver;           //We declare it in the class level

    /*
Create a class : CheckBox
Create test method and complete the following task. 
Go to https://testcenter.techproeducation.com/index.php?page=checkboxes  
Locate the elements of checkboxes 
Then click on checkbox1 if box is not selected 
Then click on checkbox2 if box is not selected
 Then verify that checkbox1 is checked.

 */


    @Before
    public void setUp() {

        //https://testcenter.techproeducation.com/index.php?page=checkboxes
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));      //IMPLICIT WAIT :15 second wait  in case needed
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=checkboxes");

        //
    }


    @Test
    public void checkboxTest() {
        WebElement checkbox1 = driver.findElement(By.id("box1"));
        WebElement checkbox2 = driver.findElement(By.id("box2"));

        if(!checkbox1.isSelected()) {       //isSelected() is coming from Selenium, it returns true if checkbox is checked.
            checkbox1.click();              //it returns false if checkbox is not checked.
        }

        if(!checkbox2.isSelected()) {
            checkbox2.click();
        }

        //Then verify that checkbox1 is checked.
        Assert.assertTrue(checkbox1.isSelected());
    }



    @After
    public void tearDown(){     //you close what ever you open
        driver.quit();

    }
}