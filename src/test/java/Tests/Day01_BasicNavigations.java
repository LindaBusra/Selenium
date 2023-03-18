package Tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_BasicNavigations {
    /*
    Create a new class under : BasicNavigations
    Create main method
    Set Path
    Create chrome driver
    Maximize the window
    Open google home page https://www.walmart.com/.
    On the same class, Navigate to amazon home page https://www.amazon.com/
    Navigate back to google
    Navigate forward to amazon
    Refresh the page
    Close/Quit the browser
     */

    public static void main(String[] args) {

        //Step 1: Set up
        System.setProperty("webdriver.chrome.driver", "./src/resources/drivers/chromedriver.exe");


        //Step 2: Create
        WebDriver driver = new ChromeDriver();

        //Step 3: Write test scripts
        //Maximize the window
        driver.manage().window().maximize();

        //Open google home page https://www.walmart.com/.
        driver.get("https://www.walmart.com/");

        //On the same class, Navigate to amazon home page https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        //Navigate back to Walmart
        driver.navigate().back();

        //Navigate forward to amazon
        driver.navigate().forward();

        //Refresh the page
        driver.navigate().refresh();

        //Close/Quit the browser
        //driver.close();
        driver.quit();

        //driver.quit()-->we may have multiple windows. with quit all of those browsers closed.
        driver.close();     //it closes only active/last window.


    }
}
