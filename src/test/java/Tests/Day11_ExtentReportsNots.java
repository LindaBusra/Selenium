package Tests;

public class Day11_ExtentReportsNots {

    /*
    Interview Questions:

    What is Extent Report:
    Extent report is a dependency, it is an API which I use in my framework. just like Selenium, just like webdriver.
    I use it  for generating custom reports/html reports.

    ★How do you get the report ?
    When I do manual testing, I capture the screenshot manually and save on a word doc, then upload the document to the JIRA
    When I automate the user story, I use extent reports for generation the test reports
    Extent reports is customizable.         //we can add information, it is changeable.
    I can configure the extent reports based on the project information
    In my project, we customized extent report in a way that it takes the screenshot automatically, when test case fails.


    ★What are the advantages of extent reports?
    Open source
    Works with different browsers and platform
    It works with different frameworks like junit, testng, cucumber
    We can log each step
    It is customizable


    ★How extent reports generates reports? How extent reports work?
    We are using maven, and I have the extent reports dependency
    I have a reusable class. In that class I have extent reports configuration
    Extent reports
    Extent Html Reporter. ====>>>>>>> are user for generation the reports
    Extent Tess
    For example, Extent reports and extent html reporter can be used for adding custom information such as platform, browser, environment,… And
    extent test object is used for logging the info such as pass, fail, skip…

    ★Where do you get your dependency?
    We have company internal repository. I check the repo and get the dependency.  (not from maven repository)
    For security reason I go and get it from company repository.


    ★What if the dependency is not in your company repository (for example extent report, then what question?
    I need to  raise a request for the dependency so the company can add. I ask the test lead, tech lead, manager,…
    "I need extent report, I need that"


    take a look --> https://www.extentreports.com/docs/versions/4/java/index.html

         */
}
