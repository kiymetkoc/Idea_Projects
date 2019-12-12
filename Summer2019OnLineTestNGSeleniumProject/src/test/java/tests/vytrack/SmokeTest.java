package tests.vytrack;

import org.testng.annotations.DataProvider;

public class SmokeTest {

    public void SmokeTest(String moduleName, String subModuleName, String pageSubTitle){
        //LoginPage.login("storemanager85",)
    }
    @DataProvider(name="navigationInfo")
    public Object[] [] navigationInfo(){
        return new Object[][]{
                {"Dashboards","Dashboard","Dashboard"},
                {"Dash boards","Manage Dashboards","All Manage Dashboards"},
                {"Fleet", "Vehicles", "all Cars"},
                {"Customers", "Accounts","All Accounts"}

        };

    }
}
