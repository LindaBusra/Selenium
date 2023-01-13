package Tests;

public class Day13_JavascriptExecuterNots {

    /*


    Javascript: is a coding language. It used by developer for creating user interface.
    It is good to interact with websides. Testers use javascript for automate websides.

    You dont need to know javascript to use javascript code i Selenium.

    ★What is JS Executor?
    It is an API, an interface. it used to execute javascript comments in Selenium
    JS Executor is coming from Selenium, it is used to write javascript code in selenium.

    ★Why you are learning javascript executor?
    We may need js methods to interact with web element, when traditional selenium
    methods are not enough(such as click, scrolling into specific element,…)

    ★What we can do with JS executor?
    Click. Especially good with clicking hidden element
    scroll onto specific elements, scroll the all the way down/up/right/left, zoom in, zoom out
    Type in an input
    Change the value of an element
    Hover over
    Change the color, background color, add border


    There are two steps for using js executor.
    //1. creating a reference
    JavascriptExecutor js = (JavascriptExecutor) driver;

    -make sure to import the package
    Import org.openqa.selenium.JavascriptExecutor;

    //2. calling the method
    js.executeScript(Script, Arguments);
    js.executeScript(return something);

    Script – This is the JavaScript that needs to execute.
    Arguments – It is the arguments to the script. It’s optional.

    ---------------------------------------------------------------------------
    JavascriptExecutor js = (JavascriptExecutor) driver;

    Example 1: Clicking on a button
    WebElement button =driver.findElement(By.name("btnLogin"));
     //Perform Click on LOGIN button using JavascriptExecutor

    js.executeScript("arguments[0].click();", button);     (in right part there is an argument, we say, click on then argument
    arguments[0] -> the first argument in executeScript method
    click() -> js function to click. It can be scrollIntoView,…


    Example 2: We will scroll down to this element
    WebElement resentBlog = driver.findElement(By.xpath("//*[.='Recent Blog']"));
    js.executeScript("arguments[0].scrollIntoView(true);",resentBlog);

    "arguments[0].scrollIntoView(true);"-->javascript code
    the others (the entire syntax is specific for selenium) come from js executer
         */


}
