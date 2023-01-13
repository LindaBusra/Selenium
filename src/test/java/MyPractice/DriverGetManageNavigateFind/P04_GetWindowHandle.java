package MyPractice.DriverGetManageNavigateFind;

import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P04_GetWindowHandle {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println(driver.getWindowHandle());
        //CDwindow-A50D53893186EE11B583EC16EB0EF98C
        //returns the window's hashcode which is uniquely

        //get Position and size of the window
        System.out.println("first position of the window : " + driver.manage().window().getPosition());
        System.out.println("first size of the window : " + driver.manage().window().getSize());


        driver.manage().window().setSize(new Dimension(600,600));
        driver.manage().window().setPosition(new Point(50,50));
        System.out.println("last position of the window : : " + driver.manage().window().getPosition());
        System.out.println("last size of the window: " + driver.manage().window().getSize());


        //Verify new size
        Dimension actualSize = driver.manage().window().getSize();

        if(actualSize.getWidth()==600 && actualSize.getHeight()==600) {
            System.out.println("Size test passed");
        } else {
            System.out.println("Size test failed");
        }


        //Verify new Position
        Point actualPosition = driver.manage().window().getPosition();

        if(actualPosition.getX()==50 && actualPosition.getY()==50) {
            System.out.println("Position test passed");
        } else {
            System.out.println("Position test failed");
        }



        driver.close();
    }





}
