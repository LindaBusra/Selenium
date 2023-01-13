package MyPractice.DriverGetManageNavigateFind;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P02_FirstTest01 {

    /*
         1- Go to https://www.amazon.com url
         2- Test if the title contains the word Amazon.
         3- Test that the url is equal to "https://www.amazon.com"
         4-close page
          */

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1- Go to https://www.amazon.com url
        driver.get("https://www.amazon.com");


        //2- Test if the title contains the word Amazon.
        String actualTitle =  driver.getTitle();
        String word = "Amazon";

        if(actualTitle.contains(word)) {
            System.out.println("Title test passed!");
        } else {
            System.out.println("Title does not contains : " + word + " Test failed!");
        }


        //3- Test that the url is equal to "https://www.amazon.com"
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";

        if (actualUrl.equals(expectedUrl)) {

            System.out.println("Url Test passed!");
        } else {
            System.out.println("Url does not contains " + expectedUrl + " Test failed!");
        }


        //4-close page
        driver.close();

    }



}
