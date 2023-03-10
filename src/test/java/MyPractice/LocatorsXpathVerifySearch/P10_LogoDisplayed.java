package MyPractice.LocatorsXpathVerifySearch;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class P10_LogoDisplayed {


    /*
    Google'a gidelim
    LOgosunun görünüp görünmediğini assert edelim
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }



    @Test
    public void test1() {
        driver.get("https://www.google.com");
        driver.findElement(By.id("L2AGLb")).click();
        WebElement logo=driver.findElement(By.xpath("//img[@class='lnXdpd']"));
        Assert.assertTrue(logo.isDisplayed());
        System.out.println("Logo displayed");



    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
