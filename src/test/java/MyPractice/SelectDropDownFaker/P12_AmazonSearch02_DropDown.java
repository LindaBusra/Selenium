package MyPractice.SelectDropDownFaker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P12_AmazonSearch02_DropDown {

    public static void main(String[] args) {


        //1. Amazon sayfasina gidelim. https://www.amazon.com/
        //2. Sayfa basligini(title) yazdirin
        //3. Sayfa basliginin “Amazon” icerdigini test edin
        //4. Sayfa adresini(url) yazdirin
        //5. Sayfa url’inin “amazon” icerdigini test edin.
        //6. Sayfa handle degerini yazdirin
        //7. Sayfa HTML kodlarinda “Easy returns” kelimesi gectigini test edin
        //8. Sayfayi kapatin.


        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://www.amazon.com/");


        String title = driver.getTitle();

        System.out.println(title);

        String findWord ="Amazon";

        if(title.contains(findWord) ) {
            System.out.println("Title contains " + findWord);
        } else {
            System.out.println("Title does not contain " + findWord);
        }



        String url = driver.getCurrentUrl();

        System.out.println(url);

        String findWordInUrl = "Amazon";

        if(url.contains(findWordInUrl) ) {
            System.out.println("Url contains " + findWordInUrl);
        } else {
            System.out.println("Url does not contain " + findWordInUrl);
        }


        System.out.println(driver.getWindowHandle());

//        System.out.println(driver.getPageSource());

        String findWordInHtml = "Amazon Business";
        System.out.println(driver.getPageSource().contains(findWordInHtml) ?  "HTML codes contains " + findWordInHtml : "HTML codes does not contain " + findWordInHtml);



        driver.close();



    }
}
