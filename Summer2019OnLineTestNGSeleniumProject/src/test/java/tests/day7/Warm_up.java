package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class Warm_up {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://cybertekschool.com/");

        // how to find all links?
        // every link as a tag name <a>
        // findElement = only 1 web element ==> If there is no element found, you will get exception.
        // findElements = 0 or more web elements ===>List can be empty, that means that element is not there ,
        //In this way, we can ensure that element doesn't present

        //   //a[.='Home'
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        System.out.println("Number of links: "+links.size());

        // to print text of every link
        for(WebElement webElement:links){
            if(!webElement.getText().isEmpty()){
            System.out.println(webElement.getText());
        }}
        driver.quit();
    }
}
