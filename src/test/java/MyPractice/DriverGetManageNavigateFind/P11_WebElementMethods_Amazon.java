package MyPractice.DriverGetManageNavigateFind;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P11_WebElementMethods_Amazon {

    //https://github.com/gokhanagar/Selenium/blob/master/seleniumGiris/src/test/java/day03_locators/C04_WebElementMethodlari.java

    public static void main(String[] args) {

            /*
    1- amazon.com'a gidip arama kutusunu locate edin
    2- arama kutusunun tagName'inin "input" oldugunu test edin
    3- arama kutusunun name attribute'nun degerinin "field-keywords" oldugunu test edin
    */


            System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            //got to amazon web page and locate it
            driver.get("https://www.amazon.com");

            //2- arama kutusunun tagName'inin input oldugunu test edin
            WebElement searchButton = driver.findElement(By.id("twotabsearchtextbox"));

            String expectedTagName = "input";
            String actualTagName = searchButton.getTagName();

            if(expectedTagName.equals(actualTagName)) {
                System.out.println("TagName test passed!");
            } else {
                System.out.println("TagName test does not passed!");
            }


            // 3- arama kutusunun name attribute'nun degerinin field-keywords oldugunu test edin
            String expectedNameAttribute = "field-keywords";
            String actualNameAttribute = searchButton.getAttribute("name");

            if(expectedNameAttribute.equals(actualNameAttribute)) {
                System.out.println("name attribute test passed!");
            } else {

                System.out.println("name attribute test does not passed!");
            }

            System.out.println("Height of search button: " + searchButton.getSize().getHeight());
            System.out.println("Width of search button: " + searchButton.getSize().getWidth());
            System.out.println("Size of search button: " + searchButton.getSize());
            System.out.println("Location of search button: " + searchButton.getLocation());

        }

}
