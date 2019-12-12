package tests.day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbsoluteXpathTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://login1.nextbasecrm.com/?login=yes");
        driver.findElement(By.className("login-btn")).click();
       //driver.findElement(By.xpath("//*[@id=\"login-popup\"]/div[2]"));

        WebElement WarningMessage=driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/div/div/div[2]"));
        System.out.println(WarningMessage.getText());
        driver.quit();

    }}