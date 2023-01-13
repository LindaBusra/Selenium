package MyPractice.DriverGetManageNavigateFind;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P06_ManageMethods2 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        //get the dimensions when it is maximize

        System.out.println("Position of maximize: " + driver.manage().window().getPosition());
        System.out.println("Size of maximize: " + driver.manage().window().getSize());

        driver.manage().window().fullscreen();
        //get the dimensions when it is fullscreen

        System.out.println("Position of fullscreen: " + driver.manage().window().getPosition());
        System.out.println("Size of fullscreen: " + driver.manage().window().getPosition());




    }
}
