package MyPractice.FileExistUploadDownload;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class P18_FileExist {

    @Test
    public void test(){

        System.out.println(System.getProperty("user.dir"));
        //icinde oldugum projenin dosya yolunu (path) verir.  C:\Users\busra\IdeaProjects\Selenium


        System.out.println(System.getProperty("user.home"));

        String filePath = System.getProperty("user.home") + "\\OneDrive\\Desktop\\text.txt";  //different part + comman part
        System.out.println(filePath);


        /* Bilgisayarimizdaki bir dosyanin varligini test icin, dosyaya erisim icin dosya yoluna (path) ihtiyac vardir
        Her bilgisayarin kullanici adi farli olacagindan masaustu dosya yolu da birbirinden farkli olacaktir.
        Testlerimizin tum bilgisayarlarda calismasi icin dosya yolunu DINAMIK yapmak zorundayiz
        Her bilgisayarin birbirinden farkli olan yolunu bulmak icin:  */

        //yukardaki kisim bende calismadigi icin ortak kisim kismini degistirdim test gecsin diye
        String differentPart = System.getProperty("user.home");
        String commanPart = "\\Downloads\\LambdaTest.txt";



        String desktopFilePath = differentPart + commanPart;

        System.out.println(Files.exists(Paths.get(desktopFilePath)));       //aslinda dosya yolu bu sekilde?? "C:\Users\busra\Desktop\text.txt.txt"
        Assert.assertTrue(Files.exists(Paths.get(desktopFilePath)));


    }
}
