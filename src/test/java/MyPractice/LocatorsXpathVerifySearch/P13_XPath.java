package MyPractice.LocatorsXpathVerifySearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P13_XPath {

    public static void main(String[] args) {

        // 1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        //2- Add Element butonuna basin
        //3- Delete butonu’nun gorunur oldugunu test edin
        //4- Delete tusuna basin
        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin


        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");


        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();     //!!!


        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));

        System.out.println(deleteButton.isDisplayed() ? "Delete button test passed" : "Delete button test does not passed");


        //Click delete button
        deleteButton.click();


        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//h3"));
//        WebElement addRemoveYaziElementi=driver.findElement(By.xpath("//h3[text()='Add/Remove Elements']"));

        if (addRemoveYaziElementi.isDisplayed()) {
            System.out.println("Add/Remove Elements test passed!");
        } else System.out.println("Add/Remove Elements test does not passed!");


        driver.close();

    }
}
