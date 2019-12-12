package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class BitrixLogin {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/stream/?login=yes");
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("kiymetkoc@gmail.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("asdfgh");
        driver.findElement(By.xpath("//input[@class='login-btn']")).click();
        WebElement warningMessage= driver.findElement(By.xpath("//div[@class='errortext']"));
        System.out.println(warningMessage.getText());
        driver.quit();

    }
}
