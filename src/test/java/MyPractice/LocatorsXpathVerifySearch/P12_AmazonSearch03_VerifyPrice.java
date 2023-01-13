package MyPractice.LocatorsXpathVerifySearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P12_AmazonSearch03_VerifyPrice {

    //1-C01_TekrarTesti
    //2- https://www.amazon.com/ adresine gidin
    //3- Browseri tam sayfa yapin
    //4-Sayfayi “refresh” yapin
    //5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
    //6- Gift Cards sekmesine basin
    //7- Birthday butonuna basin
    //8- Best Seller bolumunden ilk urunu tiklayin
    //9- Gift card details’den 25 $’i  secin
    //10-Urun ucretinin 25$ oldugunu test edin
    //10-Sayfayi kapatin



    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().to("https://www.amazon.com/");

        driver.navigate().refresh();

        //Sayfa basliginin “Spend less” ifadesi icerdigini test edin

        String title = driver.getTitle();
        String findWord = "Spend less";

        if(title.contains(findWord))    {
            System.out.println("Title contains " + findWord);
        } else {
            System.out.println("Title does not contain " + findWord);
        }


        //6- Gift Cards sekmesine basin

        driver.findElement(By.linkText("Gift Cards")).click();
        System.out.println("gift cards test passed");

        //7- Birthday butonuna basin

        driver.findElement(By.xpath("//a[@aria-label='Birthday']")).click();
        System.out.println("Birthday test passed");

        //8- Best Seller bolumunden ilk urunu tiklayin

        driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]")).click();
        System.out.println("best seller first product");


        //9- Gift card details’den 25 $’i  secin
        WebElement price = driver.findElement(By.id("gc-mini-picker-amount-1"));
        price.click();
        System.out.println("get 25$");


        //10-Urun ucretinin 25$ oldugunu test edin


        String expectedValue="$25";
        String actualValue = price.getText();

        System.out.println(expectedValue.equals(actualValue) ? "Passed" : "Failed" );

        //10-Sayfayi kapatin

        driver.close();

    }
}
