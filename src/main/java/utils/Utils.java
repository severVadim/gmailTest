package utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import objects.Mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class Utils {

    private static final String PATH = "src\\main\\resources\\";
    private static final String PROP_PATH = PATH + "properties\\global.properties";
    private static String DATA_PATH = PATH + "testData\\%s.json";

    public static String getProperty (String propertyName){
        FileInputStream fs;
        Properties properties = null;
        try {
            fs = new FileInputStream(PROP_PATH);
            properties = new Properties();
            properties.load(fs);
        }catch (IOException e){
            e.printStackTrace();
        }
        return properties.getProperty(propertyName);
    }

    public static Mail convertJsonToMail(){
        try {
            return new ObjectMapper().readValue(new File(String.format(DATA_PATH, "mail")), Mail.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
