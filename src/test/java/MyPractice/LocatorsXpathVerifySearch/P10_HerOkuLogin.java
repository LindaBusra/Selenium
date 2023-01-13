package MyPractice.LocatorsXpathVerifySearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P10_HerOkuLogin {



    // 1.  https://id.heroku.com/login sayfasina gidin
    //2.  Bir mail adersi giriniz
    //3.  Bir password giriniz
    //4.  Login butonuna tiklayiniz
    //5.  "There was a problem with your login." texti gorunur ise
    //6.  "kayit yapilamadi" yazdiriniz
    //8.  eger yazi gorunur degilse "kayit yapildi" yazdiriniz
    //9.  Tum sayfalari kapatiniz

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://id.heroku.com/");

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();       //accept cookies

        WebElement mailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
        mailKutusu.sendKeys("ab@gmail.com");
        WebElement passwordKutusu = driver.findElement(By.xpath("//input[@id='password']"));
        passwordKutusu.sendKeys("Ab1234");
        WebElement loginButonu = driver.findElement(By.xpath("//button[@name='commit']"));


        loginButonu.submit();


        System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).isDisplayed()
                ? "Kayıt yapılamadı" : "Kayıt yapıldı");

        Thread.sleep(1000);

        driver.quit();


    }}