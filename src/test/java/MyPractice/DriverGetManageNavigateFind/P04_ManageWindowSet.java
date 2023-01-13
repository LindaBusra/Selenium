package MyPractice.DriverGetManageNavigateFind;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P04_ManageWindowSet {


    //1. Yeni bir Class olusturalim.C07_ManageWindowSet
    //2. Amazon soyfasina gidelim. https://www.amazon.com/
    //3. Sayfanin konumunu ve boyutlarini yazdirin
    //4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
    //5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
    //8. Sayfayi kapatin

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");

        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());


        driver.manage().window().setPosition(new Point(0,0));                   //x,y
        driver.manage().window().setSize(new Dimension(300,500));       //width, height

        int xPos = driver.manage().window().getPosition().getX();
        int yPos = driver.manage().window().getPosition().getY();

        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();

        System.out.println( "xPos: " + xPos +"  "+ "yPos: " +  yPos +"   "+ "width: " +width+"  "+ "height: " + height);


        if(xPos==0 && yPos==0  &&  width == 300 && height==500) System.out.println("Test passed!");
        else System.out.println("Test failed!");


        //Test failed !!!













    }



}
