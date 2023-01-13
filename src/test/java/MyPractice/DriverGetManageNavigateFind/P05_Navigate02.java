package MyPractice.DriverGetManageNavigateFind;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class P05_Navigate02 {

               /*
        ...Exercise1...
        1-driver olusturalim
        2-java class'imiza chromedriver.exe'yi tanitalim
        3-driver'in tum ekrani kaplamasini saglayalim
        4-driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
          söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
        5-"sahibinden.com" adresine gidelim
        6-bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
        7-title ve url'nin "Kiralik" kelimesinin icerip icermedigini kontrol edelim
        8-Ardindan "gittigidiyor.com" adresine gidelim
        9-bu adresin basligini alalim ve "alisveris" kelismesini icerip icermedigini
          kontrol edelim
        10-Bi onceki web sayfamiza geri donelim
        11-sayfayi yenileyelim
        12-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        13-Enson adim olarak butun sayfalarimizi kapatmis olalim
 */


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://sahibinden.com");
        String title=driver.getTitle();
        String pageURL= driver.getCurrentUrl();


        if (title.contains("sahibinden")){
            System.out.println("sahibinden title testi PASS");
        }else{
            System.out.println("sahibinden title testi FAILED");
        }



        if (pageURL.contains("sahibinden")){
            System.out.println("URL testi PASS");
        }else{
            System.out.println("URL testi FAILED");
        }


        driver.navigate().to("https://gittigidiyor.com");
        String title1=driver.getTitle();


        if (title1.contains("Cars")){
            System.out.println("gitti gidiyor title testi PASS");
        }else{
            System.out.println("gitti gidiyor title testi FAILED");
        }



        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.close();
        driver.quit();

    }

}