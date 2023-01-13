package MyPractice.NotsInterview;

public class Interview02 {

    /*
    Q11 - How to check the text is present/visible or not on page?
    We can check presence of text on a page by using isDisplayed() command.

    WebElement loginButton =  driver.findElement(By.id("some-id"));
    boolean isLoginDisplayed = loginButton.isDisplayed();

//---------------------------------------------------------------------------------------------------

    Q12 - How to handle Alerts or Pop-Ups using Selenium WebDriver?
    Alerts or javascript pop-ups can be handled by using commands of org.openqa.selenium.Alert class in Selenium WebDriver.

    // Alert class object creation
    // Below Code switches the control/focus of your execution to the alert
    Alert alert = driver.switchTo().alert();

    // Below command is used to accept the alert like click on Yes, Accept, Ok button
    alert.accept();

    // Below command is used to dismiss/reject the alert like click on No, Dismiss,
    Cancel button
    alert.dismiss();

//---------------------------------------------------------------------------------------------------

    Q13 - Why we aren't recommended to use Thread.sleep() in Selenium?
    Thread.sleep() pauses the execution flow of the thread for particular time, which is not the ideal way to wait. Instead of that some of the Selenium wait should be used.

//---------------------------------------------------------------------------------------------------

    Q14 – What are the different wait commands in Selenium WebDriver?
    There are three types of wait commands in Selenium:

    1. Implicit Wait - Implicit wait is used to set wait time (say 30 secs) in your automation script to wait for an  element on the page before throwing exception. You can increase or decrease the wait time as per your requirement.

    2. Explicit Wait – Explicit wait is also knows as conditional wait. It directs the Selenium WebDriver to wait until a condition is met.

    3. Fluent Wait - Fluent wait is kind of conditional wait but with frequency.

//---------------------------------------------------------------------------------------------------

    Q15 – What is the syntax for implicit, explicit and fluent wait?
    Syntax for Implicit, Explicit and Fluent wait commands:

    // Implicit wait - Set wait of 10 seconds
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    // Explicit Wait
     WebDriverWait wait = new WebDriverWait(driver, 10);
     wait.until(ExpectedConditions.alertIsPresent());

    // Fluent Wait
     Wait wait = new FluentWait(WebDriver reference)
       .withTimeout(timeout, SECONDS)
       .pollingEvery(timeout, SECONDS)
       .ignoring(Exception.class);

     WebElement foo = wait.until(new Function() {
      public WebElement apply(WebDriver driver) {
       return driver.findElement(By.id("foo"));
      }
     });

//---------------------------------------------------------------------------------------------------

    Q16 - How to handle ajax elements using Selenium WebDriver?
    When we do Google search and a list of options matching to our keyword displayed on it's own without refreshing the page,
    is an example of ajax search. We can handle ajax elements using Explicit Wait in Selenium.

    In following code, we are typing keyword "selenium tutorial techlistic" in google search box. And then suggestion
    box appears and we are handling that ajax suggestion box with the WebDriverWait class's presenceOfElementLocated() function.

    //enter techlistic tutorials in search box
	driver.findElement(By.name("q")).sendKeys("selenium tutorial techlistic");

	//wait for suggestions
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.className("sbtc")));

	WebElement list=driver.findElement(By.className("sbtc"));
	List rows=list.findElements(By.tagName("li"));

	for(WebElement elem:rows) {
	System.out.println(elem.getText());
	}
	}

//---------------------------------------------------------------------------------------------------

    Q17 - How to scroll vertically and horizontally using Selenium WebDriver?
    We can do scroll in selenium using org.openqa.selenium.JavascriptExecutor. It is a Selenium interface which can be used to execute any javascript code snippet. We use executeScript() method of it to execute javascript code for vertical or horizontal scroll.


    // Create object of JavascriptExecutor
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // Vertical Scroll
    js.executeScript("javascript:window.scrollBy(0,350)");

    // Horizontal Scroll
    js.executeScript("javascript:window.scrollBy(250,0)");


//---------------------------------------------------------------------------------------------------


    Q18 - How to take screenshot in Selenium WebDriver?
    Screenshot can be taken by using org.openqa.selenium.TakesScreenshot class of Selenium.

    In the following code, we are creating object of the File class of Java and storing the screenshot take using the
    TakesScreenshot's getScreenShotAs() method. And then storing it with some name using the FileUtils class's copyFile()
    method of Java.

    // Create File object and save screenshot of current webpage inside it
    File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

    // Copy screenshot file to a location with some name and extension you want
    FileUtils.copyFile(screenshot, new File("D:\\screenshot.jpg"));



     */
}
