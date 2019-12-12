package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class EnterTextPractice {

    public static void main(String[] args) {
        //grey text "browser" is not a value
        //it's a placeholder/ or name of the method parameter
        //you dn't enter that
        //it comes up automatically
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement inputBox = driver.findElement(By.name("email"));
        inputBox.sendKeys("random@email.com");
        WebElement button=driver.findElement(By.id("from_submit"));
        button.click();
        BrowserUtils.wait(2);
        String expectedUrl="http://practice.cybertekschool.com/email_sent";
        String actualUrl = driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
        driver.close();
    }


}
