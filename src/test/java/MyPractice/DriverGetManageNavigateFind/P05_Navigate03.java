package MyPractice.DriverGetManageNavigateFind;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05_Navigate03 {

    @Test
    public void test() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //bu method sayfadaki her bir web element icin max bekleme suresini verir. Web element yuklenmezse fail olarak atar.

        //amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //techpro sayfasina gidelim
        Thread.sleep(3000);  //kodlar istedigimiz sure kadar bekler.

        driver.navigate().to("https://www.techproeducation.com");

        //tekrar amazona donelim
        driver.navigate().back();

        //techpro sayfasina gidelim
        driver.navigate().forward();

        //sayfayi refresh edelim
        driver.navigate().refresh();

        //sayfayi kapatalim
        driver.close();
    }

}
