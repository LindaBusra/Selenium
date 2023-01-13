package MyPractice.NotsInterview;

public class Interview01 {

    /*

    Q1 - What is the syntax to launch browser in Selenium WebDriver?
    We can launch browser by creating an object of WebDriver interface and initialize it with some browser class like., ChromeDriver(), FirefoxDriver() etc.

    // Set Path of driver executable
    System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

    // Launch Browser - Creating a Firefox instance
    WebDriver driver = new FirefoxDriver();

    // For Chrome
    WebDriver driver = new ChromeDriver();

    // For Safari
    WebDriver driver = new SafariDriver();

    // For Opera
    WebDriver driver = new OperaDriver();

//-----------------------------------------------------------------------------------------------------------

    Q2 - What is the difference between driver.get() and driver.navigate().to() commands?

    Driver.get()
    1)It is used to navigate to particular page (url) and wait til it loads.
    2)It does not maintain any browser history.

    Driver.navigate().to()
    1)It is navigate to particular page and does not  wait for page to load.
    2)It maintains browser history to navigate forward and back.

//-----------------------------------------------------------------------------------------------------------


    Q3 - What are the different navigation commands used in Selenium WebDriver?
    There are 4 navigation commands in Selenium WebDriver,

	// Navigate directly to some URL
	driver.navigate().to("https://www.techlistic.com/p/java.html");

	// Navigate Back
	driver.navigate().back();

	// Navigate Forward
	driver.navigate().forward();

	// Refresh Page
	driver.navigate().refresh();

//-----------------------------------------------------------------------------------------------------------


    Q5 – What is the difference between driver.close() and driver.quit() Selenium WebDriver?
    i. driver.close() - It is used to close the current browser window.

    ii. driver.quit() - It is used to close all the browser windows which are opened by Selenium and safely ends the session. (Destroys the WebDriver instance)

//-----------------------------------------------------------------------------------------------------------

    Q6 - How to enter the text in a text field using Selenium WebDriver?
    We can enter text in Selenium by using sendKeys() command.

    driver.findElement(By.xpath("/some/xpath")).sendKeys("Some Value");

    // OR

    // Implementation with WebElement
    WebElement FIRSTNAME =  driver.findElement(By.id("some-id"));
    FIRSTNAME.sendKeys("Any Text value");

//-----------------------------------------------------------------------------------------------------------

    Q7 - How to check that the radio button is checked or not?
    You can use isSelected() command of Selenium to see whether a radio button is checked or not.

    WebElement gender =  driver.findElement(By.id("some-radio-button-id"));
    boolean isGenderSelected = gender.isSelected();

//-----------------------------------------------------------------------------------------------------------

    Q8 - How to get color or size of the font Selenium WebDriver? (how to get background color or any other css property of the web element)
    We can get the font color or size or any other css property value of web element by using getCssValue() command.

    //getCssValue() Command

    WebElement HEADING =  driver.findElement(By.id("some-id"));

    String color = HEADING.getCssValue("color");
    System.out.println(color);


//-----------------------------------------------------------------------------------------------------------


    Q9 - How to validate any error/success message in Selenium WebDriver?
    Selenium provides getText() command by using that, we can get text of the error/success message and validate it with the expected message.

    String textValue = driver.findElement(By.xpath("/some/xpath")).getText();

    // OR

    // Implementation with WebElement
    WebElement SOME_LINK =  driver.findElement(By.id("some-id"));
    String linkValue = SOME_LINK.getText();
    System.out.println(linkValue);

//-----------------------------------------------------------------------------------------------------------


    Q10 - How to select an item from the drop down menu with Selenium WebDriver? What are the different commands to select an item?
    We have create the object of Select class in Selenium and then we can select an element from Select drop down menu by using any one of the following three commands:

     * Select Commands
         1.  selectByIndex()
         2.  selectByVisibleText()
         3.  selectByValue()

    WebElement DROP_DOWN = driver.findElement(By.xpath("/select"));

    // Create object of Select Class
    Select select1 = new Select(DROP_DOWN);

    // Option 1
    select1.selectByIndex(2);

    // Option 2
    select1.selectByVisibleText("Edam");

    // Option 3
    select1.selectByValue("Edam");



*/



}
