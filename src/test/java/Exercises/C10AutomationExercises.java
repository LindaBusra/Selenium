package Exercises;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;


public class C10AutomationExercises {

    /*
    Test Case 9: Search Product
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Scroll down to footer
    5. Verify text 'SUBSCRIPTION'
    6. Enter email address in input and click arrow button
    7. Verify success message 'You have been successfully subscribed!' is visible
     */


    WebDriver driver;

    @Before
    public void setUp(){

        System.setProperty("webdriver.http.factory", "jdk-http-client");  //after updating i chrome I added it
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @After
    public void tearDown(){
        driver.close();
    }


    @Test
    public void test() throws InterruptedException, AWTException {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");


        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.cssSelector("#slider-carousel"));       //"html"
        Assert.assertTrue(homePage.isDisplayed());
        System.out.println("HomePage test passed!");

        //4. Scroll down to footer
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);


        //5. Verify text 'SUBSCRIPTION'
        WebElement subscription = driver.findElement(By.xpath("//h2[normalize-space()='Subscription']")) ;
        Assert.assertTrue(subscription.isDisplayed());

        //6. Enter email address in input and click arrow button
        driver.findElement(By.id("susbscribe_email")).sendKeys("ada@gmail.com");
        driver.findElement(By.id("subscribe")).click();

        //7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement success = driver.findElement(By.id(("success-subscribe")));
        Assert.assertTrue(success.isDisplayed());



    }
}
