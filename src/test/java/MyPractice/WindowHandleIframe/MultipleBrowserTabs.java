package MyPractice.WindowHandleIframe;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class MultipleBrowserTabs   {

    /*

    Handle Multiple Browser Tabs with Selenium

    Open Google.com
    Then open a new tab by making use of Key class. By combination of CTRL + t key a new browser tab will be opened.
    Open Gmail.com in that tab.
    Perform some actions on Gmail sign in page.
    Switch back to google.com tab by pressing Ctrl + \t
    Now enter some keywords in google search box
    Close the browsers.
     */

    @Test
    public void test() throws InterruptedException {

    //Set driver path
    System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe")   ;

    //Initialize driver
    WebDriver driver = new ChromeDriver();

    //Maximize browser window
    driver.manage().window().maximize();

    //Go to url
    driver.get("http://www.google.com");

    //Set timeout
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    //Open new tab
    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

    //Go to url
    driver.get("http://www.gmail.com");

    //Set new tab timeout
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;

    //Do some operation
    driver.findElement(By.id("gmail-sign-in")).click();
    driver.findElement(By.id("Email")).sendKeys("WebDriver");
    driver.findElement(By.id("Passwd")).sendKeys("WebDriver");
    driver.findElement(By.id("signIn")).click();
    Thread.sleep(2000);

    //Switch first tab
    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
    driver.switchTo().defaultContent();
    Thread.sleep(2000);

    //Write search string
    driver.findElement(By.id("gbqfq")).sendKeys("WebDriver");

    // Click on Search button
    driver.findElement(By.id("gbqfb")).click();
    Thread.sleep(2000);

    // Browser close
    driver.close();





    }

}
