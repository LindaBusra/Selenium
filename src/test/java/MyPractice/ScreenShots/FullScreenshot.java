package MyPractice.ScreenShots;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class FullScreenshot {

/*
    Capture screenshot using getScreenshotAs() method of Webdriver
    Set Output type of screenshot as 'FILE'

    File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

    Use FileUtils class of Java
    Call it's copyFile method
    Copy screenshot file to a location with some name and extension you want

    FileUtils.copyFile(screenshot, new File("D:\\screenshot.jpg"));           */

    @Test
    public void test() throws IOException {

        // Initialize Webdriver Object
         System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe")   ;
         WebDriver driver = new ChromeDriver();

        //Open url
        driver.get("https://www.techlistic.com/p/selenium-tutorials.html");

        // Set Chrome window size
        driver.manage().window().setSize(new Dimension(1552, 840));

        // Enter Firstname
        driver.findElement(By.name("firstname")).sendKeys("Tom");
        // Set Lastname
        driver.findElement(By.name("lastname")).sendKeys("Wood");

        // Create File object and save screenshot of current webpage inside it
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        // Copy screenshot file to a location with some name and extension you want
        FileUtils.copyFile(screenshot, new File("D:\\screenshot.jpg"));

        // Close browser
        driver.close();

        //Take Partial Screenshot with Selenium WebDriver:
        //https://www.techlistic.com/2016/06/how-to-take-partial-screenshot-in.html


    }


}
