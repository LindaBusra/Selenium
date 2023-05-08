package Tests;

import org.bouncycastle.util.io.TeeInputStream;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day05_RadioButton02 extends TestBase {

//Go to https://www.facebook.com
// accept cookies
//Press the "Create an Account" button
// Locate “radio buttons” elements
// If it is not selected, choose the one that suits you from the gender button



    @Test
    public void test01()  throws InterruptedException {

        //Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        // accept cookies

        try {
            driver.findElement(By.xpath("//*[text()='Allow essential and optional cookies']")).click();
        } catch (WebDriverException e) {
            System.out.println("cookies");
        }

        //Press the "Create an Account" button
        driver.findElement(By.xpath("//*[.='Create new account']")).submit();

        // Locate “radio buttons” elements
        WebElement femaleButton = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement maleButton = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement customButton = driver.findElement(By.xpath("//input[@value='-1']"));

        // If it is not selected, choose the one that suits you from the gender button
        Thread.sleep(3000);
        if (!maleButton.isSelected()) {
            maleButton.click();
        }
        Thread.sleep(3000);
    }




}



