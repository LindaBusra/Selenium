package Practices.practice04;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class Q5 extends TestBase {
    /*
    //Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
    //Fill the username, password and textArea comment:
    //Choose a file and upload it
    //Select checkbox, radio item and dropdowns
    //Click on submit
    //Verify that uploaded file name is on the Form Details.
     */

    @Test
    public void test(){

    //Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
    driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

    Faker faker = new Faker();
    //Fill the username, password and textArea comment:
    driver.findElement(By.xpath("//input[@name='username']")).sendKeys(faker.name().username());
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys(faker.internet().password());
    WebElement comment = driver.findElement(By.xpath("//*[.='Comments...']"));
    comment.clear();
    comment.sendKeys("text");

    //Choose a file and upload it

        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory + "\\Desktop\\logo.jpeg";
        driver.findElement(By.xpath("//input[@name='filename']")).sendKeys(filePath);


    //Select checkbox, radio item and dropdowns

        WebElement checkBox1 = driver.findElement(By.xpath("//input[@value='cb1']"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@value='cb2']"));
        WebElement checkBox3 = driver.findElement(By.xpath("//input[@value='cb3']"));

        if(!checkBox1.isSelected()){
            checkBox1.click();
        }
        if(!checkBox2.isSelected()){
            checkBox2.click();
        }
        if(!checkBox3.isSelected()){
            checkBox3.click();
        }


        driver.findElement(By.xpath("//input[@value='rd1']")).click();//Radio Button 1

        WebElement dropDown = driver.findElement(By.name("multipleselect[]"));
        Select select = new Select(dropDown);
        select.deselectAll();
        driver.findElement(By.xpath("//select[@name='multipleselect[]']//option[2]")).click();//Option 2



        //Click on submit
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        //Verify that uploaded file name is on the Form Details.
        String message = driver.findElement(By.xpath("//*[text()='Submitted Values']")).getText();
        Assert.assertTrue(message.contains("You submitted a form."));


    }
}
