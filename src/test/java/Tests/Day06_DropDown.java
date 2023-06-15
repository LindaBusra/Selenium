package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Day06_DropDown {

    /*
//Go to https://testcenter.techproeducation.com/index.php?page=dropdown
//1.Create method selectByIndexTest and Select Option 1 using index
//2.Create method selectByVisibleTextTest  Select Option 2 by visible text
//3.Create method selectByValueTest Select Option 1 value by visible text
//4.Create method printAllTest Print all dropdown value
//5. Verify the dropdown has Option 2 text
//6.Create method printFirstSelectedOptionTest Print first selected option
//7.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.         */


    WebDriver driver;

    @Before
    public void setUp(){

        // Create chrome driver by using @Before annotation and WebDriverManager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Go to https://testcenter.techproeducation.com/index.php?page=dropdown
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown ");
    }



    //1.Create method selectByIndexTest and Select Option 1 using index
    @Test
    public void selectByIndexTest() {

        //select option1 by index from the dropdown
        //1-locate the dropdown
        WebElement dropdown = driver.findElement(By.id("dropdown"));

        //Create Select object cause dropdown is in the select tag. this is for only dropdowns
        Select options = new Select(dropdown);

        //Select any option using the select object
        options.selectByIndex(1);       //index starts at 0.

    }



    //2.Create method selectByVisibleTextTest Select Option 2 by visible text
        @Test
        public void selectByVisibleTextTest(){


            WebElement dropdown = driver.findElement(By.id("dropdown"));
            Select options = new Select(dropdown);

            options.selectByVisibleText("Option 2");

        }


    //3.Create method selectByValueTest Select Option 1 value by visible text
    @Test
    public void selectByValueTextTest() throws InterruptedException {

        //2.Create method selectByValueTest Select Option 1 by visible text
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropdown);

        options.selectByValue("1");
        Thread.sleep(3000);     //hard wait, it comes from java. waits 3 seconds. dynamic wait. this will wait only if needed.




    }

    //4.Create method printAllTest Print all dropdown value

    @Test
    public void printAll() throws InterruptedException {

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);

        //getOptions(): returns all of the dropdown options
        List<WebElement> allOptions = select.getOptions();

        for (WebElement eachOption: allOptions) {
            System.out.println(eachOption.getText());
        }


        //5. Verify the dropdown has Option 2 text
        boolean isOption2Exist =false;

        for(WebElement eachOption : allOptions) {

            if(eachOption.getText().equals("Option 2")) {
                isOption2Exist = true;
            }
        }

        //fails if Option 2 is not in the dropdown
        //pass if Option 2 is in the dropdown
        Assert.assertTrue(isOption2Exist);

    }




    //6.Create method printFirstSelectedOptionTest Print first selected option
    @Test
    public void printFirstSelectedOptionTest() throws InterruptedException {

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);

        //printing the selected option.  that method return just selected option automatically
        System.out.println("Selected Option : " + select.getFirstSelectedOption().getText());       //output:Please select an option

        //Selecting a different option from dropdown
        select.selectByIndex(2);
        //printing the selected option
        System.out.println("Selected Option : " + select.getFirstSelectedOption().getText());       //output:Option 2


        //7.Find the size of the dropdown,
        // Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
        int numberOfOptions = select.getOptions().size();
        int expectedNumberOfOptions =3;

        //Assertion will print Expected is Not Equal Actual only if this assertion fails.
        Assert.assertEquals("Expected Is Not Equal Actual", expectedNumberOfOptions, numberOfOptions); //message(if assertion fails is print)

    }



    @After
     public void tearDown(){
            driver.close();
    }

    /*
    -What is a dropdown?
        ---Dropdown is a webelement. It has list of options.
    -How do you handle dropdown? What do you do to automate dropdown?
        ---Dropdowns are created using Select class. So we first locate the dropdown element, then use select class
        to interact with dropdown elements.
    -How do you select dropdown elements?
        ---We actually have 3 options to select a dropdown(index,value,visible text)
     */
}
