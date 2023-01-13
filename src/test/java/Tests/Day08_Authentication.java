package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day08_Authentication extends TestBase {

    /*
    Auth are used for security reason
    One way to auth is to use below syntax:
    https://username:password@URL
        username : admin
        password : admin
    url : the-internet.herokuapp.com/basic_auth  -->We use special url for authentication

    URL FOR AUTH:
    https://admin:admin@the-internet.herokuapp.com/basic_auth
    driver.get(“https://admin:admin@the-internet.herokuapp.com/basic_auth”);
    This will auth the page
     */

    @Test
    public void test(){

        //this will do authentication
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        String successMessage = driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(successMessage.contains("Congratulations! You must have the proper credentials."));


    }
}
