package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;
    public static Properties readProperties(String path) {
        try(FileInputStream fis=new FileInputStream(path);){
            prop=new Properties();
            prop.load(fis);
        }catch(IOException e){
            e.printStackTrace();
        }
return prop;
    }
    public static String getPropertyValue(String key){
        //from prop object, we are calling the getProperty method, and we will
        //pass the key to fetch the value
        return prop.getProperty(key);
    }


}
