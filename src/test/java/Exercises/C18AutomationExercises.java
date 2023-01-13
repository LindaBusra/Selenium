package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;

public class C18AutomationExercises extends TestBase {

/*
    Test Case 18: View Category Products
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that categories are visible on left side bar
    4. Click on 'Women' category
    5. Click on any category link under 'Women' category, for example: Dress
    6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
    7. On left side bar, click on any sub-category link of 'Men' category
    8. Verify that user is navigated to that category page
 */

    @Test
    public void test() throws AWTException {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that categories are visible on left side bar

        Robot robot = new Robot();
        robot.mouseWheel(5);
        WebElement category = driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(category.isDisplayed());

        //4. Click on 'Women' category
        driver.findElement(By.xpath("//a[@href='#Women']")).click();

        //5. Click on any category link under 'Women' category, for example: Dress
        driver.findElement(By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]")).click();

        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        WebElement category1 = driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(category1.isDisplayed());

        WebElement wdp = driver.findElement(By.xpath("//h2[text()='Women - Dress Products']"));
        Assert.assertTrue(wdp.isDisplayed());

        //7. On left side bar, click on any sub-category link of 'Men' category
        driver.findElement(By.xpath("//a[@href='#Men']")).click();
//        driver.findElement(By.xpath("//a[normalize-space()='Men']")).click();

        driver.findElement(By.xpath("//a[text()='Tshirts']")).click();
//        driver.findElement(By.xpath("//a[normalize-space()='Tshirts']")).click();

        //8. Verify that user is navigated to that category page
        WebElement category2 = driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(category2.isDisplayed());

    }


}
