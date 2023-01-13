package MyPractice.MouseKeyboardActions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P19_KeyboardActions03 extends TestBase {


    //1- Bir Class olusturalim KeyboardActions3
    //2- https://html.com/tags/iframe/ sayfasina gidelim
    //3- video’yu gorecek kadar asagi inin
    //4- videoyu izlemek icin Play tusuna basin
    //5- videoyu calistirdiginizi test edin

    @Test
    public void test(){

        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN)
                .perform();
        System.out.println("1");

        //4- videoyu izlemek icin Play tusuna basin
        WebElement iframe = driver.findElement(By.xpath("//iframe[@ src='https://www.youtube.com/embed/owsfdh4gxyc']"));

        driver.switchTo().frame(iframe);
        System.out.println("2");

        driver.findElement(By.xpath("//button[@aria-label='Play']")).click();
        System.out.println("3");

        //5- videoyu calistirdiginizi test edin
        WebElement youtubeLink = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeLink.isDisplayed());
        System.out.println("4");

    }

}
