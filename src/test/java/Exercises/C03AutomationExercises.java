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


public class C03AutomationExercises {

        /*
      Test Case 3: Login User with incorrect email and password
      1. Launch browser
      2. Navigate to url 'http://automationexercise.com'
      3. Verify that home page is visible successfully
      4. Click on 'Signup / Login' button
      5. Verify 'Login to your account' is visible
      6. Enter incorrect email address and password
      7. Click 'login' button
      8. Verify error 'Your email or password is incorrect!' is visible
     */




    WebDriver driver;

    @Before
    public void setUp(){

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
        WebElement homePage = driver.findElement(By.cssSelector("html"));

        if(homePage.isDisplayed()) {
            System.out.println("HomePage test passed!");
        } else {
            System.out.println("HomePage test failed!");
        }


        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();


        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccount = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']"));

        if(loginToYourAccount.isDisplayed()) {
            System.out.println("Login to your account test is passed!");
        } else {
            System.out.println("Login to your account test failed!");
        }



        //6. Enter incorrect email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("ada@gmail.com");

        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("ada123");


        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();


        //8. Verify that 'Logged in as username' is visible
        WebElement loggedInAs = driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']"));

        if(loggedInAs.isDisplayed()) {
            System.out.println("Your email or password is incorrect testing passed!");
        } else {
            System.out.println("Your email or password is incorrect testing failed!");
        }





    }

















}
