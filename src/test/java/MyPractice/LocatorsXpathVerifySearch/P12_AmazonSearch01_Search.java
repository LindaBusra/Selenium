package MyPractice.LocatorsXpathVerifySearch;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P12_AmazonSearch01_Search {

    //https://github.com/gokhanagar/Selenium/tree/master/seleniumGiris/src/test/java/day04_xpath_cssLocater


    public static void main(String[] args) {

        //a.amazon web sayfasına gidin. https://www. amazon.com/
        //b. Search(ara) “city bike”
        //c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        //d. “Shopping” e tıklayın.
        //e. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // a. web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        // b. Search(ara) “city bike”
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike" + Keys.ENTER);

        // c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        List<WebElement> listOfElements = driver.findElements(By.className("sg-col-inner"));
        System.out.println("size ve of list : " + listOfElements.size());

        //Amazon'da görüntülenen ilgili sonuçların yazisini
        System.out.println("sonuc yazisi:" + listOfElements.get(0).getText());

        //d-Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        List<WebElement> listOfElementsPicture = driver.findElements(By.className("s-image"));
        WebElement firstElementPicture = listOfElementsPicture.get(0);
        firstElementPicture.click();

        driver.quit();

    }
}
