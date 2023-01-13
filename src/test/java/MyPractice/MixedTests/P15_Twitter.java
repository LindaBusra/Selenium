package MyPractice.MixedTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.concurrent.TimeUnit;

/*
1. "https://www.twitter.com" hesabına gidin
2. Register butonuna tıklayın
3. Kendi bilgilerinizi girerek hesap oluşturun.
 */

public class P15_Twitter {

    static WebDriver driver;

    @BeforeClass
    public static  void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.twitter.com");
        driver.findElement(By.xpath("//*[text()='Sign up']")).click();          //???
        driver.findElement(By.name("name")).sendKeys("busra");
        driver.findElement(By.name("phone_number")).sendKeys("5385024556");
        WebElement dropdownMonth=driver.findElement(By.id("Month"));
        Select select=new Select(dropdownMonth);
        select.selectByIndex(1);

        WebElement dropdownDay=driver.findElement(By.id("Day"));
        Select select1=new Select(dropdownDay);
        select1.selectByIndex(2);

        WebElement dropdownYear=driver.findElement(By.id("Year"));
        Select select2=new Select(dropdownYear);
        select2.selectByIndex(8);

        driver.findElement(By.xpath("//*[text()='Next']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Next']")).click();
        driver.findElement(By.xpath("//div[@role='button']")).click();




    }


    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }


}
