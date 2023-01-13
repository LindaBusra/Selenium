package MyPractice.CookiesAlertAnnocations;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P23_Allert extends TestBase {

    /*
/● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
//● Bir metod olusturun: acceptAlert
//○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “I am a JS Confirm” oldugunu test edin.
//● Bir metod olusturun: dismissAlert
//○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “I am a JS Confirm” icerdigini test edin.
//● Bir metod olusturun: sendKeysAlert
//○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.


    // 2. Way to handle allert
    // WebDriverWait w = new WebDriverWait(driver, 10);
    // Alert alert = w.until(ExpectedConditions.alertIsPresent());
    // Thread.sleep(2000);
    // alert.accept();

     */

    @Test
    public void acceptAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        String expectedText = "I am a JS Alert";
        String actualText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        Assert.assertTrue(expectedText.equals(actualText));
    }


    @Test
    public void dismissAlert() {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        String expectedText = "I am a JS Confirm";
        String actualText = driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();

        Assert.assertTrue(expectedText.equals(actualText));
    }



    @Test
    public void sendKeysAllert(){

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Ada");
        driver.switchTo().alert().accept();

        String expectedText = "You entered: Ada";
        String actualText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertTrue(expectedText.equals(actualText));
    }
}
