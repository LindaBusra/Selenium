package Practices.practice05;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q3_actions_facebook extends TestBase {

    /*
    Given
        Go to https://www.facebook.com/
    When
        Click on "Create New Account"
    And
        Fill all the boxes by using keyboard actions class
     */


    @Test
    public void test()  {

       //Go to https://www.facebook.com/
        driver.get("https://www.facebook.com/");

        waitForClickability(driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")), 5).click();

       //Click on "Create New Account"
        driver.findElement(By.linkText("Create New Account")).click();


        //Fill all the boxes by using keyboard actions class
        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        WebElement firstname= driver.findElement(By.name("firstname"));

        actions       //as default it is in firstname, so we dont need to use   click(firstname)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys("+4745680882")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("10")
                .sendKeys(Keys.TAB)
                .sendKeys("April")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)   //male
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .build().perform();



                /*

                        Select select = new Select(ayElementi);
        select.selectByIndex(faker.number().numberBetween(1, 13)); //int number
        Select select1 = new Select(gunElementi);
        select1.selectByIndex(faker.random().nextInt(1, 30));
        Select select2 = new Select(yilElementi);
        select2.selectByIndex(faker.random().nextInt(1, 120));

                 */



    }
}
