package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class nots {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "./src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        driver.get("url");              //Navigate to the page

        driver.getTitle();              //Returns the title of the page  //Title in browser.

        driver.getCurrentUrl();         //Returns the URL of the page

        driver.getPageSource();         //Returns the page source of the page  //right click on page-->view page source

        driver.getWindowHandle();       //Returns the unique ID of the active window

        driver.getWindowHandles();      //Returns the unique ID of the all active windows

        driver.navigate().to("url");     //Navigate to the page

        driver.manage().window().maximize();    //Maximizes the window



        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();      //!!!




         /*
    ●Hergün yapılan testlere Smoke Test denir. Günlük yapılan,tekrarlanan testlerdir.
    ●Framework için dizayn stili denebilir.Test Case’lerin oluşturulma ve gözden geçirme süresini azaltmak ve işleri
    kolaylaştırmak için tasarlanmış yapılardır
    ●  Selenium Bileşenleri--> 4 tanedir ancak bize lazım olan ve kullanacagımız -->
       WebDriver ( Biz Selenium WebDriver kullanacağız) ve Selenium Grid ( paralel test için kullanılıyor )
    ●WebDriver-->Interfacedir. Şablonu belirler,implements eden classların hangi methodları sahip olacagını belirlemiştir.
    ChromeDriver,Firefox,Opera-->Classları. Interface'e implements etmişlerdir
    ●===>Kullanacagımız web browserların hangi methodları taşıması gerektigini belirlemek için WebDriver interface'ini
        kullanıyoruz. (Interface oldugu için obje oluşturamayız çünkü o bir interfacedir)
    ●===>WebDriverin belirledigi ChromeDriverin implement ettigi methodları kullanıyoruz.
    !●!  Hiç bir şey yazmasam da ----- WebDriver driver=new ChromeDriver(); ---- şeklinde yazdıgımda boş bir sayfaya
    götürecektir beni. Çünkü WebDriverdan ChromeDriverın constructorı ile bir obje oluşturmuş oluyorum
     */


        //The testing we are executing by using selenium is called selenium testing.
        // To do Selenium testing we created Maven project and uploaded Selenium Jar files and Chrome Driver


        driver.close(); // açtıgımız web sayfasını bu kodla kapatıyoruz.
// driver.close classın sonuna yazılır.Çünkü bu kod çalışınca driver'imiz kapanır.
        // bu koddan sonra yeniden bir browser açmak istiyorsak driver'a yeni bir deger atamalıyız.

        driver=new ChromeDriver();


        //Using an object in multiply form -->Polymorphism

        //CREATE DRIVER INSTANCE  -->Polymorphism
        WebDriver driver1 = new ChromeDriver();
        WebDriver driver2 = new FirefoxDriver();
        WebDriver driver3 = new EdgeDriver();


        /*
        In our framework, we have utilities package.
        Utilities package: We have support classes, they can support our framework.
        TestBase, Reusable Methods, Driver, Excel Utils, etc.



         */







    }
}
