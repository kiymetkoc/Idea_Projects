package tests.day10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class PopUp_Alerts {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @Test(description = "Click Ok in pop up message")
    public void Test1(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        BrowserUtils.wait(2);

        //to deal with popup, we can create object of alert
        //swithces to the  currently active modal dialog
        Alert alert = driver.switchTo().alert();
       alert.accept(); // to click ok
        BrowserUtils.wait(2);
    }
    @Test(description = "Click on the cancel in popup message")
    public void test2() {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[2]")).click(); //[2] means second button out of 3
        BrowserUtils.wait(2);
        Alert alert = driver.switchTo().alert(); // print text of popup message
        System.out.println(alert.getText());
        alert.dismiss(); // to click cancel
        BrowserUtils.wait(2);
        System.out.println(driver.findElement(By.id("result")));
    }
    @Test(description ="Click on  button three, enter some text and then click OK")
    public void test3(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        BrowserUtils.wait(2);
        driver.switchTo().alert().sendKeys("Java is fun");
        BrowserUtils.wait(2  );
        driver.switchTo().alert().accept();
        BrowserUtils.wait(2);
        System.out.println(driver.findElement(By.id("result")));

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
