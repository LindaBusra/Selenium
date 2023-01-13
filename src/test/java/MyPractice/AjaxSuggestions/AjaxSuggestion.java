package MyPractice.AjaxSuggestions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class AjaxSuggestion extends TestBase {


    @Test
    public void test(){

/*
Practice Exercise - Get all the options displayed in Google auto suggestion box and print them.

Test Steps:
Launch the Chrome.
Open URL - http://www.google.com
Enter keyword "selenium tutorial techlistic" in search bar
Wait for ajax suggestion box to appear
Get/store all the options of suggestion box in a list
Print all the suggestions one by one.
You can also click on any of the suggestions using the click() command.
 */

        //Open URL - http://www.google.com
        driver.get("http://www.google.com");
        driver.findElement(By.xpath("//div[text()='Reject all']")).click();

        //Enter keyword "selenium tutorial techlistic" in search bar
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium tutorial techlistic", Keys.ENTER);

        //Wait for ajax suggestion box to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("sbtc")));  //<li data-view-type="1" class="sbct" id="YMXe" role="presentation"><div class="eIPGRd"><div class="sbic"></div><div class="pcTkSc" role="option"><div class="wM6W7d"><span></span></div><div class="ClJ9Yb"><span></span></div></div><div class="AQZ9Vd"><div class="sbai">Sil</div></div></div></li>

        //Get/store all the options of suggestion box in a list
        WebElement list = driver.findElement(By.className("sbtc"));
        List<WebElement> rows = list.findElements(By.tagName("li"));
        System.out.println(rows.size());

        //Print all the suggestions one by one.
        for(WebElement w: rows) {
            System.out.println(w.getText());
        }
        //You can also click on any of the suggestions using the click() command.

    }
}
