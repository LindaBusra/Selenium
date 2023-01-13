package MyPractice.MixedTests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.time.Duration;

public class Q2_TutorialsNinja {

    /*
http://tutorialsninja.com/demo/ bu siteden üyelik oluşturalım
faker kullanarak ve alışveriş sepetine 3 ürün ekleyelim :
(HTC Touch HD, Samsung Galaxy Tab 10.1, Samsung SyncMaster 941BW)
Sonunda toplam tutarı print edin

    (HTC Touch HD, Samsung Galaxy Tab 10.1, Samsung SyncMaster 941BW)

     */

    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://tutorialsninja.com/demo/");

    }

    @Test
    public void test() throws AWTException {

        WebElement dropDown = driver.findElement(By.xpath("//span[@class='caret']"));
        dropDown.click();

        driver.findElement(By.linkText("Register")).click();

        Faker faker = new Faker();
        String password = faker.internet().password();
        Actions actions=new Actions(driver);


        WebElement details= driver.findElement(By.id("input-firstname"));
        actions.click(details)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .click()
                .perform();

        driver.findElement(By.xpath("//input[@name='agree']")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.findElement(By.linkText("Continue")).click();

        //Select your products


        WebElement searchBox = driver.findElement(By.xpath("//*[@name='search']"));

        searchBox.sendKeys("Samsung SyncMaster 941BW"+ Keys.ENTER);
        System.out.println("1");
        driver.findElement(By.partialLinkText("Samsung SyncMaster")).click();
        System.out.println("2");
        driver.findElement(By.id("button-cart")).click();
        System.out.println("3");

        driver.findElement(By.xpath("//*[@name='search']")).clear();
        System.out.println("4");
        driver.findElement(By.xpath("//*[@name='search']")).sendKeys("Samsung Galaxy Tab"+ Keys.ENTER);
        driver.findElement(By.partialLinkText("Samsung Galaxy Tab")).click();
        driver.findElement(By.id("button-cart")).click();
        System.out.println("5");

        driver.findElement(By.xpath("//*[@name='search']")).clear();
        driver.findElement(By.xpath("//*[@name='search']")).sendKeys("HTC Touch HD"+ Keys.ENTER);
        driver.findElement(By.linkText("HTC Touch HD")).click();
        driver.findElement(By.id("button-cart")).click();
        System.out.println("6");

        driver.findElement(By.xpath("//button[@data-toggle='dropdown']")).click();
        driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();

        Robot robot =new Robot();
        robot.mouseWheel(10);



        WebElement totalPrice = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/table/tbody/tr[4]/td[2]"));

        System.out.println(totalPrice.getText());











    }
}
