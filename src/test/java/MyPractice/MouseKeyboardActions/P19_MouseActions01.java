package MyPractice.MouseKeyboardActions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class P19_MouseActions01 {

    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }


    @Test
    public void test(){

        // Go to amazon
        driver.get("https://www.amazon.com");

        // Click "create a list" link from Account & Lists
        Actions actions = new Actions(driver);

        WebElement account = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(account).perform();

        driver.findElement(By.linkText("Create a List"));




    }

    @After
    public void tearDown(){
        driver.close();
    }

}
