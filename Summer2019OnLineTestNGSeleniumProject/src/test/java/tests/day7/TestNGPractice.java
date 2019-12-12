package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGPractice {


    @Test
    public void test(){

        Assert.assertEquals("apple","apple","Word is not correct");

    }

    @Test
    public void verifyTitle(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        String eTitle ="Practice";
        String actTitle = driver.getTitle();
        Assert.assertEquals(eTitle,actTitle,"title is wrong");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    @Test( description="Verify that  heading is displayed")
    public void verifyHeadingIsDisplayed(){

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        WebElement message =driver.findElement(By.xpath("//span[@class='h1y']"));
        String actualTitle= message.getText();
        String expectedTitle = "Test Automation Practice";
       // Assert.assertTrue(message.isDisplayed());
        Assert.assertTrue(message.isDisplayed(),"Element is not visible");

        driver.quit();
    }
}
