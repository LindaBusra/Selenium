package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Day02_GetPageSource {

    public static void main(String[] args) {

    /*
    //getPageSource() returns page source code as a string
    //We might use this to verify if a certain text exist in the entire page
    //Note that pageSource is not used a lot to do assertions
    //Because it is too general and can lead false result

    TEST CASE:
    Test if amazon contains “Registry” on the homepage
    Create a new class : GetPageSource
     */


        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        //Go to Amazon webside
        driver.get("https://amazon.com/");

        //Test if amazon contains “Registry” on the homepage
        String pageSource = driver.getPageSource();
        String expectedWord = "Registry";

        if(pageSource.contains(expectedWord)) {

            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
            System.out.println("Page Source: " + pageSource);
            System.out.println("Expected word: " + expectedWord);
        }


        driver.quit();
    }
}
