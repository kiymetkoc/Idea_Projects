package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
       /*
    Create	a	public	static	method getDriver which	takes	a	string	argument.
 If	you	are	using	Windows,	and if the	String	argument	is	`safari`,	return	null.	If
    you	are	using	Mac,	and if the	String	argument	is	`edge`,	return	null.
  */

    //default chrome browser is selected



    //default chrome browser is selected
    public static WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static WebDriver getDriver(String browser){

        String os = System.getProperty("os.name");

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if((os.charAt(0)+"").equalsIgnoreCase("M")){
            return new SafariDriver();
        } else if((os.charAt(0)+"").equalsIgnoreCase("W")) {
            return new EdgeDriver();
        } else {
            return null;
        }

    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
        }
    }

}
