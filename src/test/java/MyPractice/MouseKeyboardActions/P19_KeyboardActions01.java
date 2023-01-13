package MyPractice.MouseKeyboardActions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P19_KeyboardActions01 extends TestBase {


    @Test
    public void test(){

        driver.get("https://www.amazon.com");


        // once arama kutusuna click yapip
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));


        // sonra harf harf nutella yazisini yazdiralim sonrada enter tusuna basalim
        Actions actions = new Actions(driver);
        actions.click(searchBox).
                sendKeys("n").
                sendKeys("u").
                sendKeys("t").
                sendKeys("e").
                sendKeys("l").
                sendKeys("l").
                sendKeys("a").
                sendKeys(Keys.ENTER).perform();
    }

}
