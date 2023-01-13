package MyPractice.SynchronizationExplicitlyImplisitWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class ExplicitlyWait02 extends TestBase {


    //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //2. Textbox’in etkin olmadigini(enabled) dogrulayın
    //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //4. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    //5. Textbox’in etkin oldugunu(enabled) dogrulayın.

    @Test
    public void enableTest() {


        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement enableBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(enableBox.isEnabled());
        System.out.println("1");

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        System.out.println("2");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(enableBox));
        System.out.println("3");

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement isItEnabledTExt = driver.findElement(By.id("message"));
        Assert.assertTrue(isItEnabledTExt.isEnabled());
        System.out.println("4");

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(enableBox.isEnabled());


    }
}
