package Exercises;


import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class C04AutomationExercises {

        /*
      Test Case 4: Logout User
      1. Launch browser
      2. Navigate to url 'http://automationexercise.com'
      3. Verify that home page is visible successfully
      4. Click on 'Signup / Login' button
      5. Verify 'Login to your account' is visible
      6. Enter correct email address and password
      7. Click 'login' button
      8. Verify that 'Logged in as username' is visible
      9. Click 'Logout' button
      10. Verify that user is navigated to login page
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


        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccount = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']"));

        if(loginToYourAccount.isDisplayed()) {
            System.out.println("Login to your account test is passed!");
        } else {
            System.out.println("Login to your account test failed!");
        }



        //6. Enter correct email address and password           //First create an account  ada, ada@gmail.com, ada 123
        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(faker.internet().emailAddress());

        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys(faker.internet().password());


        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();


        //8. Verify that 'Logged in as username' is visible
        WebElement loggedInAs = driver.findElement(By.xpath("//i[@class='fa fa-user']"));

        if(loggedInAs.isDisplayed()) {
            System.out.println("Logged in as testing passed!");
        } else {
            System.out.println("Logged in as testing failed!");
        }

        //9. Click 'Logout' button
        driver.findElement(By.xpath("//a[@href='/logout']")).click();


        //10. Verify that user is navigated to login page
        WebElement loginToYourAccount2 = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']"));

        if(loginToYourAccount2.isDisplayed()) {
            System.out.println("Navigated to login page test is passed!");
        } else {
            System.out.println("Navigated to login page test is failed!");
        }



    }

















}
