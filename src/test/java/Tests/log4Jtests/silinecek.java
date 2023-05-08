package Tests.log4Jtests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class silinecek {



    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

//1.Create method selectByIndexTest and Select Option 1 using index

    @Test
    public void selectByIndexTest(){
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);


    }


    //2.Create method selectByVisibleTextTest Select Option 2 by visible text
    @Test
    public void selectByVisibleText(){
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Option 1");


    }

    //2.Create method selectByVisibleTextTest Select Option 2 by visible text
    @Test
    public void selectByValue() throws InterruptedException {
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropDown);
        select.selectByValue("1");
        Thread.sleep(3000);
    }


    @Test
    public void printAll() throws InterruptedException {
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropDown);

        List<WebElement> allOptions = select.getOptions();

        for(WebElement w : allOptions) {
            System.out.println(w.getText());
        }

    }
}