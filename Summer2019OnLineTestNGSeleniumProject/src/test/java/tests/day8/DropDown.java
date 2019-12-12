package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class DropDown {

    private WebDriver driver;
/*



*/
    @BeforeMethod
    public void Setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Dropdown")).click();
    }
    @Test(description = "Select option 2 from the dropdown")
    public void test1(){
       WebElement dropdown= driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        //how to verify that option 2 is selected

        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Option 2");


    }
    @Test(description = "select state")
    public void Test2(){
        WebElement state = driver.findElement(By.id("state"));
        Select select2 =new Select(state);
        select2.selectByVisibleText("Arizona");
        BrowserUtils.wait(2);
        Assert.assertEquals(select2.getFirstSelectedOption().getText(),"Arizona");

    }
    @Test(description = "print all states")
    public void Test3(){
        WebElement state =driver.findElement(By.id("state"));
        Select select =new Select(state);
        List<WebElement> states = select.getOptions(); // will return available options to select
        // how to print every options one by one

        for( WebElement option : states){
            System.out.println(option.getText());
        }
    }

    @Test
    public  void Test4(){
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
        select.selectByValue("AZ");
        BrowserUtils.wait(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Arizona");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
