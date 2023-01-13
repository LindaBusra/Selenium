package Tests;

import org.openqa.selenium.devtools.v106.domsnapshot.model.StringIndex;

public class Day07_Windows {

    /*

    Sometimes when we click on a button, a new windows opens in a new tab.

    Syntax:
    driver.switchTo().window(driver.getWindowHandle);       //it returns the unique id of that window: driver.getWindowHandle

    switchTo().window() switches between windows.

    getWindowHandle() get the handle of the page the WebDriver is currently controlling. This returns a String.

    getWindowHandles() will give you all the handles for all the  pages that is open. This returns a Set



    WINDOW 1
    BY DEFAULT driver is on this window

    driver.getWindowHandle(); returns THE CURRENT WINDOW HANDLE(window1 handle)

    String window1Handle = driver.getWindowHandle();

    To switch the window 2, I need WINDOW 2 HANDLE. But how can I ever get window 2 handle
    We need to use : driver.getWindowHandles(); return ALL OPEN WINDOW HANDLES

    Set<String> window1Handle = driver.getWindowHandles();
    SET : {window1handle, window2handle}

    Use for each to get window2 handle
    Finally switch to window2 using
    driver.switchTo().window(window2handle);


     */


}
