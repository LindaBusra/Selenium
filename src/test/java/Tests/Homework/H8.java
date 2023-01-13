package Tests.Homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class H8 extends TestBase {

    /*
        //User goes ebay.com
    //Then clicks Electronics
    //Then click every photos which has width='225' and height='225 and print Title of page
    //Then close
     */

    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.ebay.com/");

        // Click Electronics
        WebElement element = driver.findElement(By.linkText("Electronics"));
        element.click();

        // Find photos with width = 225 and height = 225
        List<WebElement> photos1 = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));

        // Iterate through photos and print the title of the page

        for (int i = 0; i < photos1.size(); i++) {
            List<WebElement> photos = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            photos.get(i).click();
            System.out.println(driver.getTitle());
            Thread.sleep(1000);
            driver.navigate().back();
        }
    }



    }

