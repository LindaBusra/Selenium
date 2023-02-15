package MyPractice.MixedTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ZeroBank extends TestBase {


    /*
        User goes http://zero.webappsecurity.com
        User fills the account infos and select to remember me checkbox and click the submit button
            Username: username
            Password: password
        Because of error go backward!!!!!!
        User goes into Online Banking Menu
        User checks account summary
        Save and print to console the credit card debt
        Then user goes transfer funds and make money transfer to credit card from saving account and submit
        Verify equality of CCard debt and payment amount on screen and click submit
        Verify to Success message "You successfully submitted your transaction." is displayed and submit
        User goes Online Statements and goes year 2009 records
        User downloads first record
        Set the path and verify to downloaded file is exists

     */


    @Test
    public void test() throws InterruptedException {

        //http://zero.webappsecurity.com/
        driver.get("http://zero.webappsecurity.com/");

        //User goes sign in
        driver.findElement(By.id("signin_button")).click();

        //Type username and password and select keep sign and click sign in
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");

        driver.findElement(By.id("user_remember_me")).click();
        driver.findElement(By.xpath("//input[@name='submit']")).click();



        driver.navigate().back();
        System.out.println("1");


        driver.findElement(By.xpath("//*[text()='Online Banking']")).click();
        System.out.println("2");


        driver.findElement(By.id("account_summary_link")).click();


        String ccardDebt = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[3]/div/table/tbody/tr[2]/td[3]")).getText();

        driver.findElement(By.id("transfer_funds_tab")).click();
        WebElement fromAccount = driver.findElement(By.id("tf_fromAccountId"));
        Select select1 = new Select(fromAccount);
        select1.selectByValue("3");
        WebElement toAccount = driver.findElement(By.id("tf_toAccountId"));
        Select select2 = new Select(toAccount);
        select2.selectByValue("5");

        String payment = ccardDebt.replaceAll("[^0-9]", "");
        System.out.println("payment = " + payment);
        driver.findElement(By.id("tf_amount")).sendKeys(payment);
        Thread.sleep(3000);

        driver.findElement(By.id("btn_submit")).click();
        String checkPayment = driver.findElement(By.id("tf_amount")).getAttribute("value");
        Assert.assertEquals(payment, checkPayment);

        driver.findElement(By.id("btn_submit")).click();
        String successMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertTrue(successMessage.contains("You successfully submitted"));

        driver.findElement(By.linkText("Online Statements")).click();
        driver.findElement(By.linkText("2009")).click();
        driver.findElement(By.xpath("//*[@id=\"os_2009\"]/table/tbody/tr[1]/td[1]/a")).click();
        Thread.sleep(2000);

        String userHome = System.getProperty("user.home");
        String path = userHome + "/Downloads/LambdaTest.txt";
        boolean isExists = Files.exists(Paths.get(path));
        Assert.assertTrue(isExists);



    }

}
