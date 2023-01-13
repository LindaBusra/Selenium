package Tests;

import org.junit.Assert;
import org.junit.Test;

public class Day03_Assertions {

    @Test
    public void assertions(){


        /*
        What is assertion in testing?  Verifying that the expected and actualData is equal
        Assertion is done to check if expected result is equal to actual result.
        expected == actual -->pass
        expected != actual -->failed

        assertEquals("expected", "actual");
        assertTrue(true);  --> pass
        assertTrue(false);  --> fail

        assertFalse(false); --> pass
        assertFalse(true); --> fail                    */


        Assert.assertEquals(5,5);
        if("java".contains("apple")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        Assert.assertEquals("java","java");
        Assert.assertEquals(true, true);
        Assert.assertEquals("java".contains("j"), true);        //pass


        Assert.assertTrue("java".contains("j"));

        Assert.assertFalse("java".contains("j)"));      //pass

        //Test execution stops if the  assertion is fail. This is called HARD ASSERTION
        //Test execution continues even  if test verification fails.  Verification means like if statement.

        /*What is difference between Assertion and Verification
        1-Assertion stops after assertion fails. Verification continues even after verification fails
        2-Junit assertions are hard assertion. If statement is verification
        Note: TestNG has soft assertion as well. We will learn it in TestNG.

        */

        //Webelement-->html, body, form, label, input, a

























    }
}
