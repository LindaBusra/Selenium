package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Day02_VerifyTitleTest {

    public static void main(String[] args) {


/*


	1.Create a new class: VerifyTitleTest
	2.Navigate to techproeducation homepage
	3.Verify if google title is “Techpro Education | Online It Courses & Bootcamps”
*/

        System.setProperty("webdriver.chrome.driver", "./src/resources/drivers/chromedriver.exe" );

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://techproeducation.com/");


        //get the title
        String actualTitle  = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";


        Assert.assertEquals(expectedTitle, actualTitle);
        System.out.println("test passed");


        //or
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
