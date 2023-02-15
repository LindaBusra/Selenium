package Tests.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

import static org.bouncycastle.crypto.tls.ContentType.alert;

public class GoogleSearchTest {

    /*
Create a new class : GoogleSearchTest
Create main method and complete the following task.
When user goes to https://www.google.com/
Search for “porcelain teapot”
And print how many related results displayed on Google
     */


    WebDriver driver;

    @Before
    public void setUp(){

        // Create chrome driver by using @Before annotation and WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");

    }


    @Test
    public void Test() throws InterruptedException {


        driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();


        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("porcelain teapot", Keys.ENTER);

        System.out.println(driver.findElement(By.id("result-stats")).getText());



    }


    //Verify if google title is "Google"
    @Test
    public void titleTest()  {

        Assert.assertTrue(driver.getTitle().equals("Google"));
        System.out.println("titleTest passed");
    }


    //Verify if google image displays or not
    @Test
    public void imageTest()  {

        WebElement image = driver.findElement(By.className("lnXdpd"));

        Assert.assertTrue(image.isDisplayed());
        System.out.println("imageTest passed");
    }


    //Verify if the Gmail link is displayed or not
    @Test
    public void gmailLinkTest()  {


        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.google.com/";
        Assert.assertEquals(actualUrl, expectedUrl);
        System.out.println("gmailLinkTest passed");


    }

    @After
    public void tearDown(){

//        driver.close();
    }
}