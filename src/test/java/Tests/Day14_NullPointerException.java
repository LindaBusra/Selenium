package Tests;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Day14_NullPointerException {

   /*
   NullPointerException
    When a variable is created, but not instantiated, when pointer does not show any value then we get
    NullPointerException.
    It is common to  initialize the Driver, they we get the extraction. Driver driver;
    but never use driver=new ChromeDriver()
    For example, in my page object model, I create page objects in test classes but when I forgot to use
    new keyword to instantiate, then I get the exception

    Solution:
    Instantiate the variable    --> instantiate = initied--> means use new keyword  Faker faker = new Faker();

    null means --> we did not instantiated object. Pointer dores not show any value.
    We get NullPointerException when we declared variable but did not instantiated it.          */

    //Declared but never instantiated
    WebDriver driver;       //we dont extend TestBase, we just declared, but did not instantiated it.
    Faker faker;            //we just declared, but did not instantiated it. solution: Faker faker = new Faker();

    @Test
    public void nullPointerTest(){

        driver.get("https://www.techproeducation.com/");            //java.lang.NullPointerException


    }


    @Test
    public void nullPointerTest1(){

        System.out.println(faker.name().firstName());               //java.lang.NullPointerException


    }
}
