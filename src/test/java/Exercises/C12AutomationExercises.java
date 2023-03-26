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


public class C12AutomationExercises {

    /*
    Test Case 12: Add Products in Cart
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'Products' button
    5. Hover over first product and click 'Add to cart'
    6. Click 'Continue Shopping' button
    7. Hover over second product and click 'Add to cart'
    8. Click 'View Cart' button
    9. Verify both products are added to Cart
    10. Verify their prices, quantity and total price
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


//    @After
//    public void tearDown(){
//        driver.close();
//    }


    @Test
    public void test() throws InterruptedException, AWTException {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");


        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.cssSelector("#slider-carousel"));       //"html"  or "//body"
        Assert.assertTrue(homePage.isDisplayed());
        System.out.println("HomePage test passed!");

        //4. Click 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        System.out.println("Products button is passed");


        //5. Hover over first product and click 'Add to cart'
        Robot robot = new Robot();
        robot.mouseWheel(5);
        driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
        System.out.println("Add to cart  is passed");

        //6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
        System.out.println("Continue Shopping is passed");

        //7. Hover over second product and click 'Add to cart'
        Robot robot1 = new Robot();
        robot1.mouseWheel(5);
        driver.findElement(By.xpath("//a[@data-product-id='2']")).click();
        System.out.println("click add yo cart passes");

        //8. Click 'View Cart' button
        driver.findElement(By.linkText("View Cart")).click();
        System.out.println("View card test passed");

        //9. Verify both products are added to Cart
        WebElement product1 = driver.findElement(By.id("product-1"));
        Assert.assertTrue(product1.isDisplayed());
        System.out.println("Product1 is passed");

        WebElement product2 = driver.findElement(By.id("product-2"));
        Assert.assertTrue(product2.isDisplayed());
        System.out.println("Product2 is passed");


        //10. Verify their prices, quantity and total price


        WebElement price1 = driver.findElement(By.xpath("(//*[@class='cart_price'])[1]"));
        Assert.assertTrue(price1.isDisplayed());
        System.out.println("price1");

        WebElement price2 = driver.findElement(By.xpath("(//*[@class='cart_price'])[2]"));
        Assert.assertTrue(price2.isDisplayed());
        System.out.println("price2");

        WebElement quantity1 = driver.findElement(By.xpath("(//*[@class='disabled'])[1]"));
        Assert.assertTrue(quantity1.isDisplayed());
        System.out.println("quantity1");

        WebElement quantity2 = driver.findElement(By.xpath("(//*[@class='disabled'])[2]"));
        Assert.assertTrue(quantity2.isDisplayed());
        System.out.println("quantity2");

        WebElement total1 = driver.findElement(By.xpath("(//*[@class='cart_total_price'])[1]"));
        Assert.assertTrue(total1.isDisplayed());
        System.out.println("total1");

        WebElement total2 = driver.findElement(By.xpath("(//*[@class='cart_total_price'])[2]"));
        Assert.assertTrue(total2.isDisplayed());
        System.out.println("total2");

    }
}
