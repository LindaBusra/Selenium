package MyPractice.Topics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T02_GoogleTranslate {

    static WebDriver driver;
    public static void translateEngToMarathi(WebDriver driver, String TextInEnglish) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");


        //driver = new ChromeDriver();


        driver.get("https://www.google.com/search?q=Google+Translate");

        WebElement FirstlanguageDropDown = driver.findElement(By.xpath("//div[@id='u4EBdf']/select"));
        selectFromList(FirstlanguageDropDown, "English");

        WebElement SecondlanguageDropDown = driver.findElement(By.xpath("//div[@id='cNCdzc']/select"));
        selectFromList(SecondlanguageDropDown, "Marathi");

        WebElement TextInEnglishTextBox = driver.findElement(By.xpath("//textarea[@id='tw-source-text-ta']"));
        TextInEnglishTextBox.sendKeys(TextInEnglish);
        Thread.sleep(2000);
        WebElement TextInMarathiTextBox = driver.findElement(By.xpath("//*[@id=\"tw-target-text\"]/span"));
        String MarathiText = TextInMarathiTextBox.getText();
        System.out.println(MarathiText);

    }

    public static void selectFromList(WebElement element, String textToBeSelected)
    {
        Select lang1= new Select(element);
        lang1.selectByVisibleText(textToBeSelected);
    }

    public static void main(String[] args) throws InterruptedException
    {


        translateEngToMarathi(driver, "It indeed a great pleasure that you are interested in Hexaware!!");
        //driver.quit();
    }
}