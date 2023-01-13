package MyPractice.WindowHandleIframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P22_WindowHandle03 extends TestBase {

    // 1- amazon anasayfaya gidelim
    // 2- url'in amazon icerdigini test edelim
    // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
    // 4- title'in BestBuy icerdigini test edelim
    // 5- ilk sayfaya donup sayfada java aratalim
    // 6- arama sonuclarinin Java icerdigini test edelim
    // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
    // 8- logonun gorundugunu test edelim


    @Test
    public void test(){
        // 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String handleOfFirstWindow = driver.getWindowHandle();
        System.out.println("1");

        // 2- url'in amazon icerdigini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        System.out.println("2");

        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String handleOfSecondWindow = driver.getWindowHandle();
        System.out.println("3");

        // 4- title'in BestBuy icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));
        System.out.println("4");

        // 5- ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(handleOfFirstWindow);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);
        System.out.println("5");


        // 6- arama sonuclarinin Java icerdigini test edelim
        WebElement results = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(results.getText().contains("Java"));
        System.out.println("6");

        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        driver.switchTo().window(handleOfSecondWindow);
        System.out.println("7");

        // 8- logonun gorundugunu test edelim
        WebElement logo = driver.findElement(By.xpath("//img[@class='logo']"));
        Assert.assertTrue(logo.isDisplayed());
        System.out.println("8");


    }
}
