package MyPractice.NotsInterview;

public class Interview04_ActionsClass {

    /*

    Q1 - What is Actions class? What are its commands?

    Actions class is used to handle Keyboard and Mouse Events. You need to import org.openqa.selenium.interactions.
    Actions in order to use Actions class.

    This class includes keyboard and mouse actions such as double click, right click, drag & drop, mouse hover and
    clicking multiple elements.


    //------------------------------------------------------------------------------------------------------------

    Q2 - What are the keyboard and mouse events in Selenium WebDriver?
    We can perform following Keyboard and Mouse events using Actions class:

    i. Keyboard events: You can press any key of the keyboard,
    Key Up
    Key Down
    sendKeys()


    ii. Mouse events:
    click()
    doubleClick()
    contextClick()
    clickAndHold()
    dragAndDrop()
    moveToElement()
    moveByOffset(x, y)
    release()


    //------------------------------------------------------------------------------------------------------------


    Q3 - How to do Mouse hover in Selenium WebDriver?
    We can perform Mouse Hover using Actions class in Selenium WebDriver. Let's take a look at the code to do so:


    // Xpath for Menu
    WebElement Menu_Link = driver.findElement(By.xpath("/html/some/xpath"));

    // Xpath for Sub Menu
    WebElement SubMenu_Link = driver.findElement(By.xpath("/html/some/xpath"));

    // Create object of Actions class
    Actions actions = new Actions(driver);

    // Move cursor to Menu link (Mouse hover on menu link so that sub menu is displayed)
    actions.moveToElement(Menu_Link);

    // Click on Submenu link (whcih is displayed after mouse hovering curson on menu link)
    actions.click(TSHIRTS_Submenu_Link).build().perform();


    //------------------------------------------------------------------------------------------------------------


    Q4 - How to do double click and right click in Selenium WebDriver?
    i. Double Click - We can perform double click by using Action class's doubleClick() method.

    i) Double Click

    Actions actions = new Actions(driver);
    WebElement PRODUCT_CATEGORY = driver.findElement(By.xpath("/html/some/xpath"));
    actions.doubleClick(PRODUCT_CATEGORY);
    actions.build().perform();
    ii. Right Click - We can perform right click by using Action class's contextClick() method.

    ii) Right Click


    // Locate web element
    WebElement PRODUCT_CATEGORY = driver.findElement(By.xpath("/html/some/xpath"));

    // Create object of actions class
    Actions actions = new Actions(driver);

    // Right click on PRODUCT_CATEGORY element
    actions.contextClick(PRODUCT_CATEGORY);
    actions.build().perform();


    //------------------------------------------------------------------------------------------------------------
/*


    Q5 - How to drag and drop an element in Selenium?
    We can perform drag and drop using Action class's.


    // Weblements for source and target
    WebElement source = driver.findElement(By.name("source"));
    WebElement target = driver.findElement(By.name("target"));

    // Create object of actions class
    Actions action = new Actions(driver);
    action.dragAndDrop(source, target);
    action.build().perform();                               */





}
