package MyPractice.NotsInterview;

public class Interview05_LocatorsWindowsFrame {

    /*

    3. Selenium Locators Interview Questions

    Q1 - What is the difference between findElement() and findElements() in Selenium WebDriver?
    i. findElement() - It is used to locate single element on the web page. It returns single WebElement.

    ii. findElements() - It is used to get all the webelements having same element locator.
    For e.g., if we would use driver.findElements(By.id("text")), then it will return list of all the web elements present
    on the web page having id "text".

//--------------------------------------------------------------------------------------------------------------------


    Q2 - How many different types of locators are in Selenium?
    There are 8 different type of locators that can be used in Selenium to find an element.

    ID
    Name
    Link Text
    Partial Link Text
    Tag Name
    Class Name
    CSS Selector
    XPath

//--------------------------------------------------------------------------------------------------------------------


    Q3 - Which one is the fastest and slowest locator?
    Generally, ID is considered as the fastest and xpath is considered as the slowest locator. But when it comes to choose
    a locator for your automation, we should pick the most reliable one which is of course ID.

//--------------------------------------------------------------------------------------------------------------------


    Q4 - What are the different types of xpaths and what is the difference between them?
    XPATH is also known as Extensible Markup Language Path. It's a language by using which we can query xml documents and
    can locate elements in Selenium. There are two types of xpaths,

    i. Absolute xpath - It starts with single slash '/', and it starts from the first tag which is html tag. Ex., /hml/body/div[3]/input

    ii. Relative xpath - It starts with double slash '//', relative path can be created from anywhere in the web page. Ex., //div[@id='name']/div/span/input


//--------------------------------------------------------------------------------------------------------------------



    4. Windows and Frame Handling Interview Questions

    Q1 - How to switch to Nth browser window in Selenium WebDriver?

    // Case 1 - Create a Set and store all window handle ids in it

    Set AllWindowHandles = driver.getWindowHandles();
    String window1 = (String) AllWindowHandles.toArray()[0];
    String window2 = (String) AllWindowHandles.toArray()[1];

    // Switch to window with id 2 driver.switchTo().window(window2);
    String window1 = (String) AllWindowHandles.toArray()[0];
    String window2 = (String) AllWindowHandles.toArray()[1];

    // Switch to window with id 2
    driver.switchTo().window(window2);



    // Case 2 - Moving Between all Windows

    for (String handle : driver.getWindowHandles()) { driver.
                driver.switchTo().window(handle); }
    }

//--------------------------------------------------------------------------------------------------------------------


    Q2 - How to switch frames in Selenium WebDriver?
            Switch frames can be done using switchTo() method.
            // Move to frame
            driver.switchTo().frame("Target Web element")

     */


    //https://www.techlistic.com/2021/10/top-50-selenium-interview-questions.html
}
