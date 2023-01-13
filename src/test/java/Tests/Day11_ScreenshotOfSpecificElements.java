package Tests;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class Day11_ScreenshotOfSpecificElements extends TestBase {


    /*
        With Selenium 4, we can even take the screenshots of specific elements
        WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
        File file = logo.getScreenshotAs(OutputType.FILE);
        File destFile = new File("logo.png");
        FileUtils.copyFile(file, destFile);          */

    /*Getting Screenshot Task

    Acceptance Criteria:
    When user goes to the application home page(techproeducation)
    Then verify the logo of techpro education is displayed
     */


    @Test
    public void test() throws IOException {

        //When user goes to the application home page(techproeducation)

        driver.get("https://www.techproeducation.com");
        WebElement techProEdLogo = driver.findElement(By.xpath("//div[@data-id='898ce2e']"));

        //verifying the logo
        Assert.assertTrue(techProEdLogo.isDisplayed());

        //getting the screenshot using reusable method
        takeScreenshotOfTheElement(techProEdLogo);

        //taking screenshot of social media icons
        WebElement socialMedia = driver.findElement(By.id("d7545f2"));
        takeScreenshotOfTheElement(socialMedia);


    }


}
