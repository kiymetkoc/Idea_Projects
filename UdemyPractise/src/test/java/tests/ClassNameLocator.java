package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class ClassNameLocator {
    public static void main(String[] args) {


        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://google.com");
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("hello");
        driver.findElement(By.name("pw")).sendKeys("12345");
        driver.findElement(By.id("Login")).click();

        driver.close();

    }
}