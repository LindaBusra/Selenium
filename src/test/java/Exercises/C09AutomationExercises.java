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

import java.time.Duration;
import java.util.List;


public class C09AutomationExercises {

    /*
    Test Case 9: Search Product
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Products' button
    5. Verify user is navigated to ALL PRODUCTS page successfully
    6. Enter product name in search input and click search button
    7. Verify 'SEARCHED PRODUCTS' is visible
    8. Verify all the products related to search are visible
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

        Assert.assertTrue(homePage.isDisplayed());

        System.out.println("HomePage test passed!");



        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        System.out.println("go to products page");


        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("//h2[@class='title text-center']"));

        Assert.assertTrue(allProducts.isDisplayed());
        System.out.println("All Products page test passed!");


        //6. Enter product name in search input and click search button

        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Dress");
        System.out.println("dres button works");
        driver.findElement(By.id("submit_search")).click();
        System.out.println("submit button works");

        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchProduct = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(searchProduct.isDisplayed());
        System.out.println("SEARCHED PRODUCTS is visible");


        //8. Verify all the products related to search are visible

        driver.navigate().back();
        List<WebElement> allProductsList = driver.findElements(By.xpath("//*[@class='productinfo text-center']"));
        for (WebElement w:allProductsList) {
            Assert.assertTrue(w.isDisplayed());
        }
        //allProductsList.stream().forEach(WebElement::isDisplayed);
    }
}
