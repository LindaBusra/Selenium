package Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
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

public class C13AutomationExercises {

    /*
    Test Case 13: Verify Product quantity in Cart
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'View Product' for any product on home page
5. Verify product detail is opened
6. Increase quantity to 4
7. Click 'Add to cart' button
8. Click 'View Cart' button
9. Verify that product is displayed in cart page with exact quantity
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

    @Test
    public void test() throws AWTException {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homeVisible = driver.findElement(By.xpath("//*[text()='Full-Fledged practice website for Automation Engineers']"));
        Assert.assertTrue(homeVisible.isDisplayed());
        System.out.println("home page is visible test passed");

        //4. Click 'View Product' for any product on home page
        Robot robot = new Robot();
        robot.mouseWheel(7);
        driver.findElement(By.linkText("View Product")).click();
        System.out.println("view product button test passed");

        //5. Verify product detail is opened
        WebElement brands = driver.findElement(By.xpath("//*[text()='Brands']"));
        Assert.assertTrue(brands.isDisplayed());
        System.out.println("Verify product detail is opened test passed");



        //6. Increase quantity to 4
        WebElement quantity = driver.findElement(By.xpath("//input[@name='quantity']"));
        quantity.clear();
        quantity.sendKeys("4");
        System.out.println("quantity is 4 now");  //

        //7. Click 'Add to cart' button
        WebElement addToCart = driver.findElement(By.xpath("//button[@class='btn btn-default cart']"));
        addToCart.click();
        System.out.println("Add to cart test passed");


        //8. Click 'View Cart' button   //View Cart
        WebElement viewCart = driver.findElement(By.xpath("//*[text()='View Cart']"));
        viewCart.click();
        System.out.println("Click View Cart button test passed ");


        //9. Verify that product is displayed in cart page with exact quantity
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);

        WebElement cart = driver.findElement(By.xpath("//button[@class='disabled']"));
        Assert.assertTrue(cart.getText().contains("4"));
        System.out.println("The quantity is 4 test passed");

    }

}
