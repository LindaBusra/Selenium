package Practices.practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Q2 extends TestBase {

    /*
/*
    Given
        Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    When
        Click on the "Animals and Nature" emoji
    And
        Click all the "Animals and Nature"  emoji elements
    And
        Fill the form
    And
        Press the apply button
    Then
        Verify "code" element is displayed
     */

    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        //first switch into iframe
        WebElement emojiesIframe  = driver.findElement(By.id("emoojis"));
        driver.switchTo().frame(emojiesIframe);


        //Click on the "Animals and Nature" emoji
        driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]")).click();

        //Click all the "Animals and Nature"  emoji elements
        List<WebElement> emojis = driver.findElements(By.xpath("//div[@id='nature']/div/img"));
//        System.out.println(emojis.size());

        for(WebElement w: emojis) {
            w.click();
        }

        //Using lambda is recommended
        emojis.forEach(WebElement::click);

        //Get out of the iFrame
        driver.switchTo().defaultContent();

        //fill the form
        List<WebElement> inputs = driver.findElements(By.xpath("//input"));  //11 inputs
        List<String> words = new ArrayList<>(Arrays.asList("This", "iframe", "example", "looks",
                "really", "funny", "does", "not", "it",
                "?", "!"));

        for (int i = 0;  i < inputs.size(); i++) {

            inputs.get(i).sendKeys((words.get(i)));
        }

        //Click the apply button
        driver.findElement(By.xpath("//button[@id='send']")).click();

        //verify "code" elemnet is displayed
        WebElement code = driver.findElement(By.id("code"));
        assertTrue(code.isDisplayed());


        }

    }


