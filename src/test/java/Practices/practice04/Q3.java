package Practices.practice04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class Q3 extends TestBase {

    /*
    Given
        Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    When
        Click all the buttons
    Then
        Assert all buttons clicked
     */

    @Test
    public void test(){

        //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        Actions actions = new Actions(driver);


        //Click all the buttons
        WebElement onBlur = driver.findElement(By.id("onblur"));  //if you click another plass then will be click. it does not work with click on.
        waitFor(2);
        //I will going to click next one.
        WebElement onClick = driver.findElement(By.id("onclick"));   //This is for clicking on "Onblur" button.

        WebElement onContextMenu = driver.findElement(By.id("oncontextmenu")); //This is for clicking on "OnContexMenu" button.

        WebElement onDoubleClick = driver.findElement(By.id("ondoubleclick"));  //This is for clicking on "OnDoubleClick" button.
        WebElement onFocus = driver.findElement(By.id("onfocus"));            //This is for clicking on "OnFocus" button.
        WebElement onKeyDown = driver.findElement(By.id("onkeydown"));        // I will first click on it then press any button (like enter)
        WebElement onKeyUp = driver.findElement(By.id("onkeyup"));
        WebElement onKeyPress = driver.findElement(By.id("onkeypress"));
        WebElement onMouseOver = driver.findElement(By.id("onmouseover"));
        WebElement onMouseLeave = driver.findElement(By.id("onmouseleave"));
        WebElement onMouseDown = driver.findElement(By.id("onmousedown"));


        actions
                .click(onBlur)
                .click(onClick)
                .click(onClick)                           //This is for clicking on "Onclick" button.
                .contextClick(onContextMenu)               //or for every one actions.contextClick(contextClickButton).perform();
                .doubleClick(onDoubleClick)
                .click(onFocus)
                .click(onKeyDown).sendKeys(Keys.ENTER)        //any keywords works here
                .click(onKeyUp).sendKeys(Keys.ENTER)
                .click(onKeyPress).sendKeys(Keys.ENTER)
                .moveToElement(onMouseOver)
                .moveToElement(onMouseLeave)
                .click(onMouseDown)       //This one did not work because of previous leave action
                .click(onMouseDown)
                .build()            //if it is chain actions
                .perform();


        //Assert all buttons clicked
        List<WebElement> evenTriggeredList = driver.findElements(By.xpath("//p[.='Event Triggered']"));
        int length = evenTriggeredList.size();
        Assert.assertTrue(11==length);



    }
}
