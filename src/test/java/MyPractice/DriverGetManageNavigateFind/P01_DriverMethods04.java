package MyPractice.DriverGetManageNavigateFind;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class P01_DriverMethods04 {

    //Amazon sayfasina gidelim. https://www.amazon.com
    //sayfa basligini yazdiralim
    //Sayfa baslaiginin "Amazon" icerdigini test edin.
    //Sayfa adresini (url) yazdirin.
    //sayfa url'sinin "amazon 2 icerdigini test edin.
    //sayfa handle degerini yazdirin.
    //sayfa html kodlarinda "Gateway" kelimesi gectigini test edin
    //sayfayi kapatin.

    @Test
    public void test(){

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        //Amazon sayfasina gidelim. https://www.amazon.com
        driver.get("https://www.amazon.com");

        //sayfa basligini yazdiralim
        String title = driver.getTitle();
        System.out.println(title);

        //Sayfa basliginin "Amazon" icerdigini test edin.
        Assert.assertTrue(title.contains("Amazon"));

        //Sayfa adresini (url) yazdirin.
        String url = driver.getCurrentUrl();

        //sayfa url'sinin "amazon" icerdigini test edin.
        Assert.assertTrue(url.contains("amazon"));

        //sayfa handle degerini yazdirin.
        System.out.println(driver.getWindowHandle());

        //sayfa html kodlarinda "Gateway" kelimesi gectigini test edin
        Assert.assertTrue(driver.getPageSource().contains("Gateway"));

        //Amazon sayfasindaki <input> taginin sayisini yazdirin.
        List<WebElement> inputList = driver.findElements(By.tagName("input"));
        System.out.println("input tag sayisi: " + inputList.size());

        //Amazon sayfasindaki <a> taginin sayisini yazdirin.
        List<WebElement> aList = driver.findElements(By.tagName("a"));
        System.out.println("input tag sayisi: " + aList.size());

        //Amazon sayfasindaki <a> taglarinin isimlerini yazdirin.
        for(WebElement w: aList) {
            System.out.println(w.getText());
        }

        //sayfayi kapatin.
        driver.close();


    }

}
