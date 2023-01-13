package Tests.Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class H7 extends TestBase {

    /*
    Create a class:Synchronization4. Create a method: isEnabled
    Go to https://the-internet.herokuapp.com/dynamic_controls
    Click enable Button
    And verify the message is equal to “It's enabled!”
    And verify the textbox is enabled (I can type in the box)
    And click on Disable button
    And verify the message is equal to “It's disabled!”
    And verify the textbox is disabled (I cannot type in the box)
    NOTE: .isEnabled(); is used to check if an element is enabled or not
     */


    @Test
    public void Synchronization4(){

        //Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Click enable Button
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        //And verify the message is equal to “It's enabled!”
        WebElement itsEnabledText = driver.findElement(By.id("message"));
        waitForVisibility(itsEnabledText,15);

        Assert.assertTrue(itsEnabledText.isDisplayed());

        //And verify the textbox is enabled (I can type in the box)
        WebElement textBox = driver.findElement(By.xpath("//form[@id='input-example']//input"));
        Assert.assertTrue(textBox.isEnabled());


        //And click on Disable button
        driver.findElement(By.xpath("//form[@id='input-example']//button")).click();

        //And verify the message is equal to “It's disabled!”
        WebElement itsDisabledText = driver.findElement(By.id("message"));
        waitForVisibility(itsDisabledText,15);
        Assert.assertTrue(itsDisabledText.isDisplayed());


        //And verify the textbox is disabled (I cannot type in the box)
        WebElement textBox1 = driver.findElement(By.xpath("//form[@id='input-example']//input"));
        Assert.assertFalse(textBox1.isEnabled());
    }



    @Test
    public void test4(){
//        EXPLICIT WAIT MUST BE USER IMPLICIT WAIT CANNOT HANDLE CAUSE OF THE
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //    Click enable Button
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();


//        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='text']")).isEnabled()); //FAILS SO EXPLICIT MUST BE USED
        //    And verify the message is equal to “It's enabled!”
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement enabledMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        String enabledMessageText=enabledMessage.getText();
        Assert.assertEquals(enabledMessageText,"It's enabled!");

        //    And verify the textbox is enabled (I can type in the box)
        WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(textBox.isEnabled());//isEnables checks if an element is enable. Returns true if enabled, returns false if disabled.

//        click on disable button
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        Assert.assertTrue(!driver.findElement(By.xpath("//input[@type='text']")).isDisplayed());


    }

}
