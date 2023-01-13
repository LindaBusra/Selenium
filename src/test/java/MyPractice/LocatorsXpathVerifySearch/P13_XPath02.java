package MyPractice.LocatorsXpathVerifySearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P13_XPath02 {

    // ...Exercise3...
    //fill the date
    //choose your profession -> Automation Tester
    //choose your tool -> Selenium Webdriver
    //choose your continent -> Antartica
    //choose your command  -> Browser Commands
    //click submit button

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        

        driver.findElement(By.id("ez-accept-all")).click();         //I accepted the cookies -->Continue with recommended cookies
//      driver.manage().deleteAllCookies();       //It does not work

//        driver.findElement(By.xpath("//a[@class='cc_btn cc_btn_accept_all']")).click();
//        driver.findElement(By.id("cookieChoiceDismiss")).click();


        //fill the firstname
        driver.findElement(By.name("firstname")).sendKeys("L. Busra");

        //fill the lastname
        driver.findElement(By.name("lastname")).sendKeys("Berg");

        //check the gender
        driver.findElement(By.id("sex-1")).click();

        //check the experience
        driver.findElement(By.id("exp-5")).click();

        //fill the date
        driver.findElement(By.id("datepicker")).sendKeys("10/12/2022");

        //choose your profession -> Automation Tester
        driver.findElement(By.id("profession-0")).click();
        System.out.println("profession is ok");

        //choose your tool -> Selenium Webdriver
        driver.findElement(By.id("tool-2")).click();
        System.out.println("selenium webdriver driver is ok");

        //choose your continent -> Antartica
        driver.findElement(By.xpath("//option[.='Antartica']")).click();                //!!!!!!!  I dont understand
//        driver.findElement(By.id("continents")).sendKeys("Afrika");  //try it
        System.out.println("Antartika is ok");

        //choose your command  -> Browser Commands
        driver.findElement(By.xpath("//option[text()='Browser Commands']")).click();    //!!!!!!!  I dont understand
//        driver.findElement(By.xpath("//option[normalize-space()='Browser Commands']")).click();
        System.out.println("Browser command is ok");

        //click submit button
        driver.findElement(By.id("submit")).click();
        System.out.println("Submit is okey");


        driver.quit();

























    }
}
