package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Day05_RadioButton01 {

/*
https://testcenter.techproeducation.com/index.php?page=radio-buttons
Click on Red
Click on Football
Verifying the red radio button is selected
Verifying the football button is selected       */


    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=radio-buttons");

    }


@Test
    public void radioTest(){

    //select red
    WebElement redOption = driver.findElement(By.id("red"));
    redOption.click();

    //Verifying the red radio button is selected
    Assert.assertTrue(redOption.isSelected());

    //select football
    WebElement footballOption = driver.findElement(By.id("football"));
    footballOption.click();

    //Verifying the football button is selected
    Assert.assertTrue(footballOption.isSelected());

}

    @After
    public void tearDown(){
        driver.quit();
}

}
