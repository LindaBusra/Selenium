package Practices.practice05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Q1 extends TestBase {

    //Calculate the total amount on the table
    //https://testpages.herokuapp.com/styled/tag/table.html

    /*
    Given
        Go to https://testpages.herokuapp.com/styled/tag/table.html
    When
        Calculate the total amount on the table
    Then
        Assert the amount
     */



    @Test
    public void test(){



    //Go to https://testpages.herokuapp.com/styled/tag/table.html
    driver.get("https://testpages.herokuapp.com/styled/tag/table.html");

    //Calculate the total amount on the table

    List<WebElement> list = driver.findElements(By.xpath("//tbody//tr/td[2]"));

    double sum = 0;
    for(WebElement w: list) {

        sum += Double.valueOf(w.getText());   //or sum += Double.parseDouble(w.getText());
    }

        System.out.println("The sum is : " + sum);

    //Assert the amount
    Assert.assertTrue(110.3 == sum);



    }
}
