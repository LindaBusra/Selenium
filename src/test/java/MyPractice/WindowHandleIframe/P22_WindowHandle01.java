package MyPractice.WindowHandleIframe;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class P22_WindowHandle01 extends TestBase {

    @Test
    public void test(){
        // ● Tests package’inda yeni bir class olusturun: C04_WindowHandle
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualYazi=driver.findElement(By.tagName("h3")).getText();
        String expectedYazi="Opening a new window";
        Assert.assertEquals("yazi istendigi gibi degil", expectedYazi, actualYazi);


        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";

        Assert.assertEquals("title istenen degerden farkli", expectedTitle, actualTitle);
        System.out.println("ilk sayfanin handle degeri : "+driver.getWindowHandle());


        // 1- window handle ederken ilk adim 1 sayfa acik iken o sayfanin handle degerini alip bir string'e atamak
        String ilkSayfaHandle=driver.getWindowHandle();

        //● Click Here butonuna basın.
        // bu satirda 2.window acildi
        driver.findElement(By.linkText("Click Here")).click();

        // 2- ikinci adim iki sayfa acildiginda her iki sayfanin handle degerlerini koymak icin
        //   bir set olusturup, getWindowhandles methodu ile bu degerleri elde etmek
        Set<String> tumWindowHandlelari = driver.getWindowHandles();
        System.out.println("All Handles : "+tumWindowHandlelari);

        // 3- ucuncu adim set icerisinde birinci sayfanin handle degerine esit olmayan
        //    handle degerini bulup bir string degiskene atamak
        String ikinciWindowhandle="";
        for (String each:tumWindowHandlelari) {

            if (!each.equals(ilkSayfaHandle)){
                ikinciWindowhandle=each;
            }
        }
        // bu satira geldigimizde elimizde 2.sayfain handle degeri var olacak
        System.out.println("ikinci sayfa handle degeri : " + ikinciWindowhandle);

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciWindowhandle);

        // switchTo ile window degistireceksek gidecegimiz window'un windowhandle degerine ihtiyacimiz var...
        String actualYeniTitle= driver.getTitle();
        String expectedYeniTitle="New Window";
        Assert.assertEquals("yeni sayfanin title'i yanlis", expectedYeniTitle, actualYeniTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement yeniSayfaYaziElementi=driver.findElement(By.tagName("h3"));
        String expectedYaziYeniSayfa="New Window";
        String actualSayfaYaziYeniSayfa=yeniSayfaYaziElementi.getText();
        Assert.assertEquals("yeni sayfadaki yazi beklenenden farkli", expectedYaziYeniSayfa, actualSayfaYaziYeniSayfa);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandle);
        actualTitle=driver.getTitle();
        Assert.assertEquals("title istenen degerden farkli", expectedTitle, actualTitle);


    }
}