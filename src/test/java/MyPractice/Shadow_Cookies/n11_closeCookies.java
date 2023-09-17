package MyPractice.Shadow_Cookies;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class n11_closeCookies extends TestBase {


    @Test
    public void test() throws InterruptedException {


        //close cookies
        //Go to https://www.n11.com web page
        driver.get("https://www.n11.com");

        //it gets all elements and check if it is shadow root, and the result is true/false
        SearchContext searchContext = driver.findElement(By.xpath("//efilli-layout-dynamic")).getShadowRoot();

        //here we use instead of driver-->searchContext.findElement
        WebElement rejectButton = searchContext.findElement(By.id("7bc7d149-81f2-4e53-8178-a58a330da5fd"));
        rejectButton.click();
        Thread.sleep(2000);

    }
}