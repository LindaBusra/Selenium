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


public class C07AutomationExercises {

        /*
    Test Case 7: Verify Test Cases Page
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Test Cases' button
    5. Verify user is navigated to test cases page successfully
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
    public void test() throws InterruptedException {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");


        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.cssSelector("#slider-carousel"));

        if(homePage.isDisplayed()) {
            System.out.println("HomePage test passed!");
        } else {
            System.out.println("HomePage test failed!");
        }


        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//a[@href='/test_cases']")).click();
        System.out.println("go to test cases");


        //5. Verify user is navigated to test cases page successfully
        WebElement testCases = driver.findElement(By.xpath("//h2[normalize-space()='Test Cases']"));

        if(testCases.isDisplayed()) {
            System.out.println("Test Cases test passed!");
        } else {
            System.out.println("Test Cases test failed!");
        }





    }
}
