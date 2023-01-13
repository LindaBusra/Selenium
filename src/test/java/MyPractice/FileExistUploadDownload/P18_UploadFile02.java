package MyPractice.FileExistUploadDownload;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P18_UploadFile02 extends TestBase {

    /*
    http://webdriveruniversity.com/File-Upload/index.html

Choose a fileto upload
Click on the 'Submit' button.
Verify

     */


    @Test
    public void test() {

        //1. go to “http://webdriveruniversity.com/File-Upload/index.html”
        driver.get("http://webdriveruniversity.com/File-Upload/index.html");


        //find locator for chooseFile button
        WebElement chooseFile = driver.findElement(By.id("myFile"));

        // select file to upload
        String filePath = System.getProperty("user.home") + "\\Downloads\\LambdaTest.txt";
        chooseFile.sendKeys(filePath);

        //click submit button
        driver.findElement(By.xpath("//input[@onclick='fileSubmitted()']")).click();

        //accept allert
        driver.switchTo().alert().accept();

        //verify
        WebElement actualText = driver.findElement(By.xpath("//h1[text()='File Upload']"));
        String expectedText = "File Upload";
        Assert.assertTrue(expectedText.equals(actualText.getText()));

    }
}