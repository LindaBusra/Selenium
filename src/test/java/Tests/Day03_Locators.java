package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Day03_Locators {
    /*
      User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
      Locate the elements of Username textbox, Password textbox, and Login button
      Enter below username and password then click on login button
              Username :  Admin
              Password :  admin123
      Verify the login is successful
      Sign out from the page
      */
    WebDriver driver;       //we initialize in class level


    @Before
    public void setUp(){


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));      //IMPLICIT WAIT :15 second wait  in case needed  //until the page come up, wait.
        driver.manage().window().maximize();

        //User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


    }


    @Test
    public void loginTest(){


        //Locate the elements of Username textbox, Password textbox, and Login button

        driver.findElement(By.name("username")).sendKeys("Admin");


//      driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
//      driver.findElement(By.className("oxd-input oxd-input--active")).sendKeys("Admin");
//      driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

        driver.findElement(By.name("password")).sendKeys("admin123");

//      driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

        driver.findElement(By.tagName("button")).click();
//      driver.findElement(By.xpath("//button[@type='submit']")).click();


        //Assert the login is successful
        WebElement verify = driver.findElement(By.xpath("//div[@class='oxd-layout-context']"));
        Assert.assertTrue(verify.isDisplayed());

        //or
        boolean actualValue = driver.getCurrentUrl().contains("dashboard");
        Assert.assertTrue(actualValue);

        //or
        WebElement myActions = driver.findElement(By.xpath("//*[.='My Actions']"));
        Assert.assertTrue(myActions.isDisplayed());

    }

@After
    public void tearDown(){



        driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();

        driver.findElement(By.linkText("Logout")).click();


        driver.quit();

}


}