package Tests.Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class H5 extends TestBase {

    /*
    Create a class:Synchronization2.
    Create a method: synchronization2
    Go to https://the-internet.herokuapp.com/dynamic_loading/2
    When user clicks on the Start button
    Then verify the ‘Hello World!’ Shows up on the screen

     */

    @Test
    public void synchronization2(){

        //Go to https://the-internet.herokuapp.com/dynamic_loading/2
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        // When user clicks on the Start button
        driver.findElement(By.xpath("//*[@id='start']/button")).click();

        //Then verify the ‘Hello World!’ Shows up on the screen
        WebElement helloWorldText = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        //use reusable method
        waitForVisibility(helloWorldText, 10);

        Assert.assertTrue(helloWorldText.isDisplayed());

        //All is good. We don't need to use explicit wait. //Implicit wait solved the issue
        //Cause the element is not hidden(No display:none on Hello World).
        //The entire element <h4>Hello World!</h4> just renders late
    }


}
