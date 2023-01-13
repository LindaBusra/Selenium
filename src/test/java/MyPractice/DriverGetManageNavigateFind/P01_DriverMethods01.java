package MyPractice.DriverGetManageNavigateFind;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P01_DriverMethods01 {


    public static void main(String[] args)  {

        //We need to show our class the location of the webdriver required for automation
        //The first is the driver we will use: webdriver.chrome.driver
        //the second is the physical path of this driver:

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        System.out.println("actual title: " + driver.getTitle());
        System.out.println("actual url: " + driver.getCurrentUrl());

        driver.close();





    }








}
