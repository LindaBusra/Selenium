package MyPractice.MixedTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class P14_SauceDemo02  extends TestBase {



    @Test
    public void test(){

        /*
         * Navigate to  https://www.saucedemo.com/
         * Enter the user name  as standard_user
         * Enter the password as   secret_sauce
         * Click on login button
         * Choose price low to high
         * Verify item prices are sorted from low to high          */



        //Navigate to  https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");


        //Enter the user name  as standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Enter the password as   secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click on login button
        driver.findElement(By.id("login-button")).click();

        //create list for stor web elements
        List<WebElement> productsPrice = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        //to convert web element to string
        List<String> strProductPrice = new ArrayList<>();

        for(WebElement w: productsPrice) {          //or productsPrice.stream().forEach(t-> strProductsPrice.add(t.getText()));

            strProductPrice.add(w.getText());
        }

        //to convert string to double
        List<Double> doubleProductPrice = new ArrayList<>();

        for(String w: strProductPrice) {          //or productsPrice.stream().forEach(t-> strProductsPrice.add(t.getText()));

            doubleProductPrice.add( Double.parseDouble  (w.replace("$", "")));
        }


        //create a filterer list for verifying
        List<Double> forVerify = new ArrayList<>();
        forVerify.addAll(doubleProductPrice);
        Collections.sort(forVerify);

        Assert.assertEquals("Filtering test for prices failed", forVerify, doubleProductPrice);


        //2.way for confirm
        WebElement filter = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(filter);
        select.selectByValue("lohi");       //<option value="lohi">Price (low to high)</option>

        String str = driver.findElement(By.className("active_option")).getText();
        Assert.assertEquals("Filtering test for prices failed", str, "PRICE (LOW TO HIGH)");







































    }
}
