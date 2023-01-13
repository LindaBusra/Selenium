package MyPractice.DriverGetManageNavigateFind;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class P04_GetAllLinks {

    @Test
    public void test() {


        // Initialize Webdriver Object (Update your system's path)
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Open the webpage.
        driver.get("https://phptravels.com/demo/");

        // Store all link elements (anchor tag elements in html) in a list
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Print no. of links stored in list
        System.out.println(links.size());

        for (int i = 0; i < links.size(); i++) {

            // Print text of all the links
            System.out.println(links.get(i).getText());
        }

        /*
        Code Explanation:
    1. Open the webpage.
    2. Create a list of type WebElements' and store all elements with tagname 'a' in it using 'findElements()'
    3. Iterate over all the links using list size as it's maximum value.
    4. Get the text of the link by using getText() and print it.
         */



        //Selenium Code to find broken links on a Webpage:
        //https://www.techlistic.com/2020/03/selenium-webdriver-get-all-page-links.html
    }
}