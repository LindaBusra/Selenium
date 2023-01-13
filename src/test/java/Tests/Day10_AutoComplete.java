package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Day10_AutoComplete extends TestBase {          //or AutoSuggestions

//Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
//when user type "uni" in the search box
//and select the United Kingdom from the suggestions
//And click on submit button
//Then verify the result contains "United Kingdom"


    @Test
    public void autoCompleteTest(){

        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        //when user type "uni"

        driver.findElement(By.id("myCountry")).sendKeys("uni");

        //and select the United Kingdom from the suggestions
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();

        //And click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();

        //Then verify the result contains "United Kingdom"
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));



        }


    @Test
    public void autoCompleteTestWithReusableMethod() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        searchAndSelectFromList("uni", "United Kingdom");

        searchAndSelectFromList("an", "Angola");

        searchAndSelectFromList("bah", "Bahamas");

    }
    }



