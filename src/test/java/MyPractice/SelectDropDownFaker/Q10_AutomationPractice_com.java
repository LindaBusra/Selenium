package MyPractice.SelectDropDownFaker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Q10_AutomationPractice_com extends TestBase {

    /*
    1. Test Case - Automate User Registration process of e-commerce website.
    Steps to Automate:
    1. Open this url  http://automationpractice.com/index.php
    2. Click on sign in link.
    3. Enter your email address in 'Create and account' section.
    4. Click on Create an Account button.
    5. Enter your Personal Information, Address and Contact info.
    6. Click on Register button.
    7. Validate that user is created.
     */


    @Test
    public void test1() {


        //1. Open this url  http://automationpractice.com/index.php
        driver.get("http://automationpractice.com/index.php");

        //Click on Sign in
        driver.findElement(By.linkText("Sign in")).click();

        //Enter email address
        driver.findElement(By.cssSelector("[name='email_create']")).sendKeys("test1249@test.com");

        //Click on "Create an account"
        driver.findElement(By.xpath("//button[@name=\"SubmitCreate\"]")).click();

        //Select Title
        driver.findElement(By.xpath("//input[@id=\"id_gender1\"]")).click();
        driver.findElement(By.name("customer_firstname")).sendKeys("Test User");
        driver.findElement(By.name("customer_lastname")).sendKeys("Vsoft");
        driver.findElement(By.id("passwd")).sendKeys("PKR@PKR");

        // Enter your address
        driver.findElement(By.id("firstname")).sendKeys("Test User");
        driver.findElement(By.id("lastname")).sendKeys("Vsoft");
        driver.findElement(By.id("company")).sendKeys("Vsoft");
        driver.findElement(By.id("address1")).sendKeys("Test 81/1,2nd cross");
        driver.findElement(By.id("city")).sendKeys("XYZ");

        // Select State
        WebElement statedropdown = driver.findElement(By.name("id_state"));
        Select oSelect = new Select(statedropdown);
        oSelect.selectByValue("4");

        driver.findElement(By.name("postcode")).sendKeys("51838");

        // Select Country
        WebElement countrydropDown = driver.findElement(By.name("id_country"));
        Select oSelectC = new Select(countrydropDown);
        oSelectC.selectByVisibleText("United States");

        //Enter Mobile Number
        driver.findElement(By.id("phone_mobile")).sendKeys("234567890");
        driver.findElement(By.xpath("//input[@name=\"alias\"]")).clear();
        driver.findElement(By.xpath("//input[@name=\"alias\"]")).sendKeys("Office");
        driver.findElement(By.name("submitAccount")).click();
        String userText = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();

        // Validate that user has created
        if (userText.contains("Vsoft")) {
            System.out.println("User Verified,Test case Passed");
        } else {
            System.out.println("User Verification Failed,Test case Failed");
        }
    }  }