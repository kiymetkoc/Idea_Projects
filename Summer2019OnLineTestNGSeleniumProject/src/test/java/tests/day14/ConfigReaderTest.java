package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigurationReader;

public class ConfigReaderTest {

    /*
    # key = value, it's like a Map in java
    # is used for comment
    #Browser Type  ====> It is a comment
    browser=chrome

    #Url of our web Application
     url=https://qa1.vytrack.com/

   #Credentials
  user_name= storemanager85
  password= UserUser123
    * */

    @Test
    public void test1(){
        String expectedBrowser="chrome";
        //we write keys in "key" as a string
        // as a return , you will get value
        //key=value
        // we don't change property names, we change values
        //the idea is change in the one place , and effect entire framework
        //let's say every class will read browser type from properties file
        // and to perform cross -browsing testing, we can easily change value of browser property
        String actualBrowser= ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actualBrowser,expectedBrowser);
        System.out.println("URL: "+ConfigurationReader.getProperty("url"));
        System.out.println("UserName: "+ConfigurationReader.getProperty("user_name"));
        System.out.println("Password: "+ConfigurationReader.getProperty("password"));
    }

}
