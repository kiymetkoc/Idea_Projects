package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class JSExecuterPractice {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");

    }

    @Test(description = "Scrolling with JavaScriptExecutor")
    public void test1(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for(int i=0; i< 10; i++){
            //move 500px down
//            Parameters
//            x-coord is the horizontal pixel value that you want to scroll by.
//            y-coord is the vertical pixel value that you want to scroll by.
            js.executeScript("window.scrollBy(0, 500)");
            BrowserUtils.wait(1);
        }
        BrowserUtils.wait(3);
    }
    @Test(description = "Scrolling with JSexecutor to specific element")
    public void test2(){
        driver.get("http://practice.cybertekschool.com/large");
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        BrowserUtils.wait(2);//for demo
//        js code from the browser
//        var footer = document.getElementById('page-footer');
//        footer.scrollIntoView(true);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //this script must scroll, until link element is visible
        //once link element will be visible, it will stop scrolling
        //arguments[0] = means first webelement after comma (link)
        //arguments it's an array of webelements after comma
        //arguments[0] = link web element, it can be any web element
        js.executeScript("arguments[0].scrollIntoView(true)", link);
        BrowserUtils.wait(2);


    }
    @Test(description = "click with JS executor")
    public void test3(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        //Example1 is the beginning of the phrase
        WebElement link1 =driver.findElement(By.partialLinkText("Example 1"));
        BrowserUtils.wait(2);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        //arguments[0] = link 1 web element
        //whnever regular selenium methods are not working, I use js executor
        js.executeScript("arguments[0].click()", link1);
        BrowserUtils.wait(2);
    }

    @Test
    public void test4(){
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement name = driver.findElement(By.name("full_name"));
        BrowserUtils.wait(2);
        WebElement email =driver.findElement(By.name("email"));
        BrowserUtils.wait(2);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value', 'John Smith')", name);
        js.executeScript("arguments[0].setAttribute('value','someemail@email.com')",email);
        WebElement button=driver.findElement(By.name("wooden_spoon"));
        js.executeScript("arguments[0].click()", button);
        BrowserUtils.wait(2);
    }
    @AfterMethod
    public void after(){
        driver.quit();
    }
}
