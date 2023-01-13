package Tests;

public class Day08_ActionsNots {

    /*
We need to use Actions class to perform mouse and keyboard actions.
There are two type actions:
1-Mouse-based actions : double-click, right click, click and hold, drag
and drop, move over element etc, scroll.
2-Keyboard-based actions: Keyboard actions can function as Shift, Ctrl,
and Alt keys.
Actions has many useful mouse and keyboard functions

Step 1: Create the action object:
Actions actions=new Actions(driver);  -->action object can control the driver

Step 2: Locate the WebElement you want to work on :
WebElement element = driver.findElement(By.id(“ID"));

Step 3: Perform the action on the WebElement by using this actions object.

For instance, to right click: actions.contextClick(element).perform();
perform() : Executes an action.This must be used at the end to perform an action.DO NOT FORGET TO USE PERFORM()

Keyboard actions are keyUp, keyDown, sendKeys.
Keyboard actions can function as Shift,Ctrl, and Alt keys that is on the keyboard.

keysDown(); used to press and hold a key. Keys mean Shift,Ctrl, and Alt keys.
keysUp(); used to release a key that is already pressed after keysDown() method. We can use keysUp() after
keysDown() method. Otherwise we may get IllegalArgumentException.
sendKeys(element,”text”); Used to type into text box, text area and so on.
     */
}
