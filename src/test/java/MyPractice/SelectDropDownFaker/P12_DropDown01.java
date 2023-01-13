package MyPractice.SelectDropDownFaker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class P12_DropDown01 extends TestBase {

//Bir class oluşturun: DropDown
//https://the-internet.herokuapp.com/dropdown adresine gidin.
//1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
//2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
//3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
//4.Tüm dropdown değerleri(value) yazdırın
//5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.


    @Test
    public void test(){

        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropDown = driver.findElement(By.id("dropdown"));

        Select select = new Select(dropDown);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());


        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> options  = select.getOptions();
        options.stream().forEach(WebElement::getText);          //options.stream().forEach(t-> System.out.println(t.getText()));

        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        System.out.println(options.size()>=4 ? "True" : "False");

    }
}
