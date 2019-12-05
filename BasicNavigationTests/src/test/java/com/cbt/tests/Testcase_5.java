package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Testcase_5 {
/*
Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “123” into last name input box.
Step 4. Verify that warning message is displayed:
“The last name can only consist of alphabetical letters and dash”
 */

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.xpath("//*[@href='/registration_form']")).click();
        driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("123");
        WebElement message = driver.findElement(By.xpath("//*[@class='help-block']"));
        String actual_m= message.getText();
        String expected_m="The last name can only consist of alphabetical letters and dash";

        if(actual_m.equals(expected_m)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        driver.quit();

    }
}
