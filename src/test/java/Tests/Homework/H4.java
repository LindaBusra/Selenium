package Tests.Homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class H4 extends TestBase {

    // When user goes to https://jqueryui.com/autocomplete/
    // And type Apple
    // Then select Applescript

    @Test
    public void test(){

    driver.get("https://jqueryui.com/autocomplete/");

    driver.switchTo().frame(0);
    driver.findElement(By.id("tags")).sendKeys("Apple", Keys.ENTER);

    driver.findElement(By.xpath("//div[text()='AppleScript']")).click();
    }
}
