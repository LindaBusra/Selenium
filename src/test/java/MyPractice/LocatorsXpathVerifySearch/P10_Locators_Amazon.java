package MyPractice.LocatorsXpathVerifySearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P10_Locators_Amazon {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.Step: go to webside:
        driver.get("https://www.amazon.com");

        // findElement(By .... locator) --> it gives us the web element which we want.
        // We assign this webElement to an object

        //2.Step: Press the sign button
        WebElement singInLink = driver.findElement(By.linkText("Sign in"));
        singInLink.click();

        //3.Step: Locate these elements: email textbox,password textbox, and signin button elements
        //4. Step: Enter the username and password and click the sign in button:
        WebElement emailTextBox = driver.findElement(By.id("ap_email"));        //<input type="email" maxlength="128" id="ap_email" name="email" tabindex="1" class="a-input-text a-span12 auth-autofocus auth-required-field">

        emailTextBox.sendKeys("linda.busra.berg@gmail.com");

        WebElement singInButon = driver.findElement(By.id("continue"));         //<input id="continue" tabindex="5" class="a-button-input" type="submit" aria-labelledby="continue-announce">
        singInButon.click();

        WebElement passwordTextBox = driver.findElement(By.id("ap_password"));   //<input type="password" maxlength="1024" id="ap_password" name="password" tabindex="2" class="a-input-text a-span12 auth-autofocus auth-required-field">

        passwordTextBox.sendKeys("Amazon1234");

        WebElement singInButon2 = driver.findElement(By.id("signInSubmit"));
        singInButon2.click();



        //5.Step: Verify that the expected user id is .....   (Hello, LindaB)
        WebElement actualUserName = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        System.out.println(actualUserName.getText());

        String expectedUserName ="Hello, LindaB";

        if(expectedUserName.equals(actualUserName.getText())) {
            System.out.println("Expected user test passed");
        } else {
            System.out.println("Expected user test failed!");
        }


        //Verify that the “Sell” and “Today's Deals” texts are displayed.

        WebElement sellElement =  driver.findElement(By.linkText("Sell"));

        if(sellElement.isDisplayed()) {

            System.out.println("Sell test passed");
        } else {
            System.out.println("Sell test does not passed");
        }


        WebElement todaysDeals = driver.findElement(By.linkText("Today's Deals"));          //data-csa-c-type="link":if it uses like this, we can use linkText

        if(todaysDeals.isDisplayed()) {

            System.out.println("Today's Deals test passed");
        } else {
            System.out.println("Today's Deals test does not passed");
        }


        //Find the number of links in this webside
        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        System.out.println("The number of links : " + linkList.size());

        //Because our list consists of webElements, if we print direct, it  prints references.
        //instead we should make a for-each loop and print the text above each link webelement

        // print the links
        for(WebElement w:linkList) {
            System.out.println(w.getText());
        }


//        driver.close();
    }
}
