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

public class Day05_dynamic_xpath {

    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }


    @Test
    public void loginTest(){

        //There are diffrent Xpath to locate a text element on a page
        //1. XPATH = //*[.='Text of the element']

//        Verify if "Username : Admin" is text is displayed on the page
//        //*[.='Username : Admin'] return the element whose text = Username : Admin
        WebElement usernameText = driver.findElement(By.xpath("//*[.='Username : Admin']"));        //or p[.='Username : Admin']
        Assert.assertTrue(usernameText.isDisplayed());

//        Verify if "Password : admin123" text is displayed on the page
        WebElement passwordText =driver.findElement(By.xpath("//*[.='Password : admin123']"));      //accepts full text
        Assert.assertTrue(passwordText.isDisplayed());

//        Verify if "Username : Admin" is text is displayed on the page
        //2. XPATH = //*[text()='Text of the element']
        WebElement usernameText1 = driver.findElement(By.xpath("//*[text()='Username : Admin']"));      //accepts full text
        Assert.assertTrue(usernameText1.isDisplayed());//Password : admin123


//        Verify if "Password" text is displayed on the page
//        3. XPATH = //*[contains(text(),'PARTIAL OR FULL TEXT OF THE ELEMENT')];
        WebElement passwordText1 = driver.findElement(By.xpath("//*[contains(text(),'Passw')]"));
        Assert.assertTrue(passwordText1.isDisplayed());



        driver.quit();

    }

















}
