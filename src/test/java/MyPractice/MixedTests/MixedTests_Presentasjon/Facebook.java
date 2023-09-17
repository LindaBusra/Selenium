package MyPractice.MixedTests;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Facebook extends TestBase {



//Go to the facebook homepage "https://www.facebook.com"
//click on "Create a New Account"
//First locate the firstname box and then fill the form by switching the boxes with the TAB button and finally click on Sign Up
//I used faker class to get the fake data


    @Test
    public void test(){

        //Go to the facebook homepage "https://www.facebook.com"
        driver.get("https://www.facebook.com");

        try{
            driver.findElement(By.xpath("//*[@data-testid='cookie-policy-manage-dialog-accept-button']")).click();
        } catch(Exception e){

        }


        //click on "Create a New Account"
        driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();



        //First locate the firstname box and then fill the form by switching the boxes with the TAB button and finally click on Sign Up
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));


        Faker faker = new Faker();

        Actions actions = new Actions(driver);
        actions.click(firstName)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys("+4748900008")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("10")
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys("2010")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();



    }
}
