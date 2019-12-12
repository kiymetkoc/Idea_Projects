package tests.day14;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tests.TestBase;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

public class LoginTest extends TestBase {

    @Ignore
    @Test
    public void test1(){
        //read the url from the properties file
        String url= ConfigurationReader.getProperty("url");
       // Driver.get()---->will return object
       //and then we can call webdriver methods like get(), findElement()...
        Driver.get().get(url);
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(2);
        Driver.close();
    }
    @Test
    public void test2(){
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(2);

    }

}
