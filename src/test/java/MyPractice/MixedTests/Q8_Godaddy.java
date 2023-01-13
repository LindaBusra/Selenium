package MyPractice.MixedTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q8_Godaddy {

    /*1. Test Case - Open Godaddy.com and maximize browser window.
Steps to Automate:
1. Launch browser of your choice say., Firefox, chrome etc.
2. Open this URL - https://www.godaddy.com/
3. Maximize or set size of browser window.
4. Close browser.


2. Test Case - Open Godaddy.com and Print it's Page title.
Steps to Automate:
1. Launch browser of your choice say., Firefox, chrome etc.
2. Open this URL - https://www.godaddy.com/
3. Maximize or set size of browser window.
4. Get Title of page and print it.
4. Get URL of current page and print it.
5. Close browser.

Now is the time to automate a consolidated and final assignment.

3. Test Case - Open Godaddy.com and Validate Page Title
Steps to Automate:
1. Launch browser of your choice say., Firefox, chrome etc.
2. Open this URL - https://www.godaddy.com/
3. Maximize or set size of browser window.
4. Get Title of page and validate it with expected value.
5. Get URL of current page and validate it with expected value.
6. Get Page source of web page.
7. And Validate that page title is present in page source.
8. Close browser.                */


    @Test
    public void test1(){

        //1. Launch browser of your choice say., Firefox, chrome etc.
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Open this URL - https://www.godaddy.com/
        driver.get("https://www.godaddy.com/");

        //3. Maximize or set size of browser window.
        driver.manage().window().setSize(new Dimension(600,600));

        //4. Close browser.
        driver.close();
    }


    @Test
    public void test2(){

        //1. Launch browser of your choice say., Firefox, chrome etc.
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Open this URL - https://www.godaddy.com/
        driver.get("https://www.godaddy.com/");

        //3. Maximize or set size of browser window.
        driver.manage().window().setSize(new Dimension(600,600));

        //4. Get Title of page and print it.
        System.out.println(driver.getTitle());

        //5. Get URL of current page and print it.
        System.out.println(driver.getCurrentUrl());

        //6. Close browser.
        driver.close();
    }



    @Test
    public void test3(){

        //1. Launch browser of your choice say., Firefox, chrome etc.
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Open this URL - https://www.godaddy.com/
        driver.get("https://www.godaddy.com/");

        //3. Maximize or set size of browser window.
        driver.manage().window().setSize(new Dimension(600,600));

        //4. Get Title of page and validate it with expected value. -->verify title contains "GoDaddy"
        Assert.assertTrue(driver.getTitle().contains("GoDaddy"));

        //5. Get URL of current page and validate it with expected value. -->verify url contains "GoDaddy"
        Assert.assertTrue(driver.getCurrentUrl().equals("https://no.godaddy.com/"));

        //6. Get Page source of web page.
        System.out.println(driver.getPageSource());

        //7. And Validate that page title is present in page source.
        Assert.assertTrue(driver.getPageSource().contains("GoDaddy"));

        //6. Close browser.
        driver.close();
    }

}
