package MyPractice.Shadow_Cookies;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Automationexercise_closeShadow extends TestBase {


    @Test
    public void test() throws InterruptedException {


        //close  Shadow Root Grippy Host Announce
        //Go to https://automationexercise.com web page
        driver.get("https://automationexercise.com");

        driver.findElement(By.className("grippy-host")).click();
        Thread.sleep(2000);
//        driver.findElement(By.xpath("//path[@stroke='#FAFAFA']")).click();
        System.out.println("The end");
    }
}