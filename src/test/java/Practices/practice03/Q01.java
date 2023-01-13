package Practices.practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class Q01 extends TestBase {


    /*
    Given
        Go to https://demo.guru99.com/test/drag_drop.html
    When
        Drag orange elements on proper boxes below them
    Then
        Verify they are dropped.
 */

    @Test
    public void test(){

        driver.get("https://demo.guru99.com/test/drag_drop.html");

        driver.findElement(By.xpath("//p[text()='Consent']")).click();


        //Drag orange elements on proper boxes below them
        WebElement bank = driver.findElement(By.id("credit2"));
        WebElement debitAccount = driver.findElement(By.id("bank"));

        WebElement sales = driver.findElement(By.id("credit1"));
        WebElement creditAccount = driver.findElement(By.id("loan"));

        WebElement price1 = driver.findElement(By.id("fourth"));
        WebElement debitAmount = driver.findElement(By.id("amt7"));

        WebElement price2 = driver.findElement(By.xpath("//li[@data-id='2']"));
        WebElement credittAmount = driver.findElement(By.id("amt8"));

        //Create actions object, user Actions class to move source into target
        Actions actions = new Actions(driver);

        //Drag sources to target:
        actions.dragAndDrop(bank, debitAccount)
                .dragAndDrop(sales, creditAccount)
                .dragAndDrop(price1, debitAmount)
                .dragAndDrop(price2, credittAmount).perform();

        //Verify they are dropped.
        WebElement perfect = driver.findElement(By.xpath("//a[text()='Perfect!']"));
        Assert.assertTrue(perfect.isDisplayed());
        //or
        assertEquals("Perfect!", perfect.getText());

    }

}
