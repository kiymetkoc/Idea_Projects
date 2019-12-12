package tests.day13;

import net.bytebuddy.TypeCache;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;
import java.util.SortedSet;

public class WebTablesPractice {
    private WebDriver driver;
   WebDriverWait wait;
    @BeforeMethod
    public void setup(){

    driver= BrowserFactory.getDriver("chrome");
    driver.get("http://practice.cybertekschool.com/tables");
    }

    @Test(description = "Print table 1 data")
    public void test1(){
      //  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));
        // --> if we get NoSuchElementException we can use wait method
        //<table> stands for web table in HTML
        // table1 is id of first table
        //once we find this table as aweb element , we can print all text from there
       //String table1= driver.findElement(By.xpath("//table[@id='table1']")).getText();
        //System.out.println(table1);
        // or
        WebElement table1= driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table1.getText());
    }
    @Test(description = "Verify that numbers of column table1 is equal to 6")
    public void test2(){
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));
        int actualColumnNumber=driver.findElements(By.xpath("//table[@id='table1']//th")).size();
        int expectedColumnNumber=6;
        Assert.assertEquals(actualColumnNumber,expectedColumnNumber);


    }

    @Test(description = "verify that tr= table rows equals 5")
    public void test3(){
        //   // means any child
        int actualTableRowNumber =driver.findElements(By.xpath("//table[@id='table1']//tr")).size();
        int expectedTableRowNumber = 5;

        Assert.assertEquals(actualTableRowNumber,expectedTableRowNumber);
    }
 // use findElements() to find all values from 2nd row
    //Then iterate through the collection of elements with  for each loop
    //Print text of every element from new line
    @Test(description = "Print all values from the 2nd row excluding table header")
    public void test4() {


        List<WebElement> row = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[2]//td"));
        for (WebElement cell : row
        ) {
            System.out.println(cell.getText());
        }
    }
        @Test(description = "Print all values from the n-th row excluding table header")
        public void test5() {
          // if index = 1, then it's a first row
            // if index = 2, then it's a second row
            // if we don't specify td index, it will take all td elements
            // in css selector we use space " ", in xpath // to get to any child
            //or in css we use">", in xpath /, to get direct child
            // cssSelector alternative: table[id='table1'] tbody tr:nth-of-type(2) td
            // if index will exceed table size, you will not get any errors , list will not get any errors, list will be just  empty
            // findElements() doessn't give NoSuchElementException , in any case.
            int i =1;
            List<WebElement> row = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr["+i+"]//td"));
            for (WebElement cell : row
            ) {
                System.out.println(cell.getText());
            }}
            @Test(description = "Verify that email in the 3rd row equals jdoe@hotmail.com ")
                    public void test6(){

                String expectedemail="jdoe@hotmail.com";
                String actualEmail =driver.findElement(By.xpath("//*[@id='table1']//tr[3]//td[3]")).getText();
                Assert.assertEquals(actualEmail,expectedemail);
/*
or
int row =3;
int column=3;
WebElement cell =driver.findElement(By.xpath("//*[@id='table1']//tr[+"row"+]//td[+"column"+]");
String exp ="jdoe@hotmail.com";
String act =cell.getText();
Assert.assertEquals(act,exp);
 */

        }

/*
* Get all values from email column and verify that every value contains "@"
* if no-fail test
* */

@Test(description = "Verify every email contains '@'")
public void test7(){
    List<WebElement>emails=driver.findElements(By.xpath("//*[@id='table1']//tr//td[3]"));
    //loop through collection of emails
    //td means 3rd column
    // we are skipping tr, because we need all rows
    // tr yerine tbody de yazabiliriz.
    for(WebElement email : emails){
        Assert.assertTrue(email.getText().contains("@"));
        System.out.println(email.getText());
    }
}
/*
@Test(description="Print all names in column 1
public void lastNames(){
    List<WebElement>names=driver.findElements(By.xpath("//*[@id='table1']//tr//td[1]"));
    for( WebElement name: lastNames){
        System.out.println(name.getText());
    }
}
*/

@Test(description = "Verify that after clicking on last name, values will be sorted in alphabetic order")
public void test8(){

    // Step1 : click on last name
    //Step 2: get all values from last name column
    // Step 3: Verify that column is sorted in alphabetic order

  WebElement lastNameElement= driver.findElement(By.xpath("//*[@id='table1']//tr[1]//th[1]"));
 lastNameElement.click();
 List<WebElement>lastNames= driver.findElements(By.xpath("//table[@id='table1']//tbody//td[1]"));
 /*bu method sadece isimleri cikariyor.
 for(WebElement lastName:lastNames){
     System.out.println(lastName.getText());
 }*/

 for(int i=0; i<lastNames.size()-1; i++){
     String lastName =lastNames.get(i).getText();
     String followingLastname =lastNames.get(i+1).getText();
   Assert.assertTrue(lastName.compareTo(followingLastname)<0);
 }


}

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
