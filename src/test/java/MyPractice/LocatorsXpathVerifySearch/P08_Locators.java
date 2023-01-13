package MyPractice.LocatorsXpathVerifySearch;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P08_Locators {

    public static void main(String[] args) {

        /*
    * Locater yer bulucudur , git şuraya şunu bul şuna bas dememize yarar, 8 tane lokater çeşidi vardır.
    * id - name - className - tagName - linkTest(a href) - partialLinkTest - xpath - cssSelector
    * driver.findElement (By.id("twotabsearchtextbox"));  -- Bunu bir variable'a assign etmeliyiz.
    * Yanlış id kullanımında - NoSuchElementException hatası verir.
         */

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //got to Amazon and find wedding ring
        driver.get("https://www.amazon.com");

        // findElement(By .... locator) --> it gives us the web element which we want.
        // We assign this webElement to an object

        WebElement SearchBox = driver.findElement(By.name("field-keywords"));
        /*
        <input type="text" id="twotabsearchtextbox" value=""
        name="field-keywords" autocomplete="off" placeholder=""
        class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search">
         */

        //// if we want to send the text of webelement which we want
        SearchBox.sendKeys("wedding ring" + Keys.ENTER);



    }
}
