package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.awt.*;

public class C17AutomationExercises extends TestBase {

    /*
    Test Case 17: Remove Products From Cart
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Add 3 products to cart
    5. Click 'Cart' button
    6. Verify that cart page is displayed
    7. Click 'X' button corresponding to particular products
    8. Verify that product is removed from the cart
     */

    @Test
    public void test1() throws InterruptedException, AWTException {


        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Add 3 products to cart
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'][1])")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        System.out.println("1");

        Robot robot = new Robot();
        robot.mouseWheel(10);

        driver.findElement(By.xpath("(//a[@data-product-id='4'])")).click();
        System.out.println("2");
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        System.out.println("3");

        driver.findElement(By.xpath("(//a[@data-product-id='5'])")).click();
        System.out.println("4");
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        System.out.println("5");

        //5. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
        System.out.println("6");

        //6. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//li[@class='active']"));
        Assert.assertTrue(cartPage.isDisplayed());
        System.out.println("7");

        //7. Click 'X' button corresponding to particular products
        driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
        driver.findElement(By.xpath("//a[@data-product-id='4']")).click();
        driver.findElement(By.xpath("//a[@data-product-id='5']")).click();
        System.out.println("8");

        //8. Verify that product is removed from the cart
        Thread.sleep(2000);
        WebElement verifyRemove = driver.findElement(By.xpath("//b[normalize-space()='Cart is empty!']"));
        Assert.assertTrue(verifyRemove.isDisplayed());
        System.out.println("9");
    }
}