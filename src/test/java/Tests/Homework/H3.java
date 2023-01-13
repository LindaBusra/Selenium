package Tests.Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class H3 extends TestBase {

    /*
    When user goes to https://jqueryui.com/toggle/
    Print the text that should be : Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede.
        Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
    Eg: System.out.println(element); -> Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.

    Then click on Run Effect button

    Then print the text and verify it is empty.
    Eg: System.out.println(element); -> NO TEXT

    Then click on Run Effect button one more time
    Print the text that should be : Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
    Eg: System.out.println(element); -> Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
     */


    @Test
    public void test(){

        driver.get("https://jqueryui.com/toggle/");
        driver.switchTo().frame(0);

        WebElement text = driver.findElement(By.xpath("//p[contains(text(),'Etiam libero neque')] "));
        String expectedText = "Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.";

        Assert.assertTrue(text.getText().equals(expectedText));
        System.out.println(text.getText());

        driver.findElement(By.id("button")).click();

        waitFor(3);
        WebElement emptyText = driver.findElement(By.xpath("//div[@class='toggler']"));
        Assert.assertTrue(emptyText.getText().isEmpty());

        driver.findElement(By.id("button")).click();

        WebElement text2 = driver.findElement(By.xpath("//p[contains(text(),'Etiam libero neque')] "));
        Assert.assertTrue(text2.getText().equals(expectedText));
        System.out.println(text2.getText());

    }


    @Test
    public void effectsTest() throws InterruptedException {
        driver.get("https://jqueryui.com/toggle/");
        driver.switchTo().frame(0);
        String before = driver.findElement(By.xpath("//div[@id='effect']//p")).getText();
        System.out.println("Before : "+before);
        driver.findElement(By.xpath("//button[@id='button']")).click();

        Thread.sleep(2000);
        String after = driver.findElement(By.xpath("//div[@id='effect']//p")).getText();
        System.out.println("After : "+after);

        driver.findElement(By.xpath("//button[@id='button']")).click();
        Thread.sleep(2000);
        String after1 = driver.findElement(By.xpath("//div[@id='effect']//p")).getText();
        System.out.println("After1 : "+after1);



    }



}
