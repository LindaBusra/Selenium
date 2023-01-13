package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day10_FileUploadTest extends TestBase {

    /*
Class Name: FileUploadTest
Method Name: fileUploadTest
When user goes to https://the-internet.herokuapp.com/upload
When user selects an image from the desktop
And click on the upload button
Then verify the File Uploaded! Message displayed
     */

    @Test
    public void test(){

        //When user goes to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");
        //1.locate choose file and click choose file.
        //<input   type="file">   --> input type is file.  use sendkeys instead of click

        //When user selects an image from the desktop
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));


        //2.select a file from your computer
        //When user selects an image from the desktop
        String pathFile = System.getProperty("user.home") + "\\Downloads\\image (5).png";


        //And click on the upload button, sending the path of the file that I want to upload
        //we can use sendkeys cause the input type file combination
        chooseFileButton.sendKeys(pathFile);

        driver.findElement(By.id("file-submit")).click();

        //Then verify the File Uploaded! Message displayed
        WebElement fileUploaded = driver.findElement(By.xpath("//*[text()='File Uploaded!']"));
        Assert.assertTrue(fileUploaded.isDisplayed());

        //or
        boolean isEqual = driver.findElement(By.xpath("//h3")).getText().equals("File Uploaded!");
        Assert.assertTrue(isEqual);

        /*
        How do you upload a file with selenium
        -First selenium has limitation automation of files. But file upload can be done with selenium.
        -We locate the choose file button then use sendkeys function to send the path of the file.
        -Then we click upload button to upload the file.
        -Path of the file should be dynamic -use System.getProperty("home");

        LIMITATION:
        Selenium has limitation automation DESKTOP APPS
        For example, we can not find path of files, or verify if file exists on out machines with selenum
        Instead we use java File libraries
         */

    }
}
