package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.awt.*;

public class C15AutomationExercises extends TestBase {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'Signup / Login' button
    5. Fill all details in Signup and create account
    6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
    7. Verify ' Logged in as username' at top
    8. Add products to cart
    9. Click 'Cart' button
    10. Verify that cart page is displayed
    11. Click Proceed To Checkout
    12. Verify Address Details and Review Your Order
    13. Enter description in comment text area and click 'Place Order'
    14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
    15. Click 'Pay and Confirm Order' button
    16. Verify success message 'Your order has been placed successfully!'
    17. Click 'Delete Account' button
    18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */

    @Test
    public void test() throws AWTException {


        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        Assert.assertTrue(logo.isDisplayed());
        System.out.println("1");

        //4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        System.out.println("2");

        //5. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("ali");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("aliveli@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        System.out.println("3");


        Actions actions = new Actions(driver);
        WebElement gender =driver.findElement(By.id("id_gender2"));
        actions.click(gender)
                .sendKeys(Keys.TAB)
                .sendKeys("Emily")
                .sendKeys(Keys.TAB)
                .sendKeys("Emily1234")
                .sendKeys(Keys.TAB).sendKeys("4")
                .sendKeys(Keys.TAB).sendKeys("April")
                .sendKeys(Keys.TAB).sendKeys("2015").build().perform();


        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        Robot robot = new Robot();
        robot.mouseWheel(10);

        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("Emily");
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("Emily Saly");
        driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("EBB");
        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("Haraldsgata 2A");
        driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("Karmsund");
        driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("Karmsund");

        WebElement country = driver.findElement(By.id("country"));
        Select select = new Select(country);
        select.selectByValue("Canada");

        WebElement state = driver.findElement(By.xpath("//input[@data-qa='state']"));
        actions.click(state)

                .sendKeys("Hamar")
                .sendKeys(Keys.TAB)
                .sendKeys("Haugesund")
                .sendKeys(Keys.TAB)
                .sendKeys("5531")
                .sendKeys(Keys.TAB)
                .sendKeys("48576921")
                .build().perform();

        driver.findElement(By.xpath("//button[@data-qa='create-account']")).submit();

        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement accountCreated = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());
        System.out.println("4");
        driver.findElement(By.xpath("//span[text()='Close']")).click();

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();    //popUp


        System.out.println("5");


        //7. Verify ' Logged in as username' at top

        //8. Add products to cart
        //9. Click 'Cart' button
        //10. Verify that cart page is displayed
        //11. Click Proceed To Checkout
        //12. Verify Address Details and Review Your Order
        //13. Enter description in comment text area and click 'Place Order'
        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //15. Click 'Pay and Confirm Order' button
        //16. Verify success message 'Your order has been placed successfully!'
        //17. Click 'Delete Account' button
        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button


        //https://github.com/erlevren/SeleniumAutomationExercises/blob/master/src/test/java/AutomationExercises/C15AutomationExercises.java
    }


}
