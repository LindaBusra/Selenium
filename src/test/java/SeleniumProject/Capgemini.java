package SeleniumProject;



import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Capgemini extends TestBase {

    /*
  Given
    Go to  https://www.capgemini.com/
  And
    Click on "Allow all cookies"
  When
    Go to on Global | EN
  And
    Search location for Norway | NO
  Than
    Click on Norway | NO button
  And
    Click on "Allow all cookies"
  Than
    Verify that "THE FUTURE OF WORK" displayed
  And
    Go to Careers
  Than
    Go to Find Your Future search button
  And
    Write "Lead" on search button and send it
  Than
    Select the first job
  And
    Click on "Apply" button
  Than
    Click on "Allow all cookies"
  And
    Fill your information
  And
    Click on Choose File Button
  Than
    Upload CV
  Than
    Verify the name of CV dislayed.
  And
    Click on Choose File Button
  Than
    Upload Cover Letter
  Than
    Verify the name of cover letter dislayed.
  And
    Select skills
  And
    Select Consent-Similar Roles
  And
    Select Consent-Assessments
  And
    Click on the confirm button
  Than
    Click on the submit button

   */

    @Test
    public void test() {

        //Go to  https://www.capgemini.com/
        driver.get("https://www.capgemini.com/");

        //Click "Allow all cookies"
        WebElement acceptCookies = driver.findElement(By.id("macs_cookies_accept_all"));
        if (acceptCookies.isDisplayed()) {
            acceptCookies.click();
        }
        waitFor(5);


        //Click Global | EN
        driver.findElement(By.xpath("//a[@href='#']//span[@class='inner']")).click();
        waitFor(2);

        //Search location for Norway | NO
        driver.findElement(By.id("search-location-input")).sendKeys("Norway | NO", Keys.ENTER);
        waitFor(2);

        //Click Norway | NO
        clickByJS(driver.findElement(By.xpath("//a[@href=' /no-no/ ']")));
        waitFor(2);

        //Click on "Allow all cookies"
        WebElement declineCookies = driver.findElement(By.id("macs_cookies_accept_all"));
        if (declineCookies.isDisplayed()) {
            declineCookies.click();
        }
        waitFor(2);

        //Verify that "THE FUTURE OF WORK" displayed
        WebElement text = driver.findElement(By.xpath("//a[text()='THE FUTURE OF WORK']"));

        Assert.assertTrue(text.isDisplayed());
        System.out.println("1");
        waitFor(2);

        //Go to Careers
        driver.findElement(By.linkText("Careers")).click();
        waitFor(2);
        System.out.println("2");

        //Go to Find Your Future search button
        //Write "Lead" on search button and send it
        WebElement searchButton = driver.findElement(By.xpath("//input[@aria-label='Search for a role']"));
        waitForVisibility(searchButton, 5);
        searchButton.sendKeys("Lead", Keys.ENTER);
        waitFor(2);
        System.out.println("3");

        //Select the first job
        driver.findElement(By.xpath("//a[@class='table-tr filter-box tag-active joblink']//div[1]")).click();
        System.out.println("4");
        waitFor(2);

        //Click on "Apply" button
        driver.findElement(By.xpath("//a[@class='cta-link']")).click();
        System.out.println("5");
        waitFor(2);

        //Click on "Allow all cookies"
        driver.findElement(By.id("js_consent-primary__btn")).click();
        System.out.println("6");
        waitFor(2);

        //Fill your information

        WebElement firstName = driver.findElement(By.id("id_first_name"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        actions.click(firstName)
                    .sendKeys(faker.name().firstName())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.name().lastName())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.internet().emailAddress())
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys("48480882")
                    .sendKeys(Keys.TAB)
                    .sendKeys("https://www.linkedin.com/in/Emily")
                    .sendKeys(Keys.ENTER).build().perform();
        waitFor(2);

        driver.findElement(By.id("id_message")).sendKeys("Det blir kjempegøy å jobbe hos Capgemini");

        //Click on Choose File Button
        //Upload CV
        WebElement chooseFileButton1 = driver.findElement(By.id("id_cv_fileinput"));
        String pathFileForCV = System.getProperty("user.home") + "\\Downloads\\CV.txt";
        chooseFileButton1.sendKeys(pathFileForCV);

        //Verify the name of CV dislayed.
        WebElement cvUploadedText = driver.findElement(By.id("js-id_cv_filename"));
        Assert.assertTrue(cvUploadedText.isDisplayed());
        waitFor(2);

        //Click on Choose File Button
        //Upload Cover Letter
        WebElement chooseFileButton2 = driver.findElement(By.id("id_cover_letter_fileinput"));
        String pathFile = System.getProperty("user.home") + "\\Downloads\\CoverLetter.txt";
        chooseFileButton2.sendKeys(pathFile);

        //Verify the name of cover letter dislayed.
        WebElement coverPageUploadedText = driver.findElement(By.id("js-id_cover_letter_filename"));
        Assert.assertTrue(coverPageUploadedText.isDisplayed());
        waitFor(2);

        //Select skills
        driver.findElement(By.xpath("//label[@for='id_company_question_228460_3_2']")).click();

        //Select Consent-Similar Roles
        driver.findElement(By.xpath("//label[@for='id_company_question_62662_4_0']")).click();

        //Select Consent-Assessments
        driver.findElement(By.xpath("//label[@for='id_company_question_62663_5_0']")).click();

        //Click on the confirm button
        driver.findElement(By.id("id_terms")).click();


        //Click on the submit button
//        driver.findElement(By.id("submit-id-submit")).click();

        //Question: Privacy Policy  ?     --- > Main Page, in the bottom ---> Privacy notice

    }
    }

