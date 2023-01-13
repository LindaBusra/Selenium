package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {

    public static void main(String[] args)  {

        //En ilkel haliyle bir otomasyon yapmak icin Class'imiza otomasyon icin gerekli olan webdirever'in yolunu gostermemiz gerekir

        /* To make an automation :
         We need to show our class the location of the webdriver required for automation
         For this, we use the System.setProperty() method from the Java library.
         method requires 2 parameters
         The first is the driver we will use: webdriver.chrome.driver
         the second is the physical path of this driver:   */


        // 1. Set Up Chrome Driver

        //System.setProperty("Driver", "Path of the driver");        //   ./ is giving mer clean path
        System.setProperty("webdriver.chrome.driver", "./src/resources/drivers/chromedriver.exe");

        // 2. Create Chrome Driver
        WebDriver driver = new ChromeDriver();


        // 3. Now that we created webdriver, we can automate web application
        driver.get("https://www.google.com");



    }
}
