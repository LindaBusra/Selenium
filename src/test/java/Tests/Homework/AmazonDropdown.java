package Tests.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.*;

public class AmazonDropdown{

    /*
Create A Class: AmazonDropdown
Create A Method dropdownTest
1-Go to https://www.amazon.com/
2-Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
3-Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
4-Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
5-Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
6-Print the the total number of options in the dropdown
7-Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
8-BONUS: Assert if the dropdown is in Alphabetical Order

     */

    WebDriver driver;

    @Before
    public void setUp(){

        // Create chrome driver by using @Before annotation and WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @Test
    public void dropdownTest() {

        //1-Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //2-Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

        Select select = new Select(dropDown);



        //3-Print the first selected option and assert if it equals “All Departments”.
        // If it fails, then comment that code out and continue rest of the test case.

        String firstSelectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Test failed", "All Departments", firstSelectedOption);



        //4-Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
        // (after you select you need to use get first selected option method).
        // If it fails, then comment that code out and continue rest of the test case.

        List<WebElement> allOptions = select.getOptions();

//        Assert.assertEquals("Test failed", "Amazon Devices", allOptions.get(3).getText());    //it failed



        //5-Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.

        for(WebElement w: allOptions) {

            System.out.println(w.getText());
        }


        //6-Print the the total number of options in the dropdown
        System.out.println("the the total number of options in the dropdown : " + allOptions.size());


        //7-Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.

        boolean isOption =false;

        for(WebElement eachOption : allOptions) {

            if(eachOption.getText().equals("Appliances")) {
                isOption = true;
            }
        }

        System.out.println(isOption);       //Assert.assertTrue(isOption);  //verify



        //8-BONUS: Assert if the dropdown is in Alphabetical Order


        // 1- To store drop down options, I created a list
        List newList = new ArrayList();

        for(WebElement w : allOptions)
        {
            newList.add(w.getText());
        }



        // 2-A new list for alphabetical order
        List alphabeticalList = new ArrayList(newList);

        Collections.sort(alphabeticalList);


        Assert.assertTrue(newList.equals(alphabeticalList));



        driver.quit();

    }


}
