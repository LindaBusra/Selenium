package MyPractice.NotsInterview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class notes_duzenle {



    //https://github.com/gokhanagar/Selenium/blob/master/jUnit/src/test/java/day09_handlewindows_testBase/WindowHandleHomeWork.java
    //burdayim


    WebDriver driver;


    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @Test
    public void test1(){

        //We can verify if we can select multiple options in a static dropdown in
        // Selenium with the help of isMultiple() method. It returns a Boolean value of true or false.

        String url = "https://www.tutorialspoint.com/tutor_connect/index.php";
        Select s = new Select(driver.findElement(By.xpath("//select[@name=’selType’]")));

        // isMultiple() returns a boolean value
        boolean result = s.isMultiple();
        System.out.println(result);
        driver.close();



        WebDriver driver = new ChromeDriver();
        String url1 = " https://www.tutorialspoint.com/tutor_connect/index.php";
        driver.get(url1);
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        Select s11 = new Select(driver.findElement(By.xpath("//select[@name=’selType’]")));
        // getting the list of options in the dropdown with getOptions()
        List<WebElement> op = s11.getOptions();
        int size = op.size();
        for(int i =0; i<size ; i++){
            String options = op.get(i).getText();
            System.out.println(options);



            //------------------

//            WebDriver driver= new ChromeDriver();
//
//            driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
//
//            // Locating select tag web element
//            WebElement singleSelectTagDropdownWebElement= driver.findElement(By.xpath("//*[@id=\"select-demo\"]"));
//            Select dropdown = new Select(singleSelectTagDropdownWebElement);
//
//            // Get all options
//            List<WebElement> allOptionsElement = dropdown.getOptions();
//
//            // Creating a list to store drop down options
//            List options = new ArrayList();
//
//
//            for(WebElement optionElement : allOptionsElement)
//            {
//                options.add(optionElement.getText());
//            }
//
//            // Removing "Please select" option as it is not actual option
//            options.remove("Please select");
//
//            System.out.println("Options in dropdown with Default order :"+options);
//
//            // Creating a temp list to sort
//            List tempList = new ArrayList(options);
//
//            Collections.sort(tempList);
//
//            System.out.println("Sorted List "+ tempList);
//
//            boolean ifSortedAscending = options.equals(tempList);
//
//            if(ifSortedAscending)
//            {
//                System.out.println("List is sorted");
//            }
//            else
//                System.out.println("List is not sorted.");
//
//            driver.quit();




        }



        /*
        SELENIUM NEDİR ?

Selenium, bir web tarayıcısı otomasyonu için bir araçtır. Selenium, web tarayıcılarında belirli işlemleri otomatikleştirmeyi sağlar, böylece testleri otomatik hale getirebilir veya web sayfalarında belirli görevleri otomatikleştirebilirsiniz. Selenium, web tarayıcısının kendisi gibi çalışır ve tarayıcı üzerinde gerçekleştirilen eylemleri kopyalar, böylece gerçek bir kullanıcı gibi davranır.

SOFTWARE TESTING NEDİR ?

Software testing, bir yazılımın performansını, doğruluğunu, güvenilirliğini ve diğer özelliklerini test etme sürecidir. Testing, yazılımın beklenen davranışını doğrulamak ve beklenmeyen davranışları tespit etmek için kullanılan bir yöntemdir. Testing, yazılımın kalitesini artırmak için çok önemlidir ve genellikle yazılım geliştirme sürecinin bir parçası olarak yapılır. Testing, yazılımın kullanıcılar tarafından nasıl algılandığını ve kullanılacağını anlamaya yardımcı olur ve bu sayede yazılımın daha iyi hale getirilmesine yardımcı olur.

TEST OTOMATION NEDİR ?

Test otomasyonu, test süreçlerini otomatik hale getirme sürecidir. Test otomasyonu, testleri tekrar tekrar yapmak ve doğruluğunu sağlamak için kullanılan bir yöntemdir. Test otomasyonu, testlerin daha hızlı ve doğru bir şekilde yapılmasını sağlar ve bu sayede yazılım kalitesini artırır. Test otomasyonu ayrıca, testlerin tekrarlanabilirliğini ve karşılaştırılabilirliğini artırarak yazılımın geliştirilmesine yardımcı olur.

SELENIUM'A NEDEN İHTİYAC DUYULUR ?

Selenium, web tarayıcısında otomatikleştirilmiş işlemler yapmak için kullanılır. Örneğin, bir web sitesinin testlerini otomatikleştirebilir, bir web formunu otomatik olarak doldurabilir veya bir web sayfasının içeriğini otomatik olarak tarayabilirsiniz. Bu sayede zaman ve emek tasarrufu sağlar ve işlemlerin doğruluğunu artırır. Ayrıca, Selenium sayesinde web tarayıcısında belirli görevleri otomatikleştirebilir ve bu görevleri tekrarlayabilirsiniz, böylece işlemleriniz daha verimli hale gelir.

SELENIUM'UN BİLEŞENLERİ NELERDİR ?

Selenium, aşağıdaki bileşenlerden oluşur:
Selenium WebDriver: Bu, Selenium'un en önemli bileşenidir ve web tarayıcısını kontrol etmek için kullanılır. WebDriver, web tarayıcısının kendisi gibi çalışır ve tarayıcı üzerinde gerçekleştirilen eylemleri kopyalar, böylece gerçek bir kullanıcı gibi davranır.

Selenium Grid: Bu, birden fazla bilgisayarda ve web tarayıcısında testleri çalıştırmak için kullanılan bir araçtır. Selenium Grid, testlerin daha hızlı ve verimli bir şekilde yapılmasını sağlar.

Selenium IDE: Bu, Selenium testlerini kaydetme, düzenleme ve oynatma için kullanılan bir Firefox eklentisidir. Selenium IDE, test otomasyonu için hızlı ve kolay bir yol sunar.


         */



         /*
    * ***** What is alert?
    * Alerts are pop-ups generated by JS => Java scripts
    *
    * *****How do you handle Alerts?
    * Firstly I should switch the alerts then I can use accept, dismiss, getText, sendKeys
    * accept() => OK
    * dismiss() => Cancel
    * getText() => Returns text
    * sendKeys() => Types
    *
    * driver.switchTo().alert().getText();
    * driver.switchTo().alert().sendKeys();
    *
    * NOTE: If there is an alert on the page firstly we should handle
    * Without handling alert we can not continue on that page
    *
    *
    *
    * *****What is iFrame?
    * iFrame is used to add pages, maps, youtubes videos
    * iFrame generates html within the html
    * They can be accessed by using switchTo()
    *
    *
    * ****** How do you handle iFrames?
    * Firstly we should switch to iframe then we do automation
    * If the driver is not in the right frame, test case fails
    *
    * ***** How many way are there to switch to an iFrame?
    * There are 3 ways to switch to iframe => index, id/name, WebElement
    * *********************************************************************
    *  driver.switchTo().parentFrame(); //get 1 upper level by using parentFrame()
        driver.switchTo().defaultContent();//get us to default level
        *
        * ******How do you understand if an iframe on the page or not?
        * driver.findElement(By.xpath("//iframe")))
        * driver.findElements(By.xpath("//iframe")))
        *
         * Why your test case MIGHT FAIL?
         * 1. Incorrect Locator.
         * 2. Timing. Synchronized. - we already have enough timeout
         * 3. New Window
         * 4. JS Alerts
         * 5. IFrame
        AUTOMATION STEPS :
         * 1. Do Manual Testing first to understand the functionality
         *   -click on choose file
         *           - locate choose file input
         *   -select a file
         *           - use sendKeys(pathOfFile)
         *   -click upload
         *           -locate upload element and click on it
         *   -verify message : File Uploaded!
         *           -get the text of the message and do assertion




     */
    }
}
