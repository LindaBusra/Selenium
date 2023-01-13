package MyPractice.MixedTests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P15_Facebook01 {


    // https://www.facebook.com adresine gidin
    // cookies cikarsa kabul et butonuna basin
    // e-posta kutusuna rastgele bir mail girin
    // sifre kismina rastgele bir sifre girin
    // giris yap butonuna basin
    // uyari olarak "The email or mobile number you entered isn’t connected to an account. Find your account and log in."
    //  mesajinin ciktigini test edin
    // sayfayi kapatin


    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // https://www.facebook.com adresine gidin
        driver.get("https:www.facebook.com");

        Faker faker = new Faker();

        // cookies cikarsa kabul et butonuna basin
        driver.findElement(By.xpath("//button[@title='Allow essential and optional cookies']")).click();

        // e-posta kutusuna rastgele bir mail girin
        WebElement email= driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys(faker.internet().emailAddress());


        // sifre kismina rastgele bir sifre girin
        WebElement password= driver.findElement(By.xpath("//input[@id='pass']"));
        password.sendKeys(faker.internet().password());

        // giris yap butonuna basin
        driver.findElement(By.xpath("//button[@name='login']")).click();

        // uyari olarak "The email or mobile number you entered isn’t connected to an account. Find your account and log in."
        //  mesajinin ciktigini test edin
        WebElement actualText= driver.findElement(By.xpath("//div[@class='_9ay7']"));
        String expectedText="The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
        String actualTextResult=actualText.getText();

        Assert.assertEquals("Test failed", expectedText, actualTextResult);
        System.out.println("Test passed :) ");



        driver.close();


    }
}
