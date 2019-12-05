package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class Testcase2 {
/*
Step 1. Go to https://practice-cybertekschool.herokuapp.comStep
2. Verify that number of listed examples is equals to 48.
Hint: use findElemnts() and size() methods.
*/

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

        int elements = driver.findElements(By.xpath("//*[@class='list-group-item']")).size();

        int expected_r=48;
        int actual_r=elements;

        if(expected_r==actual_r){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

       driver.quit();


    }
}
