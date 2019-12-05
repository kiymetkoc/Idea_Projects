package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class CssSelector {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("https://www.facebook.com/");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        BrowserFactory.wait(2);
        driver.findElement(By.cssSelector("#email")).sendKeys("hello");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123");
        driver.findElement(By.cssSelector("#loginbutton")).click();
        WebElement message = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div/div/div"));
        String actual_m = message.getText();
        String expected_m = "The email or phone number you’ve entered doesn’t match any account. ";

        String result ="";

        result = actual_m.equals(expected_m)?"Passed" :"Failed";
        System.out.println(result);

        driver.quit();
    }
}
