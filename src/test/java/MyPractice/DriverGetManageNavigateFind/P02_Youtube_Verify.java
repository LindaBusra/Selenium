package MyPractice.DriverGetManageNavigateFind;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class P02_Youtube_Verify {


    public static void main(String[] args) {

    /*   Question1
        1.https://www.youtube.com sayfasına gidin
        2.Title i consolda yazdirin
        3.Title “YouTube” a eşitse “correct title” yazdirin değilse “incorrect title yzdirin”
        4.Sayfayi kapatin
        5.Tum sayfalari kapatin
        6.Consola “Test completed” yazdirin   */


        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));




        // 1.
        driver.get("https://www.youtube.com");
        //2.
        System.out.println(driver.getTitle());

        //3.

        String actuelTitle=driver.getTitle();
        String exceptedResult="YouTube";

        if (actuelTitle.equals(exceptedResult)) {
            System.out.println("correct title");
        } else {
            System.out.println("incorrect title");
        }

        //4.

        driver.close();

        // 5.

        driver.quit();

        // 6.

        System.out.println("Test Completed");



    }
}