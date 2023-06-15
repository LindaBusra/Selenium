package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Day04_xpath_css {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver= new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }


@Test
    public void loginTest(){

        //locating username and typing username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        //locating password and typing password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        //locating login button and click
        driver.findElement(By.xpath("//button[@type='submit']")).click();
}



    @Test
    public void loginTestCss(){

        //locating username and typing username
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        //locating password and typing password
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        //locating login button and click
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }


    @After
    public void tearDown() {
        driver.quit();
    }

    /*
     * How many locators are there? 8
     * What are they?   id, name, className, linkText, tagName, partialLinkText, xpath, css
     * Which one do you prefer? Why?
            First if there is an ID, I use id, because id is unique and faster, (it has no navigation like xpath)
            then if there is no id I use name if there is a unique name.
            I also sometime create dynamic xpath. Because some elements do not have stable attributes
            like id and name. And I can write xpath for every element I want.
            * I sometimes even use css selector instead of xpath. But I personally use xpath more than css.

     * * What is difference between absolute xpath and relative xpath?
            -Absolute xpath: we start from the parent and go child elements one by one
            * Absolute xpath use /
            * Absolute xpath may easily be broken when a new element is added on the page
            * for that reason we should never use absolute xpath. In fact, my team don't let QA's use absolute xpath.

            -Relative xpath:we don't start from parent and go to child by one by. We go straight to the element.
            -Relative xpath use //
            -Relative xpath is very reliable. It does not easy brake, because relative xpath does not dependent on other element
            -I use relative xpath in my framework when I locate the elements.


     * What is the difference between xpath and css selector?
     -First xpath and css are similar. Both are helpful and there are different ways to create xpath or css.
     -Syntax is a little different.
     -In xpath we use // and @, but in css we dont.
     -css is a little faster than xpath (way less than 1 second). xpath does navigation in the html that takes a little bit time
     -there are more ways to write xpath. For example, dynamic xpath has contains, starts-with, ends-with functions.

     */

}
