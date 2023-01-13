package MyPractice.DriverGetManageNavigateFind;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P05_Navigate01 {

    public static void main(String[] args) throws InterruptedException {

        /*
         If we are going to move back and forward between multiple pages during our test
         Instead of driver.get() we use the driver.navigate().to() method and then forward(),
         We can use back(), or refresh() methods
          */

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(2000);

        driver.navigate().to("https://www.facebook.com");
        Thread.sleep(2000);

        //go to amazon again
        driver.navigate().back();
        Thread.sleep(2000);

        //go to facebook again
        driver.navigate().forward();
        Thread.sleep(2000);

        //refresh tha page
        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.close();



    }
}
