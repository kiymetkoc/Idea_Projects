package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class X_path {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().fullscreen();
        driver.get("https://login.salesforce.com/");
        BrowserFactory.wait(2);
        driver.findElement(By.id("username")).sendKeys("hello");
        BrowserFactory.wait(2);
        driver.findElement(By.name("pw")).sendKeys("123");
        BrowserFactory.wait(2);
        driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
        BrowserFactory.wait(5);
        WebElement message = driver.findElement(By.xpath("//*[@id=\"error\"]"));
        String actual_message= message.getText();
        System.out.println(actual_message);
        System.out.println( driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        String expected_m ="Please check your username and password. If you still can't log in, contact your Salesforce administrator."
;
       /* if(expected_m.equals(actual_message)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }*/
       String r="";
       r =  expected_m.equals(actual_message) ?"Passed": "Failed";
        System.out.println(r);
        driver.quit();

    }
}
