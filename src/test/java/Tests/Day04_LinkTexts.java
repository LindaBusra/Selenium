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
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Day04_LinkTexts {


    WebDriver driver;

    @Before
    public void  setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver= new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    //linkText and partialLinkText are case sensitive. If a text is huge, we can use partialLink.
    @Test
    public void LMSPage(){

        driver.get("https://techproeducation.com/");

        //Click on LMS login
        //LMS LOGIN is a link, text of that link is "LMS LOGIN"
        driver.findElement(By.linkText("LMS LOGIN")).click();

        //Verify LMS page is visible
        String expectedUrl = "https://lms.techproeducation.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("LMS LOGIN page is not displayed",  expectedUrl, actualUrl);        //
        //message will only be visible if assertion fails.
    }




    @Test
    public void LMSPagePartialLinkTest(){

        driver.get("https://techproeducation.com/");
        driver.findElement(By.partialLinkText("LMS L")).click();

        //Alternatively we can locate a core element on LMS page and check if that element is displayed in the page
        WebElement login = driver.findElement(By.linkText("Login/Register"));
        Assert.assertTrue(login.isDisplayed());     //isDisplayed() returns True is element is on the page. Returns false if elements is not displayed on the page.

//      Assert.assertTrue(driver.findElement(By.linkText("Login/Register")).isDisplayed());  // too long

    }


    @After
    public void tearDown(){
      driver.quit();
    }







}
