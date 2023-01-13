package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class Day02_VerifyTitleTest {

    public static void main(String[] args) {


/*


	1.Create a new class: VerifyTitleTest
	2.Navigate to techproeducation homepage
	3.Verify if google title is “Techpro Education | Online It Courses & Bootcamps”
*/

        System.setProperty("webdriver.chrome.driver", "./src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://techproeducation.com/");


        //get the title
        String actualTitle  = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";


        if(actualTitle.equals(expectedTitle))  {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
            System.out.println("Actual Title: " + actualTitle);
            System.out.println("Expected Title: " + expectedTitle);
        }

        driver.quit();








    }
}
