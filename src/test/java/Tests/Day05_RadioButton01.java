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

import java.time.Duration;

public class Day05_RadioButton01 {

    /*
    TEST CASE:https://testcenter.techproeducation.com/index.php?page=dropdown
Click on Create new account
Enter first name
Enter last name
Enter mobile number or email
Enter new password
Enter birthday(LATER)
Enter gender
Click Sign Up


https://testcenter.techproeducation.com/index.php?page=radio-buttons
Click on Red
Click on Football

//<input type="radio" id="red" name="color">
     */
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=radio-buttons");

    }


@Test
    public void radioTest(){

    //select red
    WebElement redOption = driver.findElement(By.id("red"));
    redOption.click();
    Assert.assertTrue(redOption.isSelected());  //Verifying the red radio button is selected

    //select football
    WebElement footballOption = driver.findElement(By.id("football"));
    footballOption.click();
    Assert.assertTrue(footballOption.isSelected()); //Verifying the football button is selected

    driver.quit();


}

@After
    public void tearDown(){
        driver.quit();
}

}
