package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FramesPractice {
   private WebDriver driver;
    @BeforeMethod
     public void setUp(){
         driver= BrowserFactory.getDriver("chrome");
         driver.get("http://practice.cybertekschool.com/frames");
     }

     @Test(description="iFrame example")
     public void Test1(){
     driver.findElement(By.linkText("iFrame")).click();
     //since element inside a frame , element is not visible for selenium
         //without switching to the frame me based on id name index(starting from 0), web  element
         //we can switch to fra
       driver.switchTo().frame("mce_0_ifr");

       //without switching , we cannot see inner html document
         //which one to use ? id, name , index, weblement?
         // 1. id or name <iframe id="mce_0_ifr" name="some_frame">
         // 2.webelement driver.findElement(By.cssSelector("iframe[class='some-frame']"));
         // 3. index [iframe1, iframe2, iframe3...]
         WebElement inputArea = driver.findElement(By.id("tinymce"));

         String  actualText = inputArea.getText();
         String expectedTest="Your content goes here.";
         Assert.assertEquals(actualText,expectedTest);
         BrowserUtils.wait(2);

         inputArea.clear(); // to delete text
         inputArea.sendKeys("Java is fun");
         BrowserUtils.wait(3);
         // to exit
         driver.switchTo().defaultContent();

     }

     // in case of nested frames we must to first frame ---> then again to an other frame, that is inside
    // html
    //frame#1
    //frame#2
     @Test(description = "nested frames")
    public void Test2(){
     driver.findElement(By.linkText("Nested Frames")).click();
     driver.switchTo().frame(driver.findElement(By.cssSelector("[name='frame-bottom']")));
     WebElement content = driver.findElement(By.tagName("body"));
         System.out.println(content.getText());
         driver.switchTo().defaultContent(); // to exit from all frames, got to first floor
         driver.switchTo().frame("frame-top");// second floor
         driver.switchTo().frame(("frame-left"));// third floor
         System.out.println(driver.findElement(By.tagName("body")).getText());// print text of body


     }


     @AfterMethod
    public void teardown(){

        driver.quit();
    }
}
