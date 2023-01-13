package Tests;

import org.junit.*;

public class Day02_JUnitAnnotations {

    /*
    * So far we kept using main method.
    * We no longer need to use main method to create test cases with Junit
    * @Test : is used to create test cases
    * NOTE:All @Test methods must be void.
    *
    * @Before : It runs before each @Test class. This is used to run repeated pre-conditions.
    * For example, setup, create driver, maximize window.
    * @After : It runs after each @Test class. This is used to run repeated after conditions.
    * For example, driver quit, report generation
    *
    * @BeforeClass : It runs before each CLASS only ONCE. This methods must be static. Otherwise you get Runtime exception
    * @AfterClass :  It runs after each CLASS only ONCE. Otherwise you get Runtime exception
    *
    * @Ignore :  It used to skip/ignore a test case.
     */

    @BeforeClass
    public static void setUpClass(){
        System.out.println("Before Class runs before the entire class ONCE\n");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After Class runs before the entire class ONCE");
    }

    @Before
    public void setUp(){
        System.out.println("Before Method Runs before each @Test annotation");
    }

    @After
    public void tearDown(){
        System.out.println("After Method Runs after each @Test annotation");
    }

    @Test
    public void test1(){
        System.out.println("Test 1");
    }


    @Test
    public void test2(){
        System.out.println("Test 2");
    }


    @Test @Ignore       //Test Ignored, this annotation is coming from JUnit
    public void test3(){
        System.out.println("Test 3");
    }


    @Test
    public void test4(){
        System.out.println("Test 4");
    }


    @Test
    public void test5(){
        System.out.println("Test 5");
    }

}
