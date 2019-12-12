package tests.day7;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationTests {
    @BeforeMethod
    public void setUp(){
        System.out.println("Before method");
    }
    @AfterMethod
 public void tearDown(){
     System.out.println("After method!");
 }


    @Test
    public void test1(){
        System.out.println("Test 1!");
        Assert.assertTrue(5==5);
    }
    @Test
    public void test2(){
        System.out.println("Test 1!");
    }
    @Test
    public void test3(){
        System.out.println("Test 1!");
    }
    @Test
    public void test4(){
        System.out.println("Test 1!");
    }
}
