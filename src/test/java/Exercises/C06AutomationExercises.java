package Exercises;


import com.github.javafaker.Faker;
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


public class C06AutomationExercises {

        /*
    Test Case 6: Contact Us Form
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Contact Us' button
    5. Verify 'GET IN TOUCH' is visible
    6. Enter name, email, subject and message
    7. Upload file
    8. Click 'Submit' button
    9. Click OK button
    10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    11. Click 'Home' button and verify that landed to home page successfully
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


        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();
        System.out.println("go to contact us");


        //5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch = driver.findElement(By.xpath("//h2[normalize-space()='Get In Touch']"));

        if(getInTouch.isDisplayed()) {
            System.out.println("Get In Touch test passed!");
        } else {
            System.out.println("Get In Touch test failed!");
        }


        //6. Enter name, email, subject and message

        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@data-qa='email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//input[@data-qa='subject']")).sendKeys("to registration");
        driver.findElement(By.id("message")).sendKeys("We really appreciate your response to our website.");

        // 7. Upload file
        driver.findElement(By.xpath("//input[@name='upload_file']")).sendKeys("C:\\Users\\busra\\Downloads\\java resources\\SeleniumCheetSheet.pdf");
        System.out.println("7 pass");

        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@data-qa='submit-button']")).sendKeys("We really appreciate your response to our website.");
        System.out.println("8 pass");


        //9. Click OK button
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_ENTER);


        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement successMessage = driver.findElement(By.xpath("//div[normalize-space()='Success! Your details have been submitted successfully.']"));

        //Assert.assertTrue(successMessage.isDisplayed());        //or verify with this

        if(successMessage.isDisplayed()) {
            System.out.println("Success message is passed!");
        } else {
            System.out.println("Success message is failed!");
        }


        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//span[normalize-space()='Home']")).click();

        WebElement homePage2 = driver.findElement(By.xpath("//body"));

        if(homePage2.isDisplayed()) {
            System.out.println("HomePage test passed!");
        } else {
            System.out.println("HomePage test failed!");
        }





    }

















}
