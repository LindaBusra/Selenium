package MyPractice.MixedTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Amazon extends TestBase {

    /*
    //Go to https://www.amazon.com/ web page
    //Enter Java in search box
    //Write the result of Java books
    //Select the second book
    //Add this book to the cart
    //Enter teapot in search box
    //Select the 4.th teapot
    //Add this teapot to the cart
    //Click on Gift Cards
    //Click on New Baby category
    //Select a card
    //Enter email into "To" box
    //Enter your name into "From" box
    //Enter a message to the card
    //Add this card to cart
    //Open shopping cart
    //Get total price on the console

     */

    @Test
    public void test(){


        //Go to https://www.amazon.com/ web page
        driver.get("https://www.amazon.com/");


        //Enter Java in search box
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java" + Keys.ENTER);


        //Write the result of Java books
        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(result.getText());

        //Select the second book
        WebElement secondbook = driver.findElement(By.xpath("//*[@data-image-index='2']"));
        secondbook.click();

        //Add this book to the cart
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        addToCart.click();

        //Enter teapot in search box
        WebElement searchBox1 = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox1.sendKeys("Teapot" + Keys.ENTER);

        //Select the 4.th teapot
        WebElement teapot = driver.findElement(By.xpath("//*[@data-image-index='4']"));
        teapot.click();

        //Add this teapot to the cart
        WebElement addToCart1 = driver.findElement(By.id("add-to-cart-button"));
        addToCart1.click();

        //Click on Gift Cards
        WebElement giftCards = driver.findElement(By.xpath("//*[.='Gift Cards']"));
        giftCards.click();

        //Click on New Baby category
        WebElement newBaby = driver.findElement(By.xpath("//*[@aria-label='New baby']"));
        newBaby.click();

        //Select a card
        WebElement selectCard = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[3]"));
        selectCard.click();

        //Enter email into "To" box
        WebElement email = driver.findElement(By.xpath("(//*[@name='emails'])[1]"));
        email.sendKeys("emilynilsen@gmail.com");

        //Enter your name into "From" box
        WebElement from = driver.findElement(By.xpath("(//*[@name='from'])[1]"));
        from.sendKeys("from Yasin");

        //Enter a message to the card
        WebElement message = driver.findElement(By.id("gc-order-form-message"));
        message.clear();
        message.sendKeys("Welcome baby :) ");


        //Add this card to cart
        WebElement addToCart2 = driver.findElement(By.xpath("//input[@id='gc-buy-box-atc']"));
        addToCart2.click();

        //Open shopping cart
        WebElement cart = driver.findElement(By.id("nav-cart"));
        cart.click();

        //Get total price on the console
        System.out.println("Total price: " + driver.findElement(By.id("sc-subtotal-amount-activecart")).getText());




//        //Enter Java in search box
//        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
//        searchBox.sendKeys("iphone 13" );
//        waitFor(5);
//
//
//        //find a sentence from opened search window and click on it.
//        List<WebElement> list = driver.findElements(By.xpath("//*[@class='left-pane-results-container']/div"));
//        int size =list.size();
//
//        for(int i=1; i<=size; i++){
//
//            WebElement x = driver.findElement(By.xpath("(//*[@class='left-pane-results-container']/div)["+i+"]"));
//            if(x.getText().contains("screen")) {
//                System.out.println(x.getText());
//                x.click();
//            }
//        }

    }
}
