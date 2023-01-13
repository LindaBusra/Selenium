package MyPractice.LocatorsXpathVerifySearch;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class P12_AmazonVerifyCategory extends TestBase {

    /*
    // https://www.amazon.com/ adresine gidin.
    //Arama kutusunun yanindaki kategori menusundeki kategori
    //sayisinin 28 oldugunu test edin
    //Kategori menusunden Books secenegini secin
    //Arama kutusuna Java yazin ve aratin
    //Bulunan sonuc sayisini yazdirin
    //Sonucun Java kelimesini icerdigini test edin
     */

    @Test
    public void test(){

        //https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");

        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        WebElement dropDownButton = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDownButton);

        List<WebElement> options  = select.getOptions();

        Assert.assertEquals("Test for option number failed", 28, options.size());

        // Kategori menusunden Books secenegini secin
        select.selectByValue("search-alias=stripbooks-intl-ship");

        //Arama kutusuna Java yazin ve aratin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java" + Keys.ENTER);

        //Bulunan sonuc sayisini yazdirin
        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(result.getText());

        //Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(result.getText().contains("Java"));

        //passed


    }
}
