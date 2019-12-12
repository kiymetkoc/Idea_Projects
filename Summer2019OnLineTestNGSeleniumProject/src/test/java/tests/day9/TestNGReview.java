package tests.day9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGReview {
  //Only test annotation @Test is required
  // BeforeSuite --> runs as a precondition for entire suite.
  // Test suite can include tests from multiple test classes.
private WebDriver driver;
    @BeforeMethod
    public  void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        System.out.println("Before method");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
        System.out.println("After method");
    }

    @Test(description = "Verify title of google",priority = 2)
    // priority means test for this according tp its number priority
    // priority will change the order of test execution
    // by default tests are running in alphabetic order
    //lower priority - earlier execution
    public void Test1(){
driver.get("http://google.com/");
String acttitle = driver.getTitle();
String expected="Google";
        Assert.assertEquals(acttitle,expected,"Title is wrong");
        System.out.println(acttitle);
    }

    @Test(description = "verify title of apple.com",priority = 1)
    public void test2(){
        driver.get("https://www.apple.com/");
        String act=driver.getTitle();
        String exp= "Apple";

        Assert.assertEquals(act,exp,"Title is wrong");
        System.out.println(act);

    }


    //data provider can supply test with a test data. Also, it allows to do Data Driven Testing.
    //What is  this ? It is when same test runs multiple times with different test data set
 @DataProvider(name= "testData")
    public static Object [][] testData (){
        return new Object[][] { { "https://www.apple.com/","Apple"} ,{"http://google.com/","Google"}};

    }
@Test(dataProvider = "testData")
 public void testWithDataProvider(String url, String title){
        driver.get(url);
        Assert.assertEquals(driver.getTitle(),title);

 }


}
