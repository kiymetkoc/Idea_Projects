package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Testcase_1 {
    /*Test case #1 Step
    1. Go to https://practice-cybertekschool.herokuapp.comStep
    2. Click on “Sign Up For Mailing List”Step
     3. Enter any valid nameStep
     4. Enter any valid emailStep
     5. Click on “Sign Up” buttonExpected result:
      Following message should be displayed:
       “Thank you for signing up. Click the button below to return to the home page.”
       Home button should be displayed.

     */

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/ ");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.xpath("//*[@name='full_name']")).sendKeys("Kiymet Koc");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("kiymetkoc44@gmail.com");
        driver.findElement(By.xpath("//*[@name='wooden_spoon']")).click();
       WebElement message= driver.findElement(By.xpath("//*[@name='signup_message']"));
      String actual_message= message.getText();

       String expected_message="Thank you for signing up. Click the button below to return to the home page.";

        String result="";
       if(actual_message.equals(expected_message)){
            result= "Passed";
           //System.out.println(result);

       }else{
            result="Failed";
          // System.out.println(result);
       }
        System.out.println(result);
         driver.quit();






    }






}
