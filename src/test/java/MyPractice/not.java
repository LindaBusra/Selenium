package MyPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.TestBase;

import java.time.Duration;

public class not extends TestBase {


    @Before
    public void setUp() {

        //after they  updated Chrome, I added the first line !!!!!
//        System.setProperty("webdriver.http.factory", "jdk-http-client");  //after updating i chrome I added it

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



//        System.setProperty("webdriver.chrome.driver", "./src/resources/drivers/chromedriver.exe");
//
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);

    }
}




        /*
         * So far we kept using main method.
         * We no longer need to use main method to create test cases with Junit
         * @Test : is used to create test cases
         * NOTE:All @Test methods must be void.
         *
         * @Before : It runs before each @Test class. This is used to run repeated pre-conditions.
         * For example, setup, create driver, maximize window.
         * @After : It runs after each @Test class. This is used to run repeated after conditions.
         * For example, driver quit, report generation
         *
         * @BeforeClass : It runs before each CLASS only ONCE. This methods must be static. Otherwise you get Runtime exception
         * @AfterClass :  It runs after each CLASS only ONCE. This methods must be static. Otherwise you get Runtime exception
         *
         * @Ignore :  It used to skip/ignore a test case.




        1-What is your approach for automation?
        -I read the acceptance criteria carefully
        -Then I create my test cases
        -Then I do my manual testing first
        -If all good, then I start complete  my automation script.
        -If I find a bug/defect, then I talk to dev. Dev fixes the issue, then I retest. If all is good
        then start my automation
        -When then automation is complete, I prepare the report for then user story. In fact, My automation script
        generates html reports for us. I upload those reports to the JIRA.
        -For my manual test cases, I manually take screenshots and prepare reports and attach them to the JIRA.

//------------------------------------------------------------------------------------------------------------------------------------
        2-What do you do when your task case pass?
        -Prepare report and upload the JIRA
//------------------------------------------------------------------------------------------------------------------------------------
        3-What do you do when your test case fail?
        -Retest to make sure from the failure. It can be data issue, documentation issue or it can be a real bug.
        -If there is a bug, then talk to dev and let them fix the bug.
        -After the fix, we retest. When test cases passes we upload to Jira.
//------------------------------------------------------------------------------------------------------------------------------------
        4-What do you do when you find a bug?
        -Retest to make sure from the failure. It can be data issue, documentation issue or it can be a real bug.
        -If there is a bug, then talk to dev and let them fix the bug.
        -After the fix, we retest. When test cases passes we upload to Jira.


//------------------------------------------------------------------------------------------------------------------------------------


        //What is assertion in testing?  Verifying that the expected and actualData is equal
        Assertion is done to check if expected result is equal to actual result.
        expected == actual -->pass
        expected != actual -->failed

        assertEquals("expected", "actual");
        assertTrue(true);  --> pass
        assertTrue(false);  --> fail

        assertFalse(false); --> pass
        assertFalse(true); --> fail


//------------------------------------------------------------------------------------------------------------------------------------

    Test execution stops if the  assertion is fail. This is called HARD ASSERTION
        Hard Assertion : If the execution stops in failure it is call Hard Assertion
    Test execution continues even  if test verification fails.  Verification means like if statement.
        Verification : If the execution continues in failure it is call Verification.


        /*What is difference between Assertion and Verification
        1-Assertion stops after assertion fails. Verification continues even after verification fails
        2-Junit assertions are hard assertion. If statement is verification
        Note: TestNG has soft assertion as well. We will learn it in TestNG.


//------------------------------------------------------------------------------------------------------------------------------------


//Webelement-->html, body, form, label, input, a    */


    /*
     * How many locators are there? 8
     * What are they?   id, name, className, linkText, tagName, partialLinkText, xpath, css
     * Which one do you prefer? Why?
            First if there is an ID, I use id, because id is unique and faster, (it has no navigation like xpath)
            then if there is no id I use name if there is a unique name.
            I also sometime create dynamic xpath. Because some elements do not have stable attributes
            like id and name. And I can write xpath for every element I want.
            * I sometimes even use css selector instead of xpath. But I personally use xpath more than css.

     * * What is difference between absolute xpath and relative xpath?
            -Absolute xpath: we start from the parent and go child elements one by one
            * Absolute xpath use /
            * Absolute xpath may easily be broken when a new element is added on the page
            * for that reason we should never use absolute xpath. In fact, my team don't let QA's use absolute xpath.

            -Relative xpath:we don't start from parent and go to child by one by. We go straight to the element.
            -Relative xpath use //
            -Relative xpath is very reliable. It does not easy brake, because absolute xpath does not dependent on other element
            -I use relative xpath in my framework when to locate the elements.

//------------------------------------------------------------------------------------------------------------------------------------

     * What is the difference between xpath and css selector?
     -First xpath and css are similar. Both are helpful and there are different ways to create xpath or css.
     -Syntax is a little different.
     -In xpath we use // and @, but in css we dont.
     -css is a little faster than xpath (way less than 1 second). xpath does navigation in the html that takes a little bit time
     -there are more ways to write xpath. For example, dynamic xpath has contains, starts-with, ends-with functions.


* //------------------------------------------------------------------------------------------------------------------------------------

*
     */
 /*
    TEST DATA : username, password, URL, test environment, city, ssn,...
    -Where do you get your test data?
    -BA-Business Analyst(Writes the acceptance criteria(AC)
    -Test Lead
    -Manual Tester
    -Tech Lead(Team Lead)
    -Developer
    -We can retrieve data from the database
    -We can retrieve data from API
    -Documentation. For example swagger doc can be used for API
    -If we need mock data(fake data), we can use the Java Faker
    -NOTE: Java Faker generates data randomly.
     */

//------------------------------------------------------------------------------------------------------------------------------------


    /*
    -What is a dropdown?
        ---Dropdown is a webelement. It has list of options.
    -How do you handle dropdown? What do you do to automate dropdown?
        ---Dropdowns are created using Select class. So we first locate the dropdown element, then use select class
        to interact with dropdown elements.
    -How do you select dropdown elements?
        ---We actually have 3 options to select a dropdown(index,value,visible text)
     */

//------------------------------------------------------------------------------------------------------------------------------------


//Thread.sleep(3000);     //hard wait, it comes from java. waits 3 seconds. dynamic wait. this will wait only if needed.