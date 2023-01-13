package MyPractice.MixedTests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P14_SauceDemo01 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");


        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");


        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.id("password")).sendKeys("secret_sauce");


        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();


        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement firstProduct=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String firstProductS = firstProduct.getText();

        System.out.println(firstProductS);
        firstProduct.click();



        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        System.out.println("butona basildi");


        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
        System.out.println("alisveris sepetine tiklandi");



        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin

        WebElement product=driver.findElement(By.className("inventory_item_name"));
        String productSuccess = product.getText();

        System.out.println(productSuccess.contains(firstProductS) ? "Test PASS" : "TEST FAİLED" );



        //9. Sayfayi kapatin

        Thread.sleep(1500);
        driver.close();


        //1. “https://www.saucedemo.com” Adresine gidin
        //2. Username kutusuna “standard_user” yazdirin
        //3. Password kutusuna “secret_sauce” yazdirin
        //4. Login tusuna basin
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        //6. Add to Cart butonuna basin
        //7. Alisveris sepetine tiklayin
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        //9. Sayfayi kapatin
    }

}