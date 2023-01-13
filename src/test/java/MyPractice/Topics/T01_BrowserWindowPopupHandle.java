package MyPractice.Topics;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

public class T01_BrowserWindowPopupHandle extends TestBase {

    @Test
    public void test(){

        // This code is to demonstrate how to handle model popup (Chat popup)
        // these model popup are not java script popup or browser window popup
        // so there is no method for it to handle driver.switch.alert() or driver.switchto.window()

        System.setProperty("webdriver.chrome.driver", "./src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://www.popuptest.com/goodpopups.html");
        driver.findElement(By.linkText("Good PopUp #1")).click();

        Set<String> handles =  driver.getWindowHandles();

        Iterator<String> it = handles.iterator();

        String parentWindowId = it.next();
        System.out.println("Parent Window ID is : " + parentWindowId);

        String childWindowId = it.next();
        System.out.println("Child Window Id is : " + childWindowId);

        driver.switchTo().window(childWindowId);

        System.out.println("Child Window Title is :" + driver.getTitle());
        driver.close();
        driver.switchTo().window(parentWindowId);
        System.out.println("Parent Window Title is :" + driver.getTitle());

    }

}