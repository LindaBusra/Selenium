package MyPractice.WindowHandleIframe;

import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

public class P22_WindowHandle02 extends TestBase {

    /*
    // 1- amazon ana sayfaya gidin
    // 2- nutella icin arama yaptirin
    // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
    // 4- yeni tab'da acilan urunun title'ini yazdirin
    // 5- ilk sayfaya gecip url'i yazdiralim


     */




    @Test
    public void test(){

        // 1- amazon ana sayfaya gidin
        driver.get("https://www.amazon.com/");
        String handleOfFirstWindow = driver.getWindowHandle();      //hashCode for this window

        /*Selenium sayfalar arasi geciste bu window handle degerini kullanir. Sayfalar arasinda driver'imizi gezdiriyorsak ve
        herhangi bir sayfadan bu ilk  sayfaya gecmek istiyorsak :
        driver.switchTo().window("CDwindow-4062F2D78BD37C7921FEBC32A9B51C74"); */

        // 2- nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella" + Keys.ENTER);

        // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
        WebElement firstPicture = driver.findElement(By.xpath("//img[@data-image-index='1']"));
        driver.switchTo().newWindow(WindowType.TAB);

        /*  Bu komutu kullandigimizda driver otomatik olarak olusturulan new Tab'a gecer
        yeni tab'da gorevi gerceklestirmek icin  adimlari bastan almamiz gerekir
         */

        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella" + Keys.ENTER);
        driver.findElement(By.xpath("//img[@data-image-index='1']"));
        System.out.println("1");

        // 4- yeni tab'da acilan urunun title'ini yazdirin
        WebElement productTitle = driver.findElement(By.xpath("//*[text()='Nutella Hazelnut Spread with Cocoa for Breakfast, Great for Holiday Baking, 35.3 oz Jar']"));
        System.out.println(productTitle.getText());
        System.out.println("2");

        String handleOfSecondWindow = driver.getCurrentUrl();
        System.out.println(handleOfSecondWindow);  //handle for second windows
        System.out.println("3");

        // 5- ilk sayfaya gecip url'i yazdiralim
        driver.switchTo().window(handleOfFirstWindow);
        System.out.println(driver.getCurrentUrl());
        System.out.println("4");
    }

}
