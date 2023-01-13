package MyPractice.MixedTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q9_Godaddy {

    /*
1. Test Case - Search domain name and validate that domain is available or not.
Steps to Automate:
1. Launch browser of your choice like, firefox, chrome etc., using selenium webdriver.
2. Open website url - https://godaddy.com/
3. Maximize browser window.
4. Set timeout using implicit wait command of Selenium Webdriver.
5. Click on the first menu link, which is 'Domains'. It will open up a sub-menu, click on the 'Domain Name Search' link from the sub-menu.
6. Get the value of title of 'Domain Name Search' page using Selenium Webdriver's command in your script and print it.
7. We'll match value fetched in step 7 with expected value, if it's matched then proceed to next step either failed the test case.
8. Verify that search box is present on the page and it's enabled by using selenium commands.
9. Verify that "Buy It" button is available along with search box.
10. Enter some test value in the search box, like "mydomain" and click on "Buy It" button.
11. If domain is available then verify that "Add to Cart" button is present alongside domain name.
12. Verify that price of the domain is also displaying alongside domain name.

     */

@Test
    public void setUp() throws InterruptedException {

    //1. Launch browser of your choice like, firefox, chrome etc., using selenium webdriver.
    System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    //2. Open website url - https://godaddy.com/
    driver.get("https://godaddy.com/");

    //3. Maximize browser window.
    driver.manage().window().maximize();

    //4. Set timeout using implicit wait command of Selenium Webdriver.
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15))    ;


    //5. Click on the first menu link, which is 'Domains'. It will open up a sub-menu, click on the 'Domain Name Search' link from the sub-menu.
    driver.findElement(By.id("id-fb016f7a-780c-492d-92dc-b1627d458523")).click();
    System.out.println("0.1");
    driver.findElement(By.id("id-1601340d-b852-40f4-b456-8f8f2b11e6e8")).click();
    System.out.println("0.2");

    //6. Get the value of title of 'Domain Name Search' page using Selenium Webdriver's command in your script and print it.
    String title = driver.getTitle();
    System.out.println(title);
    System.out.println("1");

    //7. We'll match value fetched in step 7 with expected value, if it's matched then proceed to next step either failed the test case.
    WebElement domeneText = driver.findElement(By.xpath("//h1[text()='Søk etter og kjøp ledige domenenavn']"));
    Assert.assertTrue(domeneText.isDisplayed());
    System.out.println("2");

    //8. Verify that search box is present on the page and it's enabled by using selenium commands.
    driver.findElement(By.id("id-01f83ce4-22c2-4bac-9d02-921bd0834310"));   //go to home page
    WebElement searchBox = driver.findElement(By.xpath("//input[@name='domainToCheck']"));
    Assert.assertTrue(searchBox.isEnabled());
    System.out.println("3");

    //9. Verify that "Buy It" button is available along with search box.
    WebElement buyItButton = driver.findElement(By.xpath("//button[@type='Submit']"));
    Assert.assertTrue(buyItButton.isEnabled());
    System.out.println("4");
    Thread.sleep(3000);

    //10. Enter some test value in the search box, like "mydomain" and click on "Buy It" button.
    searchBox.sendKeys("mydomain");
    buyItButton.click();
    System.out.println("5");

    //11. If domain is available then verify that "Add to Cart" button is present alongside domain name.
    WebElement text = driver.findElement(By.xpath("//div[text()='Domenet ditt er tilgjengelig!']"));
    Assert.assertTrue(text.isDisplayed());
    WebElement addToCartButton = driver.findElement(By.xpath("//button[@class='ux-button button-primary-teal cart-button ']"));
    addToCartButton.click();
    System.out.println("6");

    //12. Verify that price of the domain is also displaying alongside domain name.
    WebElement price = driver.findElement(By.xpath("//span[@data-cy='terms-pricing-main-price']"));
    Assert.assertTrue(price.isDisplayed());
    System.out.println("7");

}
}




