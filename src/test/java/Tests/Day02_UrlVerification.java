package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_UrlVerification {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "./src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://techproeducation.com/");


        //Verify if homepage url is  https://techproeducation.com/

        String actualUrl = driver.getCurrentUrl();

        String expectedUrl = "https://techproeducation.com/";


        if(expectedUrl.equals(actualUrl)) {

            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
            System.out.println("Actual url is: " + actualUrl);
            System.out.println("Expected url is: " + expectedUrl);
        }


        driver.quit();

        /*
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

//------------------------------------------------------------------------------------------
        2-What do you do when your task case pass?
        -Prepare report and upload the JIRA
//------------------------------------------------------------------------------------------
        3-What do you do when your test case fail?
        -Retest to make sure from the failure. It can be data issue, documentation issue or it can be a real bug.
        -If there is a bug, then talk to dev and let them fix the bug.
        -After the fix, we retest. When test cases passes we upload to Jira.
//------------------------------------------------------------------------------------------
        4-What do you do when you find a bug?
        -Retest to make sure from the failure. It can be data issue, documentation issue or it can be a real bug.
        -If there is a bug, then talk to dev and let them fix the bug.
        -After the fix, we retest. When test cases passes we upload to Jira.
//------------------------------------------------------------------------------------------




         */

    }
}
