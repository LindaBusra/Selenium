package Tests;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class Day08_Actions3 extends TestBase {

    /*
Create a class: ActionClass3
Create test method : scrollUpDown()
Go to techproeducation
Scroll the page down
Scroll the page up
     */

    @Test
    public void scrollUpDown() throws InterruptedException {

        driver.get("htpps://www.techproeducation.com");

        Actions actions = new Actions(driver);

        //sendKeys(Keys.PAGE_DOWN) is used to scroll the page down
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);

        //Chain method, scrolling 3 times
        //.build() is recommended to be used when we chain multiple commends to make sure the connection is strong.
        //.perform is used when there is single or multiple comments to execute the action.

        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);

        //ARROW_DOWN = scroll down a little bit. This scrolls less then page down
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(3000);
        
        //PAGE_UP = scroll up
        actions.sendKeys(Keys.PAGE_UP).perform();

        //ARROW_UP = scroll up  alittle bit, This scrolls less then page up.
        actions.sendKeys(Keys.ARROW_UP).perform();


    }
}


/*
        Robot robot = new Robot();
        robot.mouseWheel(10);
 */