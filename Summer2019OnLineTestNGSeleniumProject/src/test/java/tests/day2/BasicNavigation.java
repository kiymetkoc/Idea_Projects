package tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();

        driver.manage().window().maximize(); // to maximize browser
        driver.get("http://google.com");
        driver.navigate().to("http://amazon.com");

    }
}
