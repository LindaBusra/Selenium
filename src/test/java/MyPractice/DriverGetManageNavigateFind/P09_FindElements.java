package MyPractice.DriverGetManageNavigateFind;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P09_FindElements {

    public static void main(String[] args) {

    // print how many links there are on the amazon page

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://www.amazon.com");

        List<WebElement> linkList = driver.findElements(By.tagName("a"));

        System.out.println("The number of link in the page: " + linkList.size());
        driver.close();


        /*
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder=""
        class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search">
         */


    }
}
