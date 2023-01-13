package Practices.practice04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q1_saucedemo extends TestBase {

    /*
  Given
    Go to  https://www.saucedemo.com/
  When
    Enter the username  as "standard_user"
  And
    Enter the password as "secret_sauce"
  And
    Click on login button
  And
    Add al products to cart
  And
    Go to cart
  And
    Click on checkout
  And
    Fill your information
  And
    Click on continue
  Then
    Assert that total price is $140.34
  When
    Click on finish
  Then
    Assert that CHECKOUT: COMPLETE!
   */

    @Test
    public void test(){

        //Go to  https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

        //Enter the username  as "standard_user"
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Enter the password as "secret_sauce"
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click on login button
        driver.findElement(By.id("login-button")).click();

        //Add al products to cart
        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//div[@id='inventory_container']//button")); //or By.xpath("//button[.='Add to cart']")

        for(WebElement w: addToCartButtons) {
            w.click();
        }

        //Go to cart
        driver.findElement(By.id("shopping_cart_container")).click();

        //Click on checkout
        scrollAllDownByJS();
        waitFor(3);
        driver.findElement(By.id("checkout")).click();

        //Fill your information
        scrollAllUpByJS();
        waitFor(3);
        driver.findElement(By.id("first-name")).sendKeys("Emily");
        driver.findElement(By.id("last-name")).sendKeys("Nilsen");
        driver.findElement(By.id("postal-code")).sendKeys("5586");

        //Click on continue
        driver.findElement(By.id("continue")).click();

        //Assert that total price is $140.34
        scrollAllDownByJS();
        waitFor(3);
        String totalPrice = driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText();
        String actualText = totalPrice.substring(7);
        Assert.assertEquals(actualText,"$140.34");

        //or
//        String totalPrice = driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText();
//        assertEquals("Total: $140.34", totalPrice);

        //Click on finish
        driver.findElement(By.id("finish")).click();

        //Assert that CHECKOUT: COMPLETE!
        scrollAllUpByJS();
        WebElement text = driver.findElement(By.xpath("//span[text()='Checkout: Complete!']"));     // or  "//span[.='Checkout: Complete!']"
        Assert.assertTrue(text.isDisplayed());

    }
}
