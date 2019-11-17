package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTests {/*
   1.Open browser
   2.Go to website https://google.com
   3.Save the title in a string variable
   4.Go to https://etsy.com
   5.Save the title in a string variable
   6.Navigate back to previous page
   7.Verify that title is same is in step 3
   8.Navigate forward to previous page
   9.Verify that title is same is in step 5
*/

    public static void main(String[] args) {

        //WebDriver driver = BrowserFactory.getDriver("safari");
       // WebDriver driver = BrowserFactory.getDriver("chrome");
       // WebDriver driver = BrowserFactory.getDriver("firefox");

        WebDriver driver = BrowserFactory.getDriver("edge");



        driver.get("http://google.com");

        String title1 = driver.getTitle();
        driver.navigate().to("https://etsy.com");

        System.out.println(title1);
        String title2 = driver.getTitle();

        driver.navigate().back();
        StringUtility.verifyEquals(title1, driver.getTitle());
        System.out.println(title2);
        driver.navigate().forward();
        StringUtility.verifyEquals(title2, driver.getTitle());

        driver.close();
    }





}

