package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserFactory;

public class Registration_form {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("hello");
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("uyhgfd");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("123kjjg");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("kiymetkoc44@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123jhhgf");
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("657-987-6540");
        Select select= new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        driver.findElement(By.cssSelector("input[value='male']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("10/10/1990");
        select.selectByVisibleText("SDET");
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserFactory.wait(2);

        WebElement message=driver.findElement(By.cssSelector( "h4[class='alert-heading']"));
         String am=message.getText();
         String ep="Well done!";

         String result="";
         result =(am.equals(ep))?"Passed" : "Failed";
        System.out.println(result);
        driver.quit();

    }

}
