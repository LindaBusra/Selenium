package MyPractice.MixedTests;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.awt.*;

public class Q9_Techlistic extends TestBase {

    /*

Open this link - https://www.techlistic.com/p/selenium-practice-form.html
Enter first and last name (textbox).
Select gender (radio button).
Select years of experience (radio button).
Enter date.
Select Profession (Checkbox).
Select Automation tools you are familiar with (multiple checkboxes).
Select Continent (Select box).
Select multiple commands from a multi select box.
If you can handle Upload image then try it or leave this step.
Click on Download file link and handle the download file pop-up (leave it if you are beginner).
Click on Submit button.
Try your own logic and automate it without any help. If you still find it difficult to automate then follow reference links.
     */


    @Test
    public void test() throws AWTException {


        //Open this link - https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        driver.findElement(By.id("ez-accept-all")).click();

        //Enter first and last name (textbox).
        Faker faker = new Faker();
        WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);

        actions.click(firstname)
                                .sendKeys(faker.name().firstName())
                                .sendKeys(Keys.TAB)
                                .sendKeys(faker.name().lastName()).perform();

        //Select gender (radio button).
        driver.findElement(By.id("sex-1")).click();

        //Select years of experience (radio button).
        driver.findElement(By.id("exp-6")).click();

        //Enter date.
        driver.findElement(By.id("datepicker")).sendKeys("10.02.2012");

        //Select Profession (Checkbox).
        driver.findElement(By.id("profession-1")).click();

        //Select Automation tools you are familiar with (multiple checkboxes).
        driver.findElement(By.id("tool-2")).click();

        Robot robot = new Robot();
        robot.mouseWheel(5);

        //Select Continent (Select box).
        driver.findElement(By.id("continents")).click();
        driver.findElement(By.xpath("//option[text()='Europe']")).click();

        //Select multiple commands from a multi select box.
        driver.findElement(By.xpath("//option[text()='Navigation Commands']")).click();
        driver.findElement(By.xpath("//option[text()='Wait Commands']")).click();
        System.out.println("2");

        //If you can handle Upload image then try it or leave this step.
        WebElement chooseFile = driver.findElement(By.id("photo"));
        String filePath = System.getProperty("user.home") + "\\Downloads\\LambdaTest.txt";
        chooseFile.sendKeys(filePath);
        System.out.println("3");

        //Click on Download file link and handle the download file pop-up (leave it if you are beginner).
        driver.findElement(By.linkText("Click here to Download File")).click();
        System.out.println("4");

        //There is an advertisement here !!! I can not go forward :(
        driver.findElement(By.xpath("//span[(text()='Close']")).click();
        driver.navigate().back();
        System.out.println("5");


        // Click Submit
        driver.findElement(By.id("submit")).click();








    }


}
