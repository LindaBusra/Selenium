package MyPractice.DriverGetManageNavigateFind;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P03_GetPageSource {

    // go to the amazon site and test that the source code has "Gateway"

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://www.amazon.com");

        String pageSource = driver.getPageSource();
        String word = "Gateway";

        if(pageSource.contains(word)) {

            System.out.println("Source code is passed!");
        } else{
            System.out.println("Soruca code does not contains " + word + " .Test failed!");
        }


        driver.close();




    }

}
