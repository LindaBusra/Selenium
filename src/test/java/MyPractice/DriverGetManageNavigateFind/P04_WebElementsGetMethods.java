package MyPractice.DriverGetManageNavigateFind;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P04_WebElementsGetMethods {

    public static void main(String[] args) {

        /*
        WebElement a = driver.findElement(By.id("toggleAccount"));
        a.isDisplayed();    Web element gorunur ise true doner
        a.isSelected();     Web element secili ise true doner
        a.isEnabled();      Web element erisilebilir ise true doner
         */



        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //go to link : https://www.jobbnorge.no/search
        driver.get("https://www.jobbnorge.no/search");

        //accept cookies
        driver.findElement(By.className("coi-banner__accept")).click();      //accept cookies


        //Find the number of links in this webside
        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        System.out.println("The number of links : " + linkList.size());



        //find job
        driver.findElement(By.id("js-autocomplete")).sendKeys("lærer" + Keys.ENTER);


        WebElement logInnButton = driver.findElement(By.id("toggleAccount"));

        System.out.println("size: " + logInnButton.getSize());
        System.out.println("text: " + logInnButton.getText());
        System.out.println("role: " + logInnButton.getAriaRole());
        System.out.println("accessible name: " + logInnButton.getAccessibleName());
        System.out.println("id attribute value: " + logInnButton.getAttribute("id"));
        System.out.println("location: " + logInnButton.getLocation());
        System.out.println("width : " + logInnButton.getRect().width);
        System.out.println("colour : " + logInnButton.getCssValue("color"));



        driver.close();

    }
}
