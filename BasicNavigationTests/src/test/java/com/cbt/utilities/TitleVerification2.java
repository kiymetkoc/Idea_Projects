package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com/",
                                            "https://wayfair.com/",
                                             "https://walmart.com/",
                                             "https://westelm.com/");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        for(String each: urls){
            driver.get(each);
            BrowserFactory.wait(2);
            String nameTitle = driver.getTitle();
            String title = driver.getTitle().replace(" ","");
            System.out.println("Title: "+nameTitle+"\nUrl: "+each+"\nIs url contained in title?: "+each.toLowerCase().contains(title.toLowerCase()));
            System.out.println();
        }
        driver.close();
    }
}
