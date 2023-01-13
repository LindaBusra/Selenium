package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class Day08_WindowHandle2 extends TestBase {

    /*
    With Selenium 4, we are able to create and switch to new windows or tabs

    driver.switchTo().newWindow(WindowType.TAB);
    driver.switchTo().newWindow(WindowType.WINDOW);
     */

    /*
    Open 3 new windows and verify their titles
Open 3 new tabs and verify their URLS
     */

    @Test
    public void newWindowTest() throws InterruptedException {

        //open techproeducation on window 1
        driver.get("https://www.techproeducation.com");
        String techProTitle = driver.getTitle();
        Assert.assertTrue(techProTitle.contains("Techpro Education"));
        String techProHandle = driver.getWindowHandle();


        //open amazon on a new window
        driver.switchTo().newWindow(WindowType.WINDOW);//create a new window and switches to that window automatically
        driver.get("https://www.amazon.com");
        String amazonTitle = driver.getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));
        String amazonHandle = driver.getWindowHandle();//getting window 2 id

        //open linkedin on a window 3
        driver.switchTo().newWindow(WindowType.WINDOW);     //create w new window and switches to that window automatically
        driver.get("https://www.linkedin.com");
        String linkedInTitle = driver.getTitle();
        Assert.assertTrue(linkedInTitle.contains("LinkedIn"));
        String linkedInHandle = driver.getWindowHandle();

        Thread.sleep(3000);
        // Switch back to TechPro
        driver.switchTo().window(techProHandle);
        System.out.println("TechPro : " + driver.getCurrentUrl());

        Thread.sleep(3000);
        // Switch back to Amazon
        driver.switchTo().window(amazonHandle);
        System.out.println("Amazon : " + driver.getCurrentUrl());

        Thread.sleep(3000);
        // Switch back to Linkedin
        driver.switchTo().window(linkedInHandle);
        System.out.println("Linkedin : " + driver.getCurrentUrl());
    }



    @Test
    public void newTabTest() throws InterruptedException {


        //open techproeducation on Tab1
        driver.get("https://www.techproeducation.com");
        String techProTitle = driver.getTitle();
        Assert.assertTrue(techProTitle.contains("Techpro Education"));
        String techProHandle = driver.getWindowHandle();


        //open amazon on a new tab
        driver.switchTo().newWindow(WindowType.TAB);//create a new TAB and switches to that window automatically
        driver.get("https://www.amazon.com");
        String amazonTitle = driver.getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));
        String amazonHandle = driver.getWindowHandle();//getting window 2 id

        //open linkedin on a new tab
        driver.switchTo().newWindow(WindowType.TAB);     //create w new TAB and switches to that window automatically
        driver.get("https://www.linkedin.com");
        String linkedInTitle = driver.getTitle();
        Assert.assertTrue(linkedInTitle.contains("LinkedIn"));
        String linkedInHandle = driver.getWindowHandle();

        Thread.sleep(3000);
        // Switch back to TechPro
        driver.switchTo().window(techProHandle);
        System.out.println("TechPro : " + driver.getCurrentUrl());

        Thread.sleep(3000);
        // Switch back to Amazon
        driver.switchTo().window(amazonHandle);
        System.out.println("Amazon : " + driver.getCurrentUrl());

        Thread.sleep(3000);
        // Switch back to Linkedin
        driver.switchTo().window(linkedInHandle);
        System.out.println("Linkedin : " + driver.getCurrentUrl());





    }

}
