package tests.day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class LocatorsReview {
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @AfterMethod
  public void teardown(){
        driver.quit();
  }



  // locators: id, name, tag name, class name, css, xpath, linkText, partialLinkText
  @Test(description = "Verify checkboxes")
  public void test1(){

        driver.findElement(By.linkText("Checkboxes")).click();

        //since there are two elements with the same name
      //and I need only first one, I can use in css, :nth-of-type(index)

        WebElement checkbox1 = driver.findElement(By.cssSelector("[type='checkbox']:nth-of-type(1)"));

      // how to verify if check box is not clicked?
      Assert.assertFalse(checkbox1.isSelected(),"Checkbox 1 is selected");// assert that checkbox is not selected

  }
    @Test
    public void test2() {

        driver.findElement(By.linkText("Checkboxes")).click();
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@type='checkbox'][2]"));
         Assert.assertTrue(checkbox2.isSelected(),"Checkbox is not selected");
    }
    @Test(description = "")
    public void test3(){
        driver.findElement(By.linkText("Radio Buttons")).click();
        WebElement button = driver.findElement(By.xpath("//*[text()='Blue']/preceding-sibling::input[@type='radio']"));
       Assert.assertTrue(button.isSelected(),"Blue is not selected");
    }

    }
