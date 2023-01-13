package MyPractice.WindowHandleIframe;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class P22_WindowHandle06 extends TestBase {

    @Test
    public void test() {

        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

        //2."Login Portal" a kadar asagi inin
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();

        String handleWindow1 = driver.getWindowHandle();
        System.out.println("1");


        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();
        System.out.println("2");


        //4.Diger window'a gecin
        Set<String> handleList = driver.getWindowHandles();
        String handleWindow2 = "";

        for(String w: handleList) {

            if(!w.equals(handleWindow1)) {

                handleWindow2 = w;
            }
        }

        driver.switchTo().window(handleWindow2);

        System.out.println("3");


        //5."username" ve "password" kutularina deger yazdirin

        System.out.println("4");

        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(faker.name().username());
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(faker.internet().password());
        System.out.println("5");


        // 6."login" butonuna basin
        driver.findElement(By.id("login-button")).click();
        System.out.println("6");

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals("validation failed",actualAlertText);
        System.out.println("7");


        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        System.out.println("8");


        //9.Ilk sayfaya geri donun
        driver.switchTo().window(handleWindow1);
        System.out.println("9");


        //10.Ilk sayfaya donuldugunu test edin
        WebElement homepageText = driver.findElement(By.id("nav-title"));
        Assert.assertTrue(homepageText.isDisplayed());
        System.out.println("10");

    }
}