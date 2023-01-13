package MyPractice.DriverGetManageNavigateFind;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P06_ManageMethods3 {

    public static void main(String[] args) throws InterruptedException {

        //1. Yeni bir Class olusturalim.C06_ManageWindow
        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        //3. Sayfanin konumunu ve boyutlarini yazdirin
        //4. Sayfayi simge durumuna getirin
        //5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        //6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        //7. Sayfayi fullscreen yapin
        //8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        //8. Sayfayi kapatin


        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Position: " + driver.manage().window().getPosition());
        System.out.println("Size: " + driver.manage().window().getSize());

        //4. Sayfayi simge durumuna getirin
        driver.manage().window().minimize();
        Thread.sleep(3000);

        //5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        driver.manage().window().maximize();

        //6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Position in maximize: " + driver.manage().window().getPosition());
        System.out.println("Size in maximize: " + driver.manage().window().getSize());

        //7. Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();
        System.out.println("Position in fullscreen: " + driver.manage().window().getPosition());
        System.out.println("Size in fullscreen: " + driver.manage().window().getSize());

        driver.quit();




    }
}
