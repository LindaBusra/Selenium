package MyPractice.MixedTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1_finnno {
    WebDriver driver;


    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }


    @Test
    public void test() {
        driver.get("https://www.finn.no/");

        driver.findElement(By.linkText("Eiendom")).click();

        driver.findElement(By.xpath("//a[@data-category='Bolig til salgs']")).click();
        driver.findElement(By.xpath("//label[@for ='location-0.20012']")).click();
        driver.findElement(By.xpath("//label[@for ='location-1.20012.20195']")).click();
        driver.findElement(By.xpath("//a[@href='https://www.finn.no/realestate/homes/ad.html?finnkode=284324788']")).click();
        System.out.println("picture");



        driver.findElement(By.id("image-1")).click();
        driver.findElement(By.id("image-2")).click();
        driver.findElement(By.id("image-3")).click();



        driver.close();

    }


}