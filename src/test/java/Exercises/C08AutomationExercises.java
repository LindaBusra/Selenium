package Exercises;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.time.Duration;


public class C08AutomationExercises {

    /*
    Test Case 8: Verify All Products and product detail page
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Products' button
    5. Verify user is navigated to ALL PRODUCTS page successfully
    6. The products list is visible
    7. Click on 'View Product' of first product
    8. User is landed to product detail page
    9. Verify that detail is visible: product name, category, price, availability, condition, brand
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


//    @After
//    public void tearDown(){
//        driver.close();
//    }


    @Test
    public void test() throws InterruptedException, AWTException {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");


        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.cssSelector("#slider-carousel"));

        Assert.assertTrue(homePage.isDisplayed());

        System.out.println("HomePage test passed!");

        //or
        String expectedUrl="https://automationexercise.com/";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);



        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click(); //or (By.xpath("//*[text()=' Products']"))
        System.out.println("go to products page");


        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("//h2[@class='title text-center']"));

        Assert.assertTrue(allProducts.isDisplayed());
        System.out.println("All Products page test passed!");




        //6. The products list is visible
        WebElement productsList = driver.findElement(By.xpath("//div[@class='features_items']"));   //or (By.xpath("//*[text()='View Product']")
        Assert.assertTrue(productsList.isDisplayed());
        System.out.println("The products list is visible test passed!");



        //7. Click on 'View Product' of first product
        Robot robot1 = new Robot();
        robot1.mouseWheel(5);
        driver.findElement(By.xpath("//*[text()='View Product']")).click();
        //or
//        driver.findElement(By.xpath("(//*[text()='View Product'])[1]")).click();
        System.out.println("it is passed");



        //8. User is landed to product detail page
        WebElement productDetail = driver.findElement(By.xpath("//div[@class='product-information']"));     //or By.xpath("(//h2)[3]")
        Assert.assertTrue(productDetail.isDisplayed());
        System.out.println("Product detail page test passed!");


        //9. Verify that detail is visible: product name, category, price, availability, condition, brand
        WebElement productName = driver.findElement(By.xpath("//*[text()='Blue Top']"));
        Assert.assertTrue(productName.isDisplayed());

        WebElement category = driver.findElement(By.xpath("//h2[normalize-space()='Category']"));
        Assert.assertTrue(category.isDisplayed());

        WebElement price = driver.findElement(By.xpath("//span[normalize-space()='Rs. 500']"));
        Assert.assertTrue(price.isDisplayed());

        WebElement availability = driver.findElement(By.xpath("//b[normalize-space()='Availability:']")); //
        Assert.assertTrue(availability.isDisplayed());

        WebElement condition = driver.findElement(By.xpath("//b[normalize-space()='Condition:']")); //
        Assert.assertTrue(condition.isDisplayed());

        WebElement brand = driver.findElement(By.xpath("//b[normalize-space()='Brand:']"));
        Assert.assertTrue(brand.isDisplayed());


        System.out.println("User is landed to product detail page tests passed");
    }
}
