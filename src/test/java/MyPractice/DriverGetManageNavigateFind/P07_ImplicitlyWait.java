package MyPractice.DriverGetManageNavigateFind;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P07_ImplicitlyWait {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amaazon.com");


        driver.close();

         /*
            Bir sayfa acilirken, ilk basta sayfanin icerisinde bulunan elementlere gore
            bir yuklenme suresine ihtiyac vardir
            veya bir web elementinin kullanilabilmesi icin zaman ihtiyac olabilir
            implicitlyWait bize sayfanin yuklenmesi ve sayfadaki elementlere ulasim icn beklenecek
            MAXIMUM sureyi belirleme olanagi tanir


            implicitlywait testimiz boyunca sayfa açılması ve element bulunması konusunda driver'in bekleyecegi
            maximum süreyi belirler. Bu süre içerisinde görevini bitirir bitirmez bir sonraki adıma geçer
            bu süre zarfında görevini bitiremezse o zaman hata verir.

            Belirlenen max. süre Thread.sleep deki gibi mutlak bekleme süresi degildir. Görevi bitirdiyse 15.sn. yazdıysam
            sonuna kadar beklemez, görevi bitirince yapıp geçer. Bitiremezse max. süreye kadar bekler,
            açılmadıgı takdirde run time verir.
         */


    }
}
