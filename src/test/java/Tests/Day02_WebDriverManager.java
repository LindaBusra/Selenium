package Tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Day02_WebDriverManager {


    public static void main(String[] args) {

        //System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver");
        //We no longer need to use System.setProperty. We can use WebDriverManager API
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //REST IS THE SAME
        //Create driver

        WebDriver driver = new ChromeDriver(options);
        //maximize
        driver.manage().window().maximize();
        //going to the page
        driver.get("https://www.techproeducation.com");
        //close
        driver.quit();
    }
}