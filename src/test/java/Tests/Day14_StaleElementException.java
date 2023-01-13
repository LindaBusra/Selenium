package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
public class Day14_StaleElementException extends TestBase {

    /*
    Stale Element means the element is no longer fresh. It is old and no longer available
    When the element is no longer fresh on the page and you try to use it
    When the element is detached from the DOM
    When the element is removed after session started

    Solution:
    Relocate the same element again. You can use a new variable name as well.

 */


    @Test
    public void staleException(){
        driver.get("https://techproeducation.com/");

        //location lmsLogin
        WebElement lmsLogin = driver.findElement(By.linkText("LMS Login"));

        //clicking lmsLogin
        lmsLogin.click();
        waitFor(5);

        //going back to homepage
        driver.navigate().back();       //when you go back and forward the element is not no longer fresh
        waitFor(5);

        //Failed because lmsLogin is no longer fresh, it is old, it is STALE
        lmsLogin.click();

        //Solution: Relocate the element
        driver.findElement(By.linkText("LMS Login"));

    }



    @Test
    public void staleException1(){
        driver.get("https://techproeducation.com/");

        //location lmsLgin
        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));

        //clicking lmsLogin
        lmsLogin.click();
        waitFor(5);

        //going back to home page
        driver.navigate().back();
        waitFor(5);

        //clicking lmsLogin

        //FAILED cause lmsLogin is no longer fresh. It is OLD. It is STALE
        lmsLogin.click();       //org.openqa.selenium.StaleElementReferenceException:

        //SOLUTION : RELOCATE THE ELEMENT
        //driver.findElement(By.linkText("LMS LOGIN")).click();
    }
}