package MyPractice.WindowHandleIframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class P22_WindowHandle04 extends TestBase {

    @Test
    public void test(){


        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");


        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text = driver.findElement(By.xpath("//*[text()='Opening a new window']"));
        Assert.assertEquals("Opening a new window", text.getText());
        System.out.println("1");


        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertEquals("The Internet", driver.getTitle());
        String handleOfFirstWindow = driver.getWindowHandle();
        System.out.println("2");

        // Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("3");

        /*
        Link tiklayarak yeni tab veya window olustugunda, biz driver'a yeni sayfaya gec demedikce, driver eski sayfada kalir
        ve yeni sayfa ile ilgili hicbir islem yapamaz. Yeni sayfada driver'i calistirmak istersek
        once driver'i yeni sayfaya yollamaliyiz.  --> driver.switchTo().newWindow()

        yeni sayfaya gecebilmek icin oncelikle ikinci sayfanin handle degerini bulmamiz gerekir
        bunun icin driver.getWindowHandles() method'unu kullanarak acik olan tum sayfalarin window handle
        degerlerini alip bir set'e assign edip, Set'deki window handle degerlerini kontrol edip
        ilk sayfanin handle degerine esit olmayan, ikinci sayfanin window handle degeridir diyebiliriz.
         */

        Set<String> handlesSet = driver.getWindowHandles();
        String handleOfSecondtWindow="";

        for(String w : handlesSet) {

            if(! w.equals(handleOfFirstWindow)) {
                handleOfSecondtWindow = w;
            }
        }
        System.out.println("4");

        // artik ikinci sayfanin window handle degeri ile yeni sayfaya gecebiliriz
        driver.switchTo().window(handleOfSecondtWindow);
        System.out.println("5");

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals("New Window", driver.getTitle());
        System.out.println("6");

        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement text1 = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("New Window", text1.getText());
        System.out.println("7");


        // Bir önceki pencereye geri döndükten sonra
        driver.switchTo().window(handleOfFirstWindow);
        System.out.println("8");

        // sayfa başlığının “The Internet” olduğunu doğrulayın.
        Assert.assertEquals("The Internet", driver.getTitle());
        System.out.println("9");

    }

}
