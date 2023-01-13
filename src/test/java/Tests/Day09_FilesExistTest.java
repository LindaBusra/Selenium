package Tests;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FilesExistTest {

    /*
We can't test windows application with selenium. But we can use JAVA in testing.
We can use Java to check if a file exist on our computer or not

System.getProperty("user.dir"); =>gives the path of the current folder
System.getProperty("user.home"); =>gives you the user folder
Files.exists(Paths.get(“path of the file”)); =>Checks if a file path exist on your computer or not

When we download a file it goes in the downloads folder
We can use this Java concept to check if a downloaded file is in our download folder
     */
/*
    Class: FileExistTest
    Method: isExist
    Pick a file on your desktop
    And verify if that file exist on your computer or not  */

    @Test
    public void isExistTest(){

        String userDIR = System.getProperty("user.dir");     //gives the path of the current project folder
        System.out.println(userDIR);                         //C:\Users\busra\IdeaProjects\Selenium

        String userHOME = System.getProperty("user.home");    // =>gives you the user folder
        System.out.println(userHOME);

//    Pick a file on your desktop
//    And verify if that file exist on your computer or not

        String pathOfFile = userHOME + "/Desktop/logo.jpeg";    //Writing the path dynamically. This path can works on others computer
//        String pathOfFile = userHOME + "\\Desktop\\logo.jpeg";  //Windows

        boolean isExist = Files.exists(Paths.get(pathOfFile));    //returns true if file exists. Fallse the file does not exists
        Assert.assertTrue(isExist);  //Passes if fil exist, fails if files doesn't exists


    }
}
