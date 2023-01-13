package Tests;

import org.bouncycastle.util.io.TeeInputStream;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day05_RadioButton02 extends TestBase {

    //https://www.facebook.com adresine gidin
    //Cookies’i kabul edin
    //“Create an Account” button’una basin
    //“radio buttons” elementlerini locate edin
    //Secili degilse cinsiyet butonundan size uygun olani secin



    @Test
    public void test01()  throws InterruptedException {

        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //Cookies’i kabul edin
          driver.findElement(By.xpath("//*[text()='Allow essential and optional cookies']")).click();

        //“Create an Account” button’una basin
        driver.findElement(By.xpath("//*[text()='Create New Account']")).click();

        //“radio buttons” elementlerini locate edin
        WebElement femaleButton = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement maleButton = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement customButton = driver.findElement(By.xpath("//input[@value='-1']"));

        //Secili degilse cinsiyet butonundan size uygun olani secin
        Thread.sleep(3000);
        if (!maleButton.isSelected()) {
            maleButton.click();
        }
        Thread.sleep(3000);
    }




}



