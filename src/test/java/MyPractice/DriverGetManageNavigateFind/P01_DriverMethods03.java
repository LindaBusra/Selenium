package MyPractice.DriverGetManageNavigateFind;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01_DriverMethods03 {

    public static void main(String[] args) {

        //  ...Exercise2...
        //  1-driver olusturalim
        //  2-java class'imiza chromedriver.exe'yi tanitalim
        //  3-driver'in tum ekrani kaplamasini saglayalim
        //  4-driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
        //    söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.

        System.setProperty("webdriver.chrome.driver" , "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //5-"https://www.finn.no/" adresine gidelim
        driver.get("https://www.finn.no/");


        //  6-bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();

        //  7-title ve url'nin "finn" kelimesinin icerip icermedigini kontrol edelim
        String findWord = "finn";

        if(actualTitle.contains(findWord) && actualUrl.contains(findWord)) {
            System.out.println("They are contains " + findWord);
        } else {
            System.out.println("They are not contains " + findWord);
        }

        // 8-Ardindan "https://www.nav.no/" adresine gidelim
        driver.get("https://www.nav.no/");


        // 9-bu adresin basligini alalim ve "nav" kelimesini icerip icermedigini kontrol edelim

        boolean isTrue =driver.getTitle().contains("nav");
//        if(isTrue) System.out.println("Title test passed");
//        else System.out.println("Title test does not passed");

        //or
        System.out.println(isTrue ? "Title test passed" : "Title test does not passed");
        //  10-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();

        //  11-sayfayi yenileyelim
        driver.navigate().refresh();

        ////  12-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.navigate().forward();

        //  13-En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();









    }
}
