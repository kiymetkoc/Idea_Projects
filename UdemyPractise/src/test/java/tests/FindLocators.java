package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserFactory;

public class FindLocators {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("http://facebook.com");
        driver.manage().window().maximize();
        BrowserFactory.wait(2);
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println(driver.getCurrentUrl());

        // Id locator
        driver.findElement(By.id("email")).sendKeys("random@gmail.com");
        // name locator
        driver.findElement(By.name("pass")).sendKeys("Agh4lk6");
       // for logon button click
       // driver.findElement(By.id("u_0_b")).click();

        // linkText locator-forgot password
        driver.findElement(By.linkText("Forgot account?")).click();
        driver.close();
    }
}
