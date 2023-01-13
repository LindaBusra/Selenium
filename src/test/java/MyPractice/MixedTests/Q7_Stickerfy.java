package MyPractice.MixedTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q7_Stickerfy extends TestBase {

    /*
    User goes https://stickerfy.herokuapp.com/
    add to cart 3 Happy 2 sad 1 angry stickerfy
    checking is cart have 6 product without going cart
    if it is 6 go to cart else add to cart some sticker
    remove all sad sticker
    remove 1 angry
    get total
    and checkout
     */


    @Test
    public void test() throws InterruptedException {

        driver.get("https://stickerfy.herokuapp.com/");





            driver.findElement(By.xpath("//a[@href='/add-to-cart/5dd8e2b26c26d0000a675cf9']")).click();
            driver.findElement(By.xpath("//a[@href='/add-to-cart/5dd8e2b26c26d0000a675cf9']")).click();
            driver.findElement(By.xpath("//a[@href='/add-to-cart/5dd8e2b26c26d0000a675cf9']")).click();
            driver.findElement(By.xpath("//a[@href='/add-to-cart/5dd8e2b26c26d0000a675cfb']")).click();
            driver.findElement(By.xpath("//a[@href='/add-to-cart/5dd8e2b26c26d0000a675cfb']")).click();
            driver.findElement(By.xpath("//a[@href='/add-to-cart/5dd8e2b26c26d0000a675cfa']")).click();


        WebElement shoppingCartItem = driver.findElement(By.xpath("//span[text()='6']"));

        Assert.assertEquals(shoppingCartItem.getText(), "6");

        driver.findElement(By.id("cart")).click();


        driver.findElement(By.xpath("//*[@id=\"products\"]/ul/li[2]/div/button[@data-toggle='dropdown']")).click();
        driver.findElement(By.xpath("//a[@href='/remove/5dd8e2b26c26d0000a675cfb']")).click();
        driver.findElement(By.xpath("//*[@id=\"products\"]/ul/li[2]/div/button[@data-toggle='dropdown']")).click();
        driver.findElement(By.xpath("//a[@href='/reduce/5dd8e2b26c26d0000a675cfa']")).click();

        WebElement total = driver.findElement(By.xpath("//html/body/div/div[2]/div/strong"));
        System.out.println(total.getText());

        driver.findElement(By.linkText("Checkout")).click();




    }
}
