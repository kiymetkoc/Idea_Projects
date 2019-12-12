package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Set;

public class WindowSwitching {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test(description = "switch to new tab")
    public void test1(){
        driver.findElement(By.linkText("New tab")).click();
        BrowserUtils.wait(4);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Practice","Title is wrong");


    }

    @Test(description = "Verify that user is able  to see new window ")
    public void test2(){
        driver.findElement(By.linkText("New tab")).click();
        String oldWindow = driver.getWindowHandle();
        BrowserUtils.wait(4);

        System.out.println(driver.getTitle());
        //in the selenium every window has an id. that id calls window handle
        // to read window handle we use method getWindowHandle()
        // after new window was opened , we can get list of all window id's
        Set<String>windowHandles = driver.getWindowHandles();


        for(String windowHandle :windowHandles){
            if(!windowHandle.equals(oldWindow)){
                driver.switchTo().window(windowHandle);
            }
        }
        System.out.println( driver.getTitle());

        Assert.assertEquals(driver.getTitle(),"Fresh tab","Title is wrong");
        String pageTitle ="Practice";
        for(String windowHandle : windowHandles){
            driver.switchTo().window(windowHandle);
           if( driver.getTitle().equals(pageTitle)){
               break;
           }
        }
        System.out.println(driver.getTitle());
    }
}
