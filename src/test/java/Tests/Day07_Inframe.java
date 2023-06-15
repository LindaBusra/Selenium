package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Day07_Inframe extends TestBase {

    /*
     Iframe is an element that loads another HTML element inside of a web page
• Iframe is used to embed a new map, video, page on a page. It kind of creates a page within a page
• Selenium cannot directly see the elements inside an iframe if there is an iframe on a page.
◦ When there is an iframe, we must first switch() to the iframe
★There are 3 ways to switch to iframe : by index, id/name, or web element

 driver.switchTo().frame(index of the iframe);//index start from 0
• driver.switchTo().frame(“id or name of the iframe");
• driver.switchTo().frame(WebElement of the iframe);//WebElement using any locators like xpath,..
• Switching back to parent / default frame:
◦ driver.switchTo().parentFrame(); to get back to parent frame.let you go only 1 upper level.
◦ driver.switchTo().defaultContent();

*What might be the reason for your test case to fail?
-There may be wait problem. The page may be very slow. Internet maybe not fast enough
        -Put some more wait. We can use explicit wait in selenium. We will learn later
-Locator might be incorrect
        -Double check locator and fix if needed
-Data issue. Typo in our expected values.
        -If there is any documentation issue, we can talk to BA to fix the document and then we can use correct expected values
-Maybe there is an iframe on the page
        -We first need to switch to the frame
-Maybe there is an alert on the page
        -We first need to handle the alert by accepting or dismissing.
-Maybe the page opens in a new tab or window
        -We first need to switch the target window
-It may be real bug that is caused by the latest codes.
        -We discuss the issue with the team then raise a bug ticket if needed.


     */


/*Create a class: IFrame
    Create a class: IFrame
    Create a method: iframeTest
    Go to https://the-internet.herokuapp.com/iframe
    Verify the Bolded text contains “Editor”
    Locate the text box
    Delete the text in the text box
    Type “This text box is inside the iframe”
    Verify the text Elemental Selenium text is displayed on the page
}
 */

    @Test
    public void iFrameTest() {


        //     Go to https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");


        //     Verify the Bolded text contains “Editor”
        //Header is not in the iframe so do not switch to iframe
        String BoldText = driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();  //or  By.xpath("//h3")
        Assert.assertTrue(BoldText.contains("Editor"));


        //Locate the text box
        //Note:textbox is in the iframe so we have to switch to the iframe

        //GETTING IN THE IFRAME

        //there are three ways to switch to an iframe
        driver.switchTo().frame(0);  //By index of iframe, index starts from 0.
//        driver.switchTo().frame("mce_0_ifr");   //By id  or name of iframe -->Preferred one.
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"))) ;     //Web element of the iframe

         //Delete the text in the text box
        WebElement box = driver.findElement(By.xpath("//p"));
        box.clear();    //clear() is used to delete the text is the elements


        //Type “This text box is inside the iframe”
        box.sendKeys("This text box is inside the iframe");


        //SO FAR DRIVER IS IN THE IFRAME, BUT ELEMANTAL SELENIUM TEST IS OUTSIDE IOF THE IFRAME
         //GETTING OUT OF THE FRAME
        driver.switchTo().parentFrame();
        //if there is more iframe, if we use parentframe, it goes to one upper level. default goes to first

        //ALTERNATIVELY WE CAN USE defaultContent();
        // Verify the text Elemental Selenium text is displayed on the page
        Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());


        List<WebElement> list = driver.findElements(By.tagName("iframe"));
        System.out.println("The number of iframe is :" + list.size());
    }
}