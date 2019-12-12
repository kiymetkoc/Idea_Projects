package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FileUploading {
    private WebDriver driver;

    @BeforeMethod
    public  void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test(description = "verify that file was uploaded")
    public void Test1(){
       driver.findElement(By.linkText("File Upload")) .click();
       //provide path to the file
        // insert your path to the file into sendkeys() method
       driver.findElement(By.id("file-upload")).sendKeys("/Users/smayl/Desktop/String-charAt: length.rtf");
       //click submit
       driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(4);

        String expFilename ="String-charAt: length.rtf";
        String actualFileName= driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName,expFilename,"File wasn't uploaded");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
