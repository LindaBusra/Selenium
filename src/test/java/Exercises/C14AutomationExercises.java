package Exercises;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.awt.*;
import java.time.Duration;

public class C14AutomationExercises extends TestBase {
    /*
Test Case 14: Place Order: Register while Checkout
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click Proceed To Checkout
8. Click 'Register / Login' button
9. Fill all details in Signup and create account
10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
11. Verify ' Logged in as username' at top
12.Click 'Cart' button
13. Click 'Proceed To Checkout' button
14. Verify Address Details and Review Your Order
15. Enter description in comment text area and click 'Place Order'
16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
17. Click 'Pay and Confirm Order' button
18. Verify success message 'Congratulations! Your order has been confirmed!'
19. Click 'Delete Account' button
20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */


    @Test
    public void test01() throws AWTException {



        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//*[text()='Full-Fledged practice website for Automation Engineers']"));
        Assert.assertTrue(homePage.isDisplayed());
        System.out.println("Home page displayed test passed");


        //4. Add products to cart
        Robot robot1 = new Robot();
        robot1.mouseWheel(10);
        driver.findElement(By.xpath("//a[@data-product-id='2']")).click();
        driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();        //for continue
        driver.findElement(By.xpath("//a[@data-product-id='3']")).click();
        System.out.println("products are added");

        //5. Click 'Cart' button
        driver.findElement(By.linkText("View Cart")).click();
        System.out.println("Click cart button is passed");


        //6. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//*[text()='Proceed To Checkout']"));
        Assert.assertTrue(cartPage.isDisplayed());
        System.out.println("verifying is passed");


        driver.findElement(By.linkText("Proceed To Checkout")).click();

        //8. Click 'Register / Login' button
        driver.findElement(By.linkText("Register / Login")).click();
        System.out.println("register/login passed");

        Faker faker = new Faker();

        //9. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //gender
        driver.findElement(By.id("id_gender2")).click();

        //username
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys(faker.name().firstName());

        //password
        driver.findElement(By.id("password")).sendKeys(faker.internet().password());

        //day
        WebElement day = driver.findElement(By.id("days"));
        day.click();
        day.sendKeys("01");


        //month
        WebElement month = driver.findElement(By.id("months"));
        month.click();
        month.sendKeys("01");


        //days
        WebElement year = driver.findElement(By.id("years"));
        year.click();
        year.sendKeys("01");

        // Select checkbox 'Sign up for our newsletter
        driver.findElement(By.id("newsletter")).click();
        //Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();


        //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.id("first_name")).sendKeys("zehra");
        driver.findElement(By.id("last_name")).sendKeys("yilmaz");
        driver.findElement(By.id("company")).sendKeys("SVV");
        driver.findElement(By.id("address1")).sendKeys("Oslo");
        driver.findElement(By.id("address2")).sendKeys("Rogaland");


        //Fill details: Country, State, City, Zipcode, Mobile Number
        WebElement country = driver.findElement(By.id("country"));
        country.click();
        country.sendKeys("Canada");

        driver.findElement(By.id("state")).sendKeys("Oslo");
        driver.findElement(By.id("city")).sendKeys("Oslo");
        driver.findElement(By.id("zipcode")).sendKeys("5566");
        driver.findElement(By.id("mobile_number")).sendKeys("22334455");
        System.out.println("buraya kadar yazildi");

        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();



        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement accountCreated = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());
        System.out.println("Account created test passed");

//        driver.findElement(By.className("ns-r1iut-e-16")).click();        //for Alert

            driver.findElement(By.linkText("Continue")).click();        //Continue




            // 11. Verify ' Logged in as username' at top
            WebElement loggedAs = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
            Assert.assertTrue(loggedAs.isDisplayed());
            System.out.println("Verify Logged in as username at top");


            //12.Click 'Cart' button
            driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
            System.out.println("click cart button test passed");


            //13. Click 'Proceed To Checkout' button
            driver.findElement(By.linkText("Proceed To Checkout")).click();
            System.out.println("Proceed To Checkout test passed");


            //14. Verify Address Details and Review Your Order
            WebElement adressDetails = driver.findElement(By.xpath("//*[text()='Address Details']"));
            Assert.assertTrue(adressDetails.isDisplayed());

            WebElement reviewOrder = driver.findElement(By.xpath("//*[text()='Review Your Order']"));
            Assert.assertTrue(reviewOrder.isDisplayed());

            //15. Enter description in comment text area and click 'Place Order'
            Robot robot = new Robot();
            robot.mouseWheel(5);
            driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("aabbababab");
            driver.findElement(By.linkText("Place Order")).click();

            //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
            driver.findElement(By.xpath("//input[@data-qa='name-on-card']")).sendKeys("Zehra Yilmaz");
            driver.findElement(By.xpath("//input[@data-qa='card-number']")).sendKeys("444555111222666");
            driver.findElement(By.xpath("//input[@data-qa='cvc']")).sendKeys("666");
            driver.findElement(By.xpath("//input[@data-qa='expiry-month']")).sendKeys("03");
            driver.findElement(By.xpath("//input[@data-qa='expiry-year']")).sendKeys("1888");


            //17. Click 'Pay and Confirm Order' button
            driver.findElement(By.xpath("//button[@data-qa='pay-button']")).click();

            //18. Verify success message 'Congratulations! Your order has been confirmed!'
            WebElement succsess = driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']"));
            Assert.assertTrue(succsess.isDisplayed());
            System.out.println("Congratulations! test passed");

            //19. Click 'Delete Account' button
           driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
            System.out.println("Delete account test passed");


            //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
            WebElement accountDeleted = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
            Assert.assertTrue(accountDeleted.isDisplayed());

            driver.findElement(By.linkText("Continue")).click();

        driver.close();
        }



    }

