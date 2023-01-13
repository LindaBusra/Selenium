package Practices.practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Q05_divide {

    /*
    Practice 4...
// Create chrome driver by using @Before annotation and WebDriverManager
// Navigate to  https://testpages.herokuapp.com/styled/index.html
// Click on  Calculator under Micro Apps
// Type any number in the first input
// Type any number in the second input
// Click on Calculate
// Get the result
// Verify the result
// Print the result
// Close the browser by using @After annotation
     */


    WebDriver driver;

    @Before
    public void setUp(){

        // Create chrome driver by using @Before annotation and WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void test() {

        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();


        //select "divide" operation
        WebElement dropdown = driver.findElement(By.id("function"));

        new Select(dropdown).selectByValue("divide");       //Select select = new Select(dropdown);   select.selectByValue("divide");



        // Type any number in the first input
        // Type any number in the second input
        driver.findElement(By.id("number1")).sendKeys("140");
        driver.findElement(By.id("number2")).sendKeys("70");

        // Click on Calculate
        driver.findElement(By.id("calculate")).click();

        // Get the result
        WebElement result = driver.findElement(By.id("answer"));

        String actualResult = result.getText();

        // Verify the result
        Assert.assertEquals("2", actualResult);

        // Print the result
        System.out.println(result.getText());


    }

    @After
    public void tearDown(){

        // Close the browser by using @After annotation
        driver.close();
    }
}



