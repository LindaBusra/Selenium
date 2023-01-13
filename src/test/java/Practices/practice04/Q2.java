package Practices.practice04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q2 extends TestBase {

    /*
        Given
            Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
        When
            Click on "click me" button
        Then
            Verify that "Event Triggered"
         */

    @Test
    public void test(){

        //Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");


        //Click on "click me" button
        waitFor(7);
        driver.findElement(By.xpath("//button[text()='Click Me']")).click();


        //Verify that "Event Triggered"
        String text = driver.findElement(By.id("growbuttonstatus")).getText();
        Assert.assertTrue(text.equals("Event Triggered"));

    }
}
