package MyPractice.WindowHandleIframe;

import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P22_WindowHandle05 extends TestBase {

    //        Open google on window 1, amd get title
    //        Open amazon on window 2
    //        Open linkedin on window 3
    //        Switch between windows
    //        Switch to amazon
    //        Switch to google
    //        Switch back to linkedin


    @Test
    public void test() throws InterruptedException {

        // Open google on window 1, amd get title
        driver.get("https://www.google.com");
        System.out.println("Google title : " + driver.getTitle());
        String handleWindow1 = driver.getWindowHandle();

        // Open amazon on window 2
        driver.switchTo().newWindow(WindowType.WINDOW); //create a new window and switch to that window
        driver.get("https://www.amazon.com");       //open amazon in 2nd window
        String handleWindow2 = driver.getWindowHandle();

        // Open linkedin on window 3
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String handleWindow3 = driver.getWindowHandle();

        // Switch between windows
        // Switch to amazon
        Thread.sleep(3000);
        driver.switchTo().window(handleWindow2);

        // Switch to google
        Thread.sleep(3000);
        driver.switchTo().window(handleWindow1);

        // Switch back to linkedin
        Thread.sleep(3000);
        driver.switchTo().window(handleWindow3);

    }
}
