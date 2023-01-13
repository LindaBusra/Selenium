package Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01AutomationExercises {

    WebDriver driver;
        /*
        Test Case 1: Register User
       1. Launch browser
       2. Navigate to url 'http://automationexercise.com'
       3. Verify that home page is visible successfully
       4. Click on 'Signup / Login' button
       5. Verify 'New User Signup!' is visible
       6. Enter name and email address
       7. Click 'Signup' button
       8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
       9. Fill details: Title, Name, Email, Password, Date of birth
       10. Select checkbox 'Sign up for our newsletter!'
       11. Select checkbox 'Receive special offers from our partners!'
       12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
       13. Click 'Create Account button'
       14. Verify that 'ACCOUNT CREATED!' is visible
       15. Click 'Continue' button
       16. Verify that 'Logged in as username' is visible
       17. Click 'Delete Account' button
       18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */


    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void test() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");


        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.cssSelector("#slider-carousel"));

        if (homePage.isDisplayed()) {
            System.out.println("HomePage test is passed");
        } else {
            System.out.println("HomePage test is failed.");
        }


        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();


        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignup = driver.findElement(By.xpath("//div[@class='signup-form']"));

        if (newUserSignup.isDisplayed()) {
            System.out.println("New User Signup test is passed");
        } else {
            System.out.println("New User Signup test is failed");
        }


        //6-Enter name and email address
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys("username");

        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("yyyy@gmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();



            //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible

            String expectedUrl = "https://automationexercise.com/signup";
            if (driver.getCurrentUrl().equals(expectedUrl)) {

                System.out.println("Enter Account Information testing passed!");

            } else {  System.out.println("Enter Account Information testing failed!");  }

            //9. Fill details: Title, Name, Email, Password, Date of birth

            driver.findElement(By.id("id_gender2")).click();        //gender

            WebElement userName = driver.findElement(By.id("name"));
            userName.clear();
            userName.sendKeys("name");


            WebElement userPassWord = driver.findElement(By.id("password"));
            userPassWord.sendKeys("passwords");

            WebElement date = driver.findElement(By.id("days"));
            date.click();
            date.sendKeys("3");

            WebElement month = driver.findElement(By.id("months"));
            month.click();
            month.sendKeys("December");

            WebElement year = driver.findElement(By.id("years"));
            year.click();
            year.sendKeys("1975");


            //10. Select checkbox 'Sign up for our newsletter!'
            WebElement checkbox1 = driver.findElement(By.id("newsletter"));
            checkbox1.click();
            //11. Select checkbox 'Receive special offers from our partners!'
            WebElement checkbox2 = driver.findElement(By.id("optin"));
            checkbox2.click();

            //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

            WebElement firstName = driver.findElement(By.id("first_name"));
            firstName.sendKeys("L. Busra");

            WebElement lastName = driver.findElement(By.id("last_name"));
            lastName.sendKeys("Berg");

            WebElement company = driver.findElement(By.id("company"));
            company.sendKeys("SVV");

            WebElement address1 = driver.findElement(By.id("address1"));
            address1.sendKeys("Haraldsgata");

            WebElement address2 = driver.findElement(By.id("address1"));
            address2.sendKeys("Oslo");

            WebElement country = driver.findElement(By.id("country"));
            country.click();
            country.sendKeys("Canada");

            WebElement state = driver.findElement(By.id("state"));
            state.sendKeys("Oslo");

            WebElement city = driver.findElement(By.id("city"));
            city.sendKeys("Oslo");

            WebElement zipcode = driver.findElement(By.id("zipcode"));
            zipcode.sendKeys("5588");

            WebElement mobileNumber = driver.findElement(By.id("mobile_number"));
            mobileNumber.sendKeys("1122334455");

            //13. Click 'Create Account button'
            WebElement createAccountButton = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
            createAccountButton.click();


            //14. Verify that 'ACCOUNT CREATED!' is visible
            WebElement accountCreated = driver.findElement(By.xpath("//h2[@data-qa='account-created']"));

            if (accountCreated.isDisplayed()) {

                System.out.println("Account Created test passed!");
            } else    System.out.println("Account Created test failed!");


            //15. Click 'Continue' button
            WebElement continueButton = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
            continueButton.click();



        //16. Verify that 'Logged in as username' is visible
        WebElement loggedInAsUsername = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[9]/a"));
        if (loggedInAsUsername.isDisplayed()) {
            System.out.println("Logged in as username test passed");
        } else System.out.println("Logged in as username test failed");


        //17. Click 'Delete Account' button
        WebElement deleteAccount = driver.findElement(By.xpath("//a[@href='/delete_account']"));
        System.out.println("it is working");
        deleteAccount.click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String urlForAccountDeletedPage ="https://automationexercise.com/delete_account";

        if (driver.getCurrentUrl().equals(urlForAccountDeletedPage)) {
            System.out.println("Account deleted test passed!");
        } else System.out.println("Account deleted test failed!");




        driver.close();
        }

    }





