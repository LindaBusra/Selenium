package MyPractice.ScreenShots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot01 {


    @Test
    public void getScreenshotTest() throws IOException, InterruptedException {

        //Creating selenium driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Maximizing the window
        driver.manage().window().maximize();

        //Going to the google page
        driver.get("https://www.google.com");

        //Getting the image of the google logo and saving it
        WebElement logo = driver.findElement(By.xpath("//div[@class='k1zIA rSk4se']"));
        File logoFile = logo.getScreenshotAs(OutputType.FILE);
        File logoDestFile = new File("googleLogo.png");
        FileUtils.copyFile(logoFile, logoDestFile);
        System.out.println("Getting the image of the google logo test passed");

        //accept cookies
        WebElement acceptAll = driver.findElement(By.id("L2AGLb"));
        acceptAll.click();
        Thread.sleep(2000);

        //Getting the screenshot of sign in button
        WebElement signInButton = driver.findElement(By.xpath("//a[@class='gb_7 gb_8 gb_de gb_dd']"));
        File signInButtonFile = signInButton.getScreenshotAs(OutputType.FILE);

        File signInButtonDestFile = new File("signInButton.png");
        FileUtils.copyFile(signInButtonFile, signInButtonDestFile);
        System.out.println("Getting the screen shot of sign in button test passed");

        driver.close();


    }
}
