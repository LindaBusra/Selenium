package Practices.practice02;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Q01 extends TestBase {

    /*
    /*
    Given
         Go to url : https://phptravels.com/demo/
    When
         Fill the form
    And
         Click on 'SUBMIT'
    Then
         Assert that the form has been sent
     */


    @Test
    public void test() throws InterruptedException {

        driver.get("https://phptravels.com/demo/");

        //Fill the form
        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//input[@name='business_name']")).sendKeys(faker.name().title());
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(faker.company().name());


        int number1 = Integer.parseInt(driver.findElement(By.id("numb1")).getText());
        int number2 = Integer.parseInt(driver.findElement(By.id("numb2")).getText());
        String result = number1+number2+"";

        driver.findElement(By.id("number")).sendKeys(result);

        //Click on 'SUBMIT'
        driver.findElement(By.id("demo")).click();

        //Assert that the form has been sent
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement thankYou = driver.findElement(By.xpath("//strong[.=' Thank you!']"));
        Thread.sleep(2000);  //if there is a problem with loading
        assertTrue(thankYou.isDisplayed());


    }
}
