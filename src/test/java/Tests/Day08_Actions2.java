package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.awt.*;

public class Day08_Actions2 extends TestBase {

    /*
    Create a class: Actions2
    Create test method : hoverOver() and test the following scenario:
    Given user is on the https://www.amazon.com/
    When use click on “Account” link
    Then verify the page title contains “Your Account”
     */

    //cooook tesekkur ederim...
   // cok sagolunnn


    @Test
    public void contextClickMethod(){

        //Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com");

        //When use click on “Account” link
        Actions actions = new Actions(driver);
        WebElement accountLists = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountLists).perform();

        //When use click on “Account” link
        driver.findElement(By.xpath("//*[text()='Account']")).click();

        //Then verify the page title contains “Your Account”
        Assert.assertTrue(driver.getTitle().contains("Your Account") );



    }
}
