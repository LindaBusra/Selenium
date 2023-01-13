package MyPractice.MouseKeyboardActions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P19_MouseActions03 extends TestBase {

    //Yeni bir class olusturalim: MouseActions3
    //1- https://demoqa.com/droppable adresine gidelim
    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin


    @Test
    public void test(){

        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim


        WebElement dragMe = driver.findElement(By.id("draggable"));
        WebElement drapHere = driver.findElement(By.id("droppable"));


        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMe, drapHere).perform();


        WebElement textInDropped = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        Assert.assertEquals("Dropped!", textInDropped.getText());




    }


}
