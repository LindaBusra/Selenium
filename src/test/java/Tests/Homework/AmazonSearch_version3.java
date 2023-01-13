package Tests.Homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonSearch_version3 extends TestBase {

    /*Create a new class: AmazonSearch
    //TC01_As user I want to know how many item are there on amazon in the first page after I search "porcelain teapot"?
       //TC02_Order the the tea pot prices, find the min, max, and average price to the nearest cent
     */

    @Test
    public void test(){

        driver.get("https://www.amazon.com/");

        // search "porcelain teapot"
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot" + Keys.ENTER);

        //how many item are there on amazon in the first page after I search "porcelain teapot"?
        List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-small s-price-instructions-style']"));
        System.out.println("size ve of list : " + listOfElements.size());


        List<WebElement> productsPrice = driver.findElements(By.xpath("//span[contains(text(),'$')]]"));
        System.out.println(productsPrice.size());

        //to convert web element to string
        List<String> strProductPrice = new ArrayList<>();

        for(WebElement w: productsPrice) {
                    strProductPrice.add(w.getText());
         }



        //to convert string to double
        List<Double> doubleProductPrice = new ArrayList<>();

        for(String w: strProductPrice) {
            doubleProductPrice.add( Double.parseDouble (w.replaceAll("$", "")));
        }

        //sort  for find min and max
        Collections.sort(doubleProductPrice);
        System.out.println(doubleProductPrice);

        //find average
        double sum = 0;
        for(int i=0; i<doubleProductPrice.size(); i++) {
            sum += doubleProductPrice.get(i);
        }

        double average =sum/doubleProductPrice.size();

        //print the min, max and average values
        System.out.println("min: " + doubleProductPrice.get(0));
        System.out.println("max: " + doubleProductPrice.get(doubleProductPrice.size()-1));
        System.out.println("Average price: " + average);

    }
}
