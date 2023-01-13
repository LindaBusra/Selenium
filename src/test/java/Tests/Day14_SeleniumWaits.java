package Tests;

public class Day14_SeleniumWaits {

    /*
Synchronization is very very very important for UI automation testing.
If application server or web server is too slow or the internet network or page is heavy(too many
frames, videos, images, maps, …) is too slow then the element on the webpage will be loaded too
slow.
In this case, by the time your script tries to find the element , the elements will not be loaded. So the
test script will not find the element and it will fail and we get NOSUCHELEMENTEXEPTION.
To solve this issue, we have to put additional wait for our driver to slow down.

Implicit Wait: This is a global timeout for all elements on the page-waits. Applies automatically to the
driver whenever driver is used.

Explicit Wait: This is mostly used for a given condition for specific elements.This is local wait. If we put it after an element, it is just for this element


★1. Hard Wait : Thread.sleep(millisecond)
Java wait. Waits for the given time. NO MORE NO LESS.
We should avoid using this wait. Avoid especially putting too many hard wait.
This will make the test execution time longer than needed.

★2. Dynamic Wait
★Implicit Wait: driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;(sel 3)
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;(sel 4)
    Selenium wait. Wait UP TO the given time.Throws no such element exception if element is not found in the given time NUSUCHELEMENTEXCEPTION
    Global wait. When you use implicit wait once, then whenever driver is called, then implicit wait applies.

★ExplicitWait:
Selenium wait. Wait UP TO the given time.
Local wait. We will apply the wait on to the specific elements
We must create a WebDriverWait object
    This sometime handles wait isse BETTER THAN IMPLICIT WAIT
    Element is not visible
    Element no clickable
    Text not displayed
We will add reusable explicit wait and call them in our method in page object model framework. Time Out Exception

★Fluent Wait:
    Similar to Explicit wait.
    We can put polling number.
    We can ignore some exception
    Local wait
    Time Out Exception

1. What are the selenium waits?
Implicit wait
Explicit wait
Fluent wait

★ 2. Which one do you prefer? Why?
It depends on the test case. I already use implicit wait in my driver class. But explicit wait works better.
So I prefer explicit wait in some cases. For example, when I work with dynamically loaded elements,
then explicit wait works better for waiting and locating the elements.

★3. What might be the reason of test case failure?
Wrong locator type, wrong values,… DOUBLE CHECK THE LOCATOR
Not synchronized. Timing issue….ADD MORE TIME OR USE EXPLICIT WAIT
Page is too slow, internet is slow, database is slow, hosting problem,…
Element may not be visible…PUT MORE TIMEOUT IT LOADING ISSUE, REVISE YOUR SCRIPT
Iframe…SWITCH TO IFRAME
Multiple window…SWITCH TO THE CORRECT WINDOW USING WINDOW HANDLERS
Alert….SWITCH, pop ups…, cookies…
Capcha code …. SELENIUM CANNOT HANDLE CAPCHA.NOTE WITH JAVA+SELENIUM, WE CAN HANDLE LIMITED CAPCHA

★4. What do you do when your test case fails?
Read error message on the console. I see the error message and the line of the error. Then I can read which part of the code is fails. Error message gives me which class, which line, what error, …
Check the locators, time issue, element visibility, iframe, pop ups, …
Manual testing again to see my automation logic is correct. To also check the functional is working. Check you flow as well

★5. Can you use implicit wait and explicit wait together?
Yes. Implicit wait is in driver class. When implicit in not enough, then I can use explicit wait. I have reusable methods for explicit waits

★6. What is the difference between implicit and explicit wait?
Implicit is global(applies wait to the driver whenever driver is used), explicit is local(I have to call explicit wait every time for new element)
Explicit wait works with expected condition. We have to create WebDriverWait object. Has more option such as visibility, clickibility, text be

★7. What is the difference between explicit and fluent wait?
In fact they are similar but there is a few differences:
        -Fluent wait does polling and can ignore the exceptions.

    *Tell me 5 exception that you get:
    NoSuchElementException
    TimeOutException
    NullPointerException
    InvalidSelectorException
    StaleElementReferenceException
    InvalidElementStateException
    WebDriverException
    ElementNotInteractableException
    ElementClickInterceptedException
    InvalidArgumentException
    JavascriptException
    RemoteDriverServerException


    Interview Questions
    *Tell me 5 exception that you get.
    *What type of exceptions do you get in selenium?
    *What is your solution?
    *What type of waits do you use?
    *Which wait do you prefer?
    *Why do you prefer that wait?
    *How to you resolve synronization issue?


*/

}
