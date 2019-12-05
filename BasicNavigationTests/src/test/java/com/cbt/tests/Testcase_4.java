package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Testcase_4 {
/*
Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “123” into first name input box.
Step 4. Verify that warning message is displayed:
“first name can only consist of alphabetical letters”
 */

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserFactory.wait(2);
        driver.findElement(By.xpath("//*[@href='/registration_form']")).click();
        driver.findElement(By.xpath("//*[@class='form-control']")).sendKeys("123");
       WebElement message =driver.findElement(By.xpath("//*[@class='help-block']"));
       String actual_m =message.getText();
       String expected_m = "first name can only consist of alphabetical letters";

       if(actual_m.equals(expected_m)){
           System.out.println("Passed");
       }else{
           System.out.println("Failed");
       }
       driver.quit();

    }
}
