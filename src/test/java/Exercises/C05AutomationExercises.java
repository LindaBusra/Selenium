package Exercises;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class C05AutomationExercises {

        /*
    Test Case 5: Register User with existing email
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and already registered email address
    7. Click 'Signup' button
    8. Verify error 'Email Address already exist!' is visible
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
    public void test(){

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");


        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.cssSelector("#slider-carousel"));

        if(homePage.isDisplayed()) {
            System.out.println("HomePage test passed!");
        } else {
            System.out.println("HomePage test failed!");
        }


        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();


        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignup = driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']"));

        if(newUserSignup.isDisplayed()) {
            System.out.println("New User Signup test is passed!");
        } else {
            System.out.println("New User Signup test failed!");
        }



        //6. Enter name and already registered email address
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("ada");

        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("ada@gmail.com");


        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();


        //8. Verify error 'Email Address already exist!' is visible
        WebElement loggedInAs = driver.findElement(By.xpath("//p[normalize-space()='Email Address already exist!']"));

        if(loggedInAs.isDisplayed()) {
            System.out.println("Email Address already exist! testing passed!");
        } else {
            System.out.println("Email Address already exist! testing failed!");
        }





    }

















}
