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

public class Day03_LocatorsIntro {

    WebDriver driver;           //We declare it in the class level

    /*

    Create a class : LocatorsIntro
    Create test method logInTest
    user goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    Locate the elements of email textbox, password textbox, and signin button
    Enter below username and password then click sign in button
    Username :  username
    Password : admin123

    Sign out from the page
     */



    @Before
    public void setUp(){

        //user goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));      //IMPLICIT WAIT :15 second wait  in case needed
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }


    @Test
    public void logInTest(){


//Locating the username and typing
        WebElement username = driver.findElement(By.name("username"));      //Location username by name
        username.sendKeys("Admin");     //typing Admin

//Locating the password and typing
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

//Locating the button and clicking
        WebElement button = driver.findElement(By.tagName("button"));       //or   driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

        //We do not need to use containers.
//        driver.findElement(By.tagName("username")).sendKeys("Admin");  //it is god for memory because we dont use variable. but is not reusable.
//        driver.findElement(By.name("password")).sendKeys("admin123");
//        driver.findElement(By.tagName("button")).click();

        //Verifying the log in successful
//        1. We can use default page URL to do assertion
//        2. Or we can locate a CORE ELEMENT on the default page to assert is that element is displayed on the page

//       Login url : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//       Default url :  https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

        Assert.assertEquals("Test FAILED", expectedUrl, actualUrl); //If login successful PASS, if not FAIL and print message LOGIN FAILED"


    }

    @After
    public void tearDown(){     //you close what ever you open
        driver.quit();

    }


}
