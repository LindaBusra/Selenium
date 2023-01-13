package MyPractice.LocatorsXpathVerifySearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P12_AmazonSearch05_Search {

    public static void main(String[] args) {


        // Set Driver Path
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
;

        // Create chrome driver object
        WebDriver driver = new ChromeDriver();

        // Maximize the window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- https:www.amazon.com sayfasina gidin
        driver.get("https:www.amazon.com");

        //2- arama cubuguna “Nutella” yazdirin
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Nutella");


        //3- Nutella yazdiktan sonra ENTER’a basarak arama islemini yapin
        search.submit();

        //4- Bulunan sonuc sayisini yazdirin.
        WebElement result = driver.findElement(By.xpath("//*[text()='1-48 of 72 results for']"));
        System.out.println(result.getText());

        System.out.println("all ok");
//        driver.close();



    }
}
