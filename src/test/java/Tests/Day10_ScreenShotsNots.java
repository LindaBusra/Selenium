package Tests;

public class Day10_ScreenShotsNots {

    /*
    As tester what do you do?
    1-Create manual and automation test cases
    2-Prepare test reports
        a-Test Execution and Capture screenshots
        b-Report bugs when and bug is found. Takes screenshot of the bug steps.
    3-Run smoke tests and check results. Communicate with the team if any test fails.
    4-Run regression tests.


    In testing, reporting is very essential.
    Documentation of the test results
    Test Reports
    Should have test steps
    Test results(passes or failed)

    Screenshots
    If a test case fails, then we should take screenshot for raising the bug
    If a test case pass, then we should take screenshot as a proof.

    With selenium 3/4, taking the entire screen show is possible
            Use TakeScreenshot api and getScreenshotAs method is used for taking the screenshot
    With selenium 4, we can even take the screenshots of specific elements

            WebElement logo = driver.findElement (By.xpath(“//div[@id=’divLogo’]//img”));
            File file = logo.getScreenshotAs(OutputType.FILE);
            File destFile =new File(“logo.png”);
            FileUtils.copyFile(file,destfile);
     */



}
