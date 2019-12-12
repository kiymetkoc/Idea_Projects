package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigurationReader {
    //this class will be responsible for login properties file and will provide access to values based on key names.

    //We use this class to load custom .properties files

    private static Properties configFile;

    static{
        try {
            //provides access to file
            //try catch block stands for handeling exceptions
            //if exception occurs, code inside a catch block will be executed
            //any class that is related to (IO)InputOutput produce checked exceptions
            //without handling cheked exception, you cannot run code
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            //FileInputStream is a class that allows us to any class to connect and get the info from the file
            configFile=new Properties();
            //load your properties file
            configFile.load(fileInputStream);
            fileInputStream.close(); // close input stream
        } catch (IOException e) {
            System.out.println("Failed to load properties file!");
            e.printStackTrace();
        }


    }
    public static String getProperty(String key){
       return configFile.getProperty(key);
    }

}
