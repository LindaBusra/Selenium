package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

public class Day14_NoSuchElementException extends TestBase {

/*
    /*

    NoSuchElementException:
    -Locator is wrong
    -Element is not on the page because of the iframe or pop up or new window
    -Loading issue-syntonization issue, implicit wait is not enough
    -Element is hidden

    Solution:
    -Make sure locator is correct. Double check the syntax
    -Do manual testing to make sure there is no iframe, popups, or any other blocked on the page
    -If locator is correct and if we used correct switch(iframe, new window,…) then apply wait. Maybe element is hidden or loading slower.
    -Sometimes Implicit wait may not be enough to handle specific issues. For example, when we test reservation functionality, after clicking save button, we had to put explicit wait to verify the success message
    on the popup window.
    -Try using explicit wait. It that doesn’t work, then try thread.sleep as a last resort

    //WAY1- Thread.sleep(1000) -->not recommended - lazy
    //WAY2- Explicit Wait - hardworking

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    WebElement popupMessageElement = wait.until(ExpectedConditions.visibilityOf(hotelRoomsPage.popupMessage));
    //Verify the message : HotelRoom was inserted successfully
    //Asserting message
    Assert.assertEquals(popupMessageElement.getText(), "HotelRoom was inserted successfully");


     */

    @Test
    public void noSuchElementExceptionTest(){
        driver.get("https://www.techproeducation.com/");
        //Wrong locator
        driver.findElement(By.id("wrong-id")); //Wrong locator.-->org.openqa.selenium.NoSuchElementException:
    }



    @Test
    public void noSuchElementExceptionTest2(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
        String helloWorld = driver.findElement(By.xpath("//div[@id='finish']//h4")).getText();
        Assert.assertEquals("Hello World!",helloWorld);//ComparisonFailure. This is not same as no such element exception
    }

    @Test
    public void noSuchElementExceptionTest3(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("(//button[@type='button'])")).click();
        String goneMessage = driver.findElement(By.xpath("//p[@id='message']")).getText();
        Assert.assertEquals("It's gone!",goneMessage);//NoSuchElementException. The element loads in about 5 second, but driver is so fast
//        SOLUTION:
//        Use explicit wait.
//        Use implicit wait
    }


}