package MyPractice.DriverGetManageNavigateFind;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P06_ManageMethods1 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        System.out.println("Size of window : " + driver.manage().window().getSize());           //Size of window : (945, 1012)
        System.out.println("Position of window: " + driver.manage().window().getPosition());    //Position of window: (10, 10)
        Thread.sleep(2000);

        //// change the position and size of the window
        driver.manage().window().setSize(new Dimension(900,600));
        driver.manage().window().setPosition(new Point(15,15));

        System.out.println("size of new window: " + driver.manage().window().getSize());
        System.out.println("position of new window: " + driver.manage().window().getPosition());

        driver.get("https://www.amazon.com");
        driver.close();










    }
}
