package Tests.Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class H2 extends TestBase {

    //When user goes to https://jqueryui.com/datepicker/
    //And select the next date of the current date
    //EG if today is August 30, 2022 -> select August 31, 2022



    @Test
    public void test() {
        //  When user goes to https://jqueryui.com/datepicker/
        driver.get("https://jqueryui.com/datepicker/");

        //  And select the next date of the current date
        driver.switchTo().frame(0); //input iframe
        WebElement date = driver.findElement(By.id("datepicker"));
        Actions actions = new Actions(driver);
        actions.click(date);


        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);

        String nextDate = currentDate.plusDays(1).toString();
        date.sendKeys(nextDate);

        driver.switchTo().defaultContent(); //output iframe

    }


    @Test
    public void test1(){

        driver.get("https://jqueryui.com/datepicker/ ");
        driver.switchTo().frame(0);
        driver.findElement(By.id("datepicker")).click();

        String today= new SimpleDateFormat("MM/dd/yyyy").format(new Date());
        String justDay = today.substring(3,5);
        String expectedDay = String.valueOf(Integer.valueOf(justDay)+ 1);

        driver.findElement(By.xpath("//a[@data-date='" + expectedDay + "']")).click();

    }


    @Test
    public void test2(){

        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(0);
        driver.findElement(By.id("datepicker")).click();

        String currentDay= new SimpleDateFormat("MM/dd/yyyy").format(new Date());
        String[] todayArr = currentDay.split("/");

        int tomorrow = Integer.valueOf(todayArr[1])+1;
        String tomorrowDtr= String.valueOf(tomorrow);
        driver.findElement(By.xpath("//a[@data-date='"+tomorrowDtr+"']")).click();
    }



    @Test
    public void test03() {
        // When user goes to https://jqueryui.com/datepicker/
        driver.get("https://jqueryui.com/datepicker/");

        // Select the next date of the current date
        driver.switchTo().frame(0);
        driver.findElement(By.id("datepicker")).click();

        List<WebElement> allTableElements = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']"));
        System.out.println(allTableElements.size());

        String currentDate = new SimpleDateFormat("d").format(new Date());
        System.out.println(currentDate);

        for(int i =0; i<allTableElements.size();i++){
            if(allTableElements.get(i).getText().equals(currentDate)){
                allTableElements.get(i+1).click();
            }
        }

    }


    @Test
    public void dateSelect1(){
        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(0);
        driver.findElement(By.id("datepicker")).sendKeys("09/10/2023");

    }

    @Test
    public void dateSelect2(){
        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(0);
        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.xpath("//a[@data-date='10']")).click();

    }




}
