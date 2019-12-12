package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class DragAndDropPractice {
    @Test
    public void Test1(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        //moon is a draggable object
        //earth  is target , we want to drop draggable object (big ball)
        WebElement moon =driver.findElement(By.id("draggable"));
        WebElement earth = driver.findElement(By.id("droptarget"));

        BrowserUtils.wait(3);
       actions.dragAndDrop(moon, earth).perform();
        driver.quit();
    }
}
