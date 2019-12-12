package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class CssSelectorPractice {
    /*
    Which locator to use?
    id
    css
    xpath
     */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //Let's find all buttons, click on them one by one

        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
        for(WebElement button: buttons){
            button.click();
            BrowserUtils.wait(1);
            // get the message after click
            WebElement message = driver.findElement(By.cssSelector("#result"));
            // print a text of that message
            System.out.println(message.getText());

        }

        WebElement header = driver.findElement((By.cssSelector(".container > h3")));
        System.out.println(header.getText());
        WebElement p =driver.findElement(By.cssSelector("[class='container']"));
        System.out.println(p.getText());

       driver.quit();

    }
}
