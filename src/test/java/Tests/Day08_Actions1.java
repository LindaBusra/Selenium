package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day08_Actions1 extends TestBase {

    /*
Create a class: Actions1
Create a test method : contextClickMethod() and test the following scenario:
Given user is on the https://the-internet.herokuapp.com/context_menu
When use Right clicks on the box
Then verify the alert message is “You selected a context menu”
Then accept the alert
     */

    @Test
    public void contextClickMethod(){

        driver.get("https://the-internet.herokuapp.com/context_menu ");

        //When use Right clicks on the box
        //1-creating action object to do right click
        Actions actions=new Actions(driver);

        //2-locating  the element that I want to right click
        WebElement box = driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();              // choose ContextClick --> (Webelement, target)

        //Then verify the alert message is "You selected a context menu"
        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",actualAlertText);

        //Then accept the alert
        driver.switchTo().alert().accept();
    }
}
