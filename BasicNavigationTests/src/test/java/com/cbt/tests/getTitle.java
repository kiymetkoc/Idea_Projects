package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getTitle {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://google.com");
        String title = driver.getTitle();
        System.out.println(title);

      BrowserFactory.wait(5);



        driver.close();


    }
}