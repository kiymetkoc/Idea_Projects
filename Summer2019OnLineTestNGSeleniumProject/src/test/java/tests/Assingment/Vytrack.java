package tests.Assingment;
            // gghjjhjk
            /*hjjkjkjk
            jjkjk*/
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class Vytrack {

    public static void main(String[] args) {

        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");

        WebElement username=driver.findElement(By.name("_username"));
        username.sendKeys("user151", Keys.ENTER);

        WebElement password=driver.findElement(By.name("_password"));
        password.sendKeys("UserUser123");

         WebElement button=driver.findElement(By.id("_submit"));
         button.click();

        String expectedURL="https://qa2.vytrack.com/";
        String actualURL=driver.getCurrentUrl();

        BrowserUtils.wait(5);


        if(expectedURL.equals(actualURL)){
            System.out.println("Passed");

        }else{
            System.out.println("Test failed");
        }

        BrowserUtils.wait(3);

        driver.quit();
    }


}
