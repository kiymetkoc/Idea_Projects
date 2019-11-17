package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");




        for(String each : urls){
            driver.get(each);
            BrowserFactory.wait(2);
            String nameTitle = driver.getTitle();
            String title = driver.getTitle().replace(" ", "");
            System.out.println("Title: "+nameTitle+ "\nUrl: "+ each + "\nIs url contained in title?: "+each.toLowerCase().contains(title.toLowerCase()));
            System.out.println("--------------------------------");
        }

        driver.close();

    }
}
