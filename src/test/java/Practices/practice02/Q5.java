package Practices.practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q5 extends TestBase {

    /*
    // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    // Match the capitals by country.
     */

    @Test
    public void test() throws InterruptedException {


        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        Actions actions = new Actions(driver);

        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement stockholm = driver.findElement(By.id("box2"));
        WebElement washington = driver.findElement(By.id("box3"));
        WebElement copenhagen = driver.findElement(By.id("box4"));
        WebElement seoul = driver.findElement(By.id("box5"));
        WebElement rome = driver.findElement(By.id("box6"));
        WebElement madrid = driver.findElement(By.id("box7"));



        WebElement norway = driver.findElement(By.id("box101"));
        WebElement sweden = driver.findElement(By.id("box102"));
        WebElement unitedStates = driver.findElement(By.id("box103"));
        WebElement denmark = driver.findElement(By.id("box104"));
        WebElement southKorea = driver.findElement(By.id("box105"));
        WebElement italy = driver.findElement(By.id("box106"));
        WebElement spain = driver.findElement(By.id("box107"));


        actions.
                dragAndDrop(oslo, norway).
                dragAndDrop(stockholm, sweden).
                dragAndDrop(washington, unitedStates).
                dragAndDrop(copenhagen, denmark).
                dragAndDrop(seoul, southKorea).
                dragAndDrop(rome, italy).
                dragAndDrop(madrid, spain).
                build().
                perform();


        //id's have rules, so can be done by using them
        for(int i=1;i<8;i++){
            String sourceBox="box"+i;
            String destinationBox="box10"+i;
            WebElement source=driver.findElement(By.id(sourceBox));
            WebElement destination=driver.findElement(By.id(destinationBox));
            actions.dragAndDrop(source,destination).perform();
        }

    }
}
