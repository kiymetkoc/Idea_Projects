package tests.day11;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitsPractice    {

        private WebDriver driver;
        @BeforeMethod
        public void setup(){
            driver = BrowserFactory.getDriver("chrome");
            driver.get("http://practice.cybertekschool.com/");
        }
        @Test
        public void test1(){
            //this line should be before all findElement() methods
            //to wait within 10 seconds, until element is present
            //we apply it once, and it always works
            //put this line into @BeforeMethod and it will work for all tests
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.linkText("Dynamic Loading")).click();
            //partialLinkText we match only part of the link text
            //partialLinkText it's like contains text
            //Example 2: Element on the page that is rendered after the trigger - link text
            //Example 2 - only part of the link text
            //we can use partialLinkText locator to find element by partial text
            driver.findElement(By.partialLinkText("Example 2")).click();
            driver.findElement(By.tagName("button")).click();
            //this is for "Hello World!"
            WebElement finishElement = driver.findElement(By.id("finish"));
            System.out.println(finishElement.getText());
        }

        @Test
        public void test2(){
            driver.findElement(By.linkText("Dynamic Loading")).click();
            driver.findElement(By.partialLinkText("Example 1")).click();
            driver.findElement(By.tagName("button")).click();

            WebElement UserNameInputBox=driver.findElement(By.id("username"));

            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(UserNameInputBox));
            UserNameInputBox.sendKeys("tomsmith");
            WebElement passwordInputBox = driver.findElement(By.id("pwd"));

            wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
            passwordInputBox.sendKeys("SuperSecretPassword");
            WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
            wait.until(ExpectedConditions.elementToBeClickable(submit));
            submit.click();

            WebElement message =driver.findElement(By.tagName("h4"));

            wait.until(ExpectedConditions.visibilityOf(message));
            String expMessage="Welcome to the Secure Area. When you are done click logout below.";
            String actMessage = message.getText();
            Assert.assertEquals(expMessage,actMessage);
        }

        @Test
        public void test3(){
            driver.findElement(By.linkText("Dynamic Loading")).click();
            driver.findElement(By.partialLinkText("Example 5")).click();
            WebDriverWait wait= new WebDriverWait(driver,10);
            WebElement overlay= driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin']"));
            wait.until(ExpectedConditions.visibilityOf(overlay));

            WebElement UserNameInputBox=driver.findElement(By.id("username"));


            wait.until(ExpectedConditions.visibilityOf(UserNameInputBox));
            UserNameInputBox.sendKeys("tomsmith");
            WebElement passwordInputBox = driver.findElement(By.id("pwd"));

            wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
            passwordInputBox.sendKeys("SuperSecretPassword");
            WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
            wait.until(ExpectedConditions.elementToBeClickable(submit));

            submit.submit();

            WebElement message =driver.findElement(By.tagName("h4"));

            wait.until(ExpectedConditions.visibilityOf(message));
            String expMessage="Welcome to the Secure Area. When you are done click logout below.";
            String actMessage = message.getText();
            Assert.assertEquals(expMessage,actMessage);



        }
       /* @Test(description = "Fluent wait example")
        public void test4(){
            driver.findElement(By.linkText("Dynamic Loading")).click();
            driver.findElement(By.partialLinkText("Example 2")).click();
            driver.findElement(By.tagName("button")).click();

            Wait wait = new FluentWait(driver)
                     .withTimeout(Duration.ofSeconds(10))
                     .pollingEvery(Duration.ofMillis(200))
                     .ignoring(NoSuchElementException.class)
                     .ignoring(ElementNotVisibleException.class);

            WebElement message =(WebElement)wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.id("finish"));
                }
            });
            }*/






        @AfterMethod
        public void teardown(){
            driver.quit();
        }
}
