package Tests.Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class H1 extends TestBase {

    //When user goes to https://jqueryui.com/accordion/
    //And user clicks on Section2 accordion
    //Verify the text contains “Sed non urna.”


    @Test
    public void test(){

        //When user goes to https://jqueryui.com/accordion/
        driver.get("https://jqueryui.com/accordion/");
        // And user moves the target element(Drag me to my target) in to  destination(Drop here)
        // We need to use Actions class to drag and drop

        //And user clicks on Section2 accordion
        //Elements are inside the iframe, so switch first
        driver.switchTo().frame(0);
        WebElement section2 = driver.findElement(By.id("ui-id-3"));

        Actions actions = new Actions(driver);
        actions.click(section2).perform();

        //Verify the text contains “Sed non urna.”
        WebElement text = driver.findElement(By.xpath("//p[contains(text(),'Sed non urna')] "));
        Assert.assertTrue(text.getText().contains("Sed non urna."));

    }
}
