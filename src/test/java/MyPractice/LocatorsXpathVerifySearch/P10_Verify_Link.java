package MyPractice.LocatorsXpathVerifySearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P10_Verify_Link {



    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://a.testaddressbook.com");

        WebElement signIn=driver.findElement(By.id("sign-in"));
        signIn.click();

        WebElement textBox=driver.findElement(By.className("form-control"));
        WebElement passwordTextBox=driver.findElement(By.name("session[password]"));
        WebElement signInButton=driver.findElement(By.name("commit"));

        textBox.sendKeys( "testtechproed@gmail.com"  );
        passwordTextBox.sendKeys("Test1234!");

        Thread.sleep(3000);

        signInButton.click();


        WebElement userId=driver.findElement(By.className("navbar-text"));

        String actualUserID=userId.getText();
        String expectedUserId="testtechproed@gmail.com";

        System.out.println(expectedUserId.equals(actualUserID) ? "Test PASSED" : "Test Failed"  );


        //f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).

        WebElement adresText=driver.findElement(By.linkText("Addresses"));
        WebElement signOut=driver.findElement(By.linkText("Sign out"));

        System.out.println(adresText.isDisplayed());
        System.out.println(signOut.isDisplayed());

        //3. Sayfada kac tane link oldugunu bulun

        List<WebElement> linkler=driver.findElements(By.tagName("a"));

        System.out.println("Sitede " + linkler.size() + " tane link vardır.");

        // Listteki linkleri yazdırın.

        for (WebElement e:linkler) {
            System.out.println(e.getText());
        }
        // Driveri kapatın

        driver.quit();

    }









}