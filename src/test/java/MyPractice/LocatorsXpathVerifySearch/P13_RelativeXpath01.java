package MyPractice.LocatorsXpathVerifySearch;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class P13_RelativeXpath01 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html  adresine gidin

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");


        WebElement bostonWE = driver.findElement(By.id("pid6_thumb"));
        WebElement sailorWE = driver.findElement(By.id("pid11_thumb"));
        WebElement mountie = driver.findElement(RelativeLocator.with(By.tagName("img"))
                .below(bostonWE).toLeftOf(sailorWE));
        System.out.println(mountie.getAttribute("id")); // pid10_thumb



        //ikinci bir kaynaktan !!!


        //2 ) Berlin’i  3 farkli relative locator ile locate edin

        // Önce üzerlerinden tarif yapacagımız web elementlerini locate etmeliyiz.
        WebElement boston=driver.findElement(By.xpath("//img[@id='pid6_thumb']"));
        WebElement sailor=driver.findElement(By.id("pid11_thumb"));
        WebElement bayArea=driver.findElement(By.id("pid8_thumb"));

        WebElement berlin1= driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(boston).toLeftOf(bayArea));
        WebElement berlin2=driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailor).toLeftOf(bayArea));

        String berlinAtt=berlin1.getAttribute("id");
        System.out.println(berlinAtt);


    }


}