package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Day14_ExplicitWait extends TestBase {

    /*
    Create a class:ExplicitWait
    Create a method: explicitWait
    Go to https://the-internet.herokuapp.com/dynamic_loading/1
    When user clicks on the Start button
    Then verify the ‘Hello World!’ Shows up on the screen

    style=display:none-->element is not visible. it is hidden.  when element is visible it is just style
    style= display:block
     */

    @Test
    public void explicitWait() throws InterruptedException {

        // Create a class:ExplicitWait
        // Create a method: explicitWait
        // Go to https://the-internet.herokuapp.com/dynamic_loading/1

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // When user clicks on the Start button
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        // Then verify the ‘Hello World!’ Shows up on the screen


        //This piece of code fails cause implicit wait is not able to to handle the wait time
        //Solution  : Try Explicit wait or fluent wait
        //with implicit wait:
//        WebElement helloElement = driver.findElement(By.xpath("//div[@id='finish']//h4"));
//        Assert.assertEquals("Hello World!",helloElement.getText());

        // 1.Create webdriver wait object.   Using explicit wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));  //this is Selenium wait

        //2.Use wait object to handle syncronization issue (wait issue)
        //waits for the xpath to be visible UP TP 10 seconds
        //returns the web element
        //it the element is not found within 10 seconds, the throw time out exception.
        WebElement helloWord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        Assert.assertEquals("Hello World!",helloWord.getText());

    }

    @Test
    public void explicitWaitReusable(){

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
        WebElement helloElement = waitForClickability(By.xpath("//div[@id='finish']//h4"), 10);    //(locator, time)

        Assert.assertEquals("Hello World!", helloElement.getText());
    }
}