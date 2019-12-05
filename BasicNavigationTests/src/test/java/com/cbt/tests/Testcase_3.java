package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Testcase_3 {
/*
Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Multiple Buttons”
Step 3. Click on “Button 1”
Verify that result message is displayed: “Clicked on button one!”
 */


    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Multiple Buttons")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        WebElement message= driver.findElement(By.xpath("//*[@id='result']"));
        String actual_m=message.getText();
        String expected_m="Clicked on button one!";

        if(actual_m.equals(expected_m)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        driver.quit();

    }
}
