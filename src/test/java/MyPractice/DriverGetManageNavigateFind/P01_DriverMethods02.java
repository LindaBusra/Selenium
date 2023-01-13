package MyPractice.DriverGetManageNavigateFind;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P01_DriverMethods02 {

    public static void main(String[] args) throws InterruptedException {

        // ...Exercise1...
        // Create a new class under Q1 create main method
        // Set Path
        // Create chrome driver
        // Maximize the window
        // Open google home page https://www.google.com/.
        // On the same class, Navigate to amazon home page https://www.amazon.com/ Navigate back to google
        // Navigate forward to amazon
        // Refresh the page
        // Close/Quit the browser
        // And last step : print "all ok" on console


        System.setProperty("webdriver.chrome.driver" , "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
        Thread.sleep(2000);


        driver.navigate().to("https://www.google.com/");
        Thread.sleep(2000);

        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.navigate().refresh();

        driver.close();

        System.out.println("all OK!");


    }
}
