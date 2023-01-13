package MyPractice.CookiesAlertAnnocations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P17_CookiesBestBuy {



    @Test
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 1- https://www.bestbuy.com adresine gidin
        driver.get("https://www.bestbuy.com");

        // 2- cookies cikarsa kabul et butonuna basin
//        driver.findElement(By.xpath("//button[@title='Allow essential and optional cookies']")).click();

        // 3- sayfada kac adet button bulundugunu yazdirin
        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        System.out.println(buttonList.size());

        // 4- sayfadaki herbir button uzerindeki yazilari yazdirin

        for(WebElement w: buttonList) {

            System.out.println(w.getText());
        }


    }
}
