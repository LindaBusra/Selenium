package Practices.practice05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class Q2 extends TestBase {

    /*
        Given
            Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        When
            Click on Ajax Loader
        And
            Click on "Click Me!" button
        Then
            Assert that button is clicked
        And
            Take screenshot after each step
         */

    @Test
    public void test() throws IOException {


        //Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        takeScreenshotOfPage();

        //Click on Ajax Loader
        driver.findElement(By.xpath("//a[@href='../Ajax-Loader/index.html']")).click();
        takeScreenshotOfPage();

        //Click on "Click Me!" button
        waitForClickability(By.id("button1"), 6).click();
        takeScreenshotOfPage();

        //Assert that button is clicked
        String text = waitForVisibility(driver.findElement(By.xpath("//h4[text()='Well Done For Waiting....!!!']")), 3).getText();
        Assert.assertTrue(text.contains("Well Done"));
        takeScreenshotOfPage();

        //Take screenshot after each step


    }
}
