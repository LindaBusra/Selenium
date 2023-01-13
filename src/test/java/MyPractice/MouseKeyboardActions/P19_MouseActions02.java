package MyPractice.MouseKeyboardActions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P19_MouseActions02 extends TestBase {

    // 1- Yeni bir class olusturalim: MouseActions2
    //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
    //3- Cizili alan uzerinde sag click yapalim
    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
    //5- Tamam diyerek alert’i kapatalim
    //6- Elemental Selenium linkine tiklayalim
    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    @Test
    public void test01() {

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu ");

        //3- Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);

        WebElement box = driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();
        System.out.println("1");


        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.

        Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());
        System.out.println("2");

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        System.out.println("3");

        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium")).click();
        System.out.println("4");

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String actualText = driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
        Assert.assertEquals("Elemental Selenium", actualText);
        System.out.println("5");

    }
}