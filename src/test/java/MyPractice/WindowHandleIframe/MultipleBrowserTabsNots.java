package MyPractice.WindowHandleIframe;

public class MultipleBrowserTabsNots {

    /*

    1. Handle Multiple Browser Tabs with Selenium

    1.1. Launch google.com with Selenium WebDriver
    This is the most common part, we'll launch google.com with Selenium WebDriver as usual.

    // Set Driver path
    System.setProperty("webdriver.chrome.driver", "C:\\AUTOMATION\\chromedriver.exe");

    // Initialize driver
    WebDriver driver=new ChromeDriver();

    //Maximize browser window
    driver.manage().window().maximize();

    //Go to URL
    driver.get("http://www.google.com");

    //Set timeout
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);




    1.2. Automate Opening of two browser tabs
    Now our first browser tab is opened and google.com is launched inside it. So, step 2 is to open our second browser tab. Like we already know that manually we can open a new tab in a browser by pressing 'ctrl' key and 't' key together. We are going to automate of this shortcut using Selenium Actions Class.

    // Open new tab by pressing ctrl + t
    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

    //Go to URL
    driver.get("http://www.gmail.com");

    //Set new tab timeout
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    // Do some operations on gmail like login




    1.3. Automate Switching between two tabs during execution of automation script
    We can switch between different tabs on a browser by pressing 'ctrl' and 'tab'. We'll automate same with Actions class.

    // Switch back to first tab (google.com) by pressing ctrl + tab
    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
    driver.switchTo().defaultContent();
    Thread.sleep(2000);

    // Do some operation on google.com
     */
}
