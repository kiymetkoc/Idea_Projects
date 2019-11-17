package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserFactory;

public class demo {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("http://google.com");

        BrowserFactory.wait(2);

         //driver.getTitle();  no need to write again
         String title =  driver.getTitle();
        System.out.println(title);
        System.out.println(driver.getCurrentUrl());
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");
        BrowserFactory.wait(2);
        String title2 = driver.getTitle();
        System.out.println(title2);
        System.out.println(driver.getCurrentUrl());
       // System.out.println(driver.getPageSource()); // print page source
        WebDriver driver1 =BrowserFactory.getDriver("Firefox");
        driver1.get("https://www.yahoo.com/");
         String title3 = driver.getTitle();
        System.out.println(title3);
        driver1.manage().window().maximize();
        driver1.navigate().back();
        driver1.navigate().forward();

        driver.close();
        driver1.quit();

    }
}
