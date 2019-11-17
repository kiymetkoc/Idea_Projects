package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Testcase1_SignUp {
    /*Test case #1
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
    Step 2. Click on “Sign Up For Mailing List”
    Step 3. Enter any valid nameStep
    4. Enter any valid emailStep
    5. Click on “Sign Up” buttonExpected result:
     Following message should be displayed:
     “Thank you for signing up. Click the button below to return to the home page.”
     Home button should be displayed

     */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
         driver.get("http://practice.cybertekschool.com/");
          driver.manage().window().maximize();
        WebElement element = driver.findElement(By.linkText("Sign up for our mailing list "));

    }
}
