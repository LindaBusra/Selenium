package MyPractice.ScreenShots;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.io.IOException;

public class Screenshot03 extends TestBase {

    /*
     * In Testing, Screenshot is very essential
     * Documentation of test results

     * Test Reports should have test cases(test steps), test result(fails, passes), screenshots

     * If our test fails, we need screenshot to raise a bug ticket.
     * If our test passes, we should get a screenshot as a proof.

     * With Selenium 3 & 4 we can get screenshot by using TakeScreenshot class and getScreenshotAs()
     * to be able to get screenshot of a webpage or a specific element


 */

    @Test
    public void screenShotTest() throws IOException {

        driver.get("https://www.google.com");

        takeScreenshotOfPage();

        driver.findElement(By.name("q")).sendKeys("bicycle" + Keys.ENTER);
        takeScreenshotOfPage();

    }

    /*
     * How do you get screenshot in your automation framework?
     * I can use getScreenshotAs() method to capture the screenshot
     * And I can use reusable methods for screenshots.
*/


}