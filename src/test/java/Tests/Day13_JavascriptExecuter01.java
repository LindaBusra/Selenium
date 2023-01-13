package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;


public class Day13_JavascriptExecuter01 extends TestBase {

    //https://www.geeksforgeeks.org/javascriptexecutor-in-selenium/  look at this page!!!
    //for praksis  https://www.automationexercise.com/

    /*
    When user goes to home page
    And scroll on the WE OFFER element
    And scroll on the search box element
     */

@Test
    public void scrollIntoViewTest() throws IOException {

        driver.get("https://techproeducation.com/");
    waitFor(3);  //we create a method in testBase

    //1-create js executer object
    JavascriptExecutor js = (JavascriptExecutor) driver;

    //execute the command
    waitFor(3);

    //scrolling "We Offer" element
    WebElement weOfferText = driver.findElement(By.xpath("//*[.='we offer']")); //it scrolls to specific elements
    js.executeScript("arguments[0].scrollIntoView(true);", weOfferText);
    takeScreenshotOfPage();

    waitFor(3);
    //scrolling "Enroll Free" element          //we have to locate unique elements
    WebElement enrollFree = driver.findElement(By.xpath("//*[.=' Enroll Free ']"));
    js.executeScript("arguments[0].scrollIntoView(true);", enrollFree);
    takeScreenshotOfPage();

    waitFor(3);

    //scrolling WHY US element
    scrollIntoViewJS(driver.findElement(By.xpath("//*[.='WHY US?']")));
    takeScreenshotOfPage();

    waitFor(3);
    //scrolling back up to enroll free
    scrollIntoViewJS(enrollFree);
    takeScreenshotOfPage();

    //scroll all the way down
    scrollAllDownByJS();
    waitFor(3);
    takeScreenshotOfPage();

    //scroll all the way up
    scrollAllUpByJS();
    waitFor(3);
    takeScreenshotOfPage();
}

//sometimes some elements are visible just we scrollup down, so we can use these method for scrooldown/up


    @Test
    public void clickByJSTest(){

        driver.get("https://techproeducation.com/");
//        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
//        clickByJS(lmsLogin);
        clickByJS(driver.findElement(By.linkText("LMS LOGIN")));

    }

    @Test
    public void typeInTheInputTest(){
        driver.get("https://techproeducation.com/");
        setValueByJS(driver.findElement(By.xpath("//input[@type='search']")), "QA" );  //go to this web element and write QA

    }


    @Test
    public void getValueOfInputTest(){

    driver.get("https://www.priceline.com/");
    getValueByJS("hotelDates");

    }

    @Test
    public void colorByJSTest(){
        driver.get("https://www.priceline.com/");
        WebElement button = driver.findElement(By.xpath("//button[@data-testid='HOTELS_SUBMIT_BUTTON']"));
        changeBackgroundColorByJS(button, "yellow");
        addBorderWithJS(button, "5px solid blue");

    }


    //When user goes to https://jqueryui.com/autocomplete/
    //And type Apple
    //Then select Applescript







}
