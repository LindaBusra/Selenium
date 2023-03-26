package MyPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class not extends TestBase {



    @Before
    public void setUp(){

        //after updating i Chrome I added the first line !!!!!
        System.setProperty("webdriver.http.factory", "jdk-http-client");  //after updating i chrome I added it
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
}
