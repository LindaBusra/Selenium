package SeleniumProject;



import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;

import static utilities.TestBase.waitFor;

public class EBizCharge  {



    Faker faker = new Faker();
    WebDriver driver;


    @Before
    public void setUp(){


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));      //IMPLICIT WAIT :15 second wait  in case needed  //until the page come up, wait.
        driver.manage().window().maximize();

        //Go to  https://ebizcharge.com/
        driver.get("https://ebizcharge.com/");


    }


    @Test
    public void test() {



        //Click "Get a Demo"
        driver.findElement(By.xpath("(//*[.='Integrations'])[2]")).click();
        waitFor(2);
        System.out.println("1");

        //Enter
        Actions actions=new Actions(driver);
        String fullname_str =faker.name().fullName();
        WebElement fullname = driver.findElement(By.id("659723_68173pi_659723_68173"));
        actions.
                click(fullname).
                sendKeys(fullname_str).
                sendKeys(Keys.TAB).
                sendKeys(fullname_str+"@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys(faker.company().name()).
                sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().cellPhone()).
                sendKeys(Keys.TAB).
                sendKeys(faker.company().url()).
                sendKeys(Keys.TAB).
                sendKeys(faker.company().url()).build().perform();

        WebElement dropdown1 = driver.findElement(By.id("659723_68188pi_659723_68188"));
        Select options1 = new Select(dropdown1);

        options1.selectByVisibleText("Able Commerce");

        WebElement dropdown2 = driver.findElement(By.id("659723_68197pi_659723_68197"));
        Select options2 = new Select(dropdown2);

        options2.selectByIndex(1);



        driver.findElement(By.id("659723_68194pi_659723_68194_1057258")).click();



    }
    }

