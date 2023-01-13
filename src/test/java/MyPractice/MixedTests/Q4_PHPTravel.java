package MyPractice.MixedTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Q4_PHPTravel {

    /*
    https://phptravels.com/demo
     */

    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://phptravels.com/demo");

    }

    @Test
    public void test(){

       driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Ada");
       driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Berg");
       driver.findElement(By.xpath("//input[@name='business_name']")).sendKeys("AdaBerg");
       driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ada@gmail.com");

        int number1 = Integer.parseInt(driver.findElement(By.id("numb1")).getText());
        int number2 = Integer.parseInt(driver.findElement(By.id("numb2")).getText());
        String result = number1+number2+"";

        driver.findElement(By.id("number")).sendKeys(result);

        //Click on 'SUBMIT'
        driver.findElement(By.id("demo")).click();

        //Assert that the form has been sent
        WebElement thankYou = driver.findElement(By.xpath("//strong[.=' Thank you!']"));
        assertTrue(thankYou.isEnabled());




    }

}
