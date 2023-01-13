package MyPractice.LocatorsXpathVerifySearch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P12_AmazonSearch06_SearchVerify {

    public static void main(String[] args) {

        // 1. Yeni bir class olusturun (TekrarTesti)
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.navigate().to("https://www.youTube.com");
        String actualtitleYoutube = driver.getTitle();
        String expectedTitle="youtube";

        if (actualtitleYoutube.equals(expectedTitle)) {
            System.out.println("Youtube title test PASS");
        } else {
            System.out.println("Youtube title test FAİLED \nactual sayfa başlıgı: " + actualtitleYoutube);
        }

        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.
        String actualYoutubeUrl=driver.getCurrentUrl();
        String arananKelime="youtube";

        if (actualYoutubeUrl.contains(arananKelime)) {
            System.out.println("Youtube URL test PASS");
        } else {
            System.out.println("Youtube URL test FAİLED \nActual Youtube URL: " + actualtitleYoutube);
        }

        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        //5. Youtube sayfasina geri donun
        driver.navigate().back();

        //6. Sayfayi yenileyin
        driver.navigate().refresh();

        //7. Amazon sayfasina donun
        driver.navigate().forward();

        //8. Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();

        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa doğru başlığı(Actual Title) yazdırın.
        String actualTitle=driver.getTitle();
        String amazonTitleArananKelime="Amazon";

        if (actualTitle.contains(amazonTitleArananKelime)) {
            System.out.println("Amazon title test PASS");
        } else {
            System.out.println("Amazon title test FAİLED \nActual Amazon title: " + actualTitle);
        }



        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
        String expectedAmazonUrl="https://www.amazon.com/";
        String actualAmazonUrl=driver.getCurrentUrl();

        if (expectedAmazonUrl.equals(actualAmazonUrl)) {
            System.out.println("Amazon URL test PASS");
        } else {
            System.out.println("Amazon URL test FAİLED \nActual Amazon URL: " + actualAmazonUrl);
        }


        //11.Sayfayi kapatin
        driver.close();
        driver.quit();



    }
}
