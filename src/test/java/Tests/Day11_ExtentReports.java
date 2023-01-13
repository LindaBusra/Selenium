package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Day11_ExtentReports extends TestBase {

   /*
    https://www.extentreports.com/docs/versions/4/java/index.html  -->take a look


    1-Extent reports is used for generating Custom HTML Reports
    2-We can add company or project specific information in the report configuration

    SUMMARY: Extent Reports and Extent HTML Reporter is used to add custom information on
    the report and create the report in a PATH

    SET UP:
    1-Add Extent reports dependency on a maven project
         https://mvnrepository.com/artifact/com.aventstack/extentreports
    2-Create a class : Day_ExtentReports

     after creating report:
     //test-output-->reports-->right click on repost-->open in-->browser-->chrome  -->to se the report
    //open in explorer-->to see where is the report

     */

    protected static ExtentReports extentReports;   //is used for the file generation, it created empty report
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;     //when ever we need to log we use it.

    @BeforeClass
    public static void extentReportsSetUp(){

        // REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";

        // creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);  //we can add more custom information on our reports.

        // creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();

        // ***************
        //adding custom System Info, adding some information
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Application","TechProEd");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Team","Eagles");
        extentReports.setSystemInfo("SQA","John Fox");
        extentReports.setSystemInfo("Sprint Number","SP205");

        // adding more custom info
        extentHtmlReporter.config().setReportName("TechProEd home page");
        extentHtmlReporter.config().setDocumentTitle("TechProEd extent reports");

        // ********************
        // DONE WITH CONFIGURATION
        extentReports.attachReporter(extentHtmlReporter);
        //Summary: Extent Reports and Extent HTML Reporter is used to add custom information on the record and create report in a path.

        // REPORT IS DONE. NOW CREATING EXTENT TEST TO LOG INFO IN THE TEST CASE
        // Creating extent test
        extentTest= extentReports.createTest("My Extent Reporter","Regression Test Report");
    }

//Extent Report : it is just to print the information on your test cases.
    @Test
    public void extentReportsTest(){

        driver.get("https://techproeducation.com/");
        extentTest.pass("User is on TechPro Education Home page");  //like sout, but when we use sout, we can just see it on the terminal
                                                                           //but nobody check console, we check documents, reports

        //click on LMS
        driver.findElement(By.linkText("LMS LOGIN")).click();
        extentTest.pass("User is on LMS Home page");

        //verify the url
        String expectedUrl = "https://lms.techproeducation.com/";
        String actualUrl = driver.getCurrentUrl();
        extentTest.pass("Asserting the LMS URL");

        Assert.assertEquals("LMS LOGIN page is not displayed",  expectedUrl, actualUrl);        //

        extentTest.pass("TEST IS COMPLETE");

    }


    @Test
    public void extentReportsTest2(){

        //pass is used to mark the step as PASSED
        extentTest.pass("PASS");    //like sout, we put information on the report

        //info is used to just give an information for that step
        extentTest.info("INFO");

        //fail is used to mark the step as FAILED
        extentTest.fail("FAILED");

        // skip is used to mark the step as SKIPPED
        extentTest.skip("SKIPPED");

        //warning is used to give warning information
        extentTest.warning("WARNING");

    }


    @AfterClass
    public static void extentReportsTearDown(){
        extentReports.flush();      //for generating the report
    }

    //test-output-->reports-->right click on repost-->open in-->browser-->chrome
    //open in explorer-->to see where is the report

}
























