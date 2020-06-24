package core;

import java.io.*;
import java.util.Properties;

public class PropertiesManagement {

    InputStream inputStream;
    private static final String FILE_PATH = "./src/test/resources/configurations/configuration.properties";

    public void setPropertiesFromFile(){
        try{
            File propertiesFile = new File(FILE_PATH);
            final InputStream stream = new FileInputStream(propertiesFile);
            Properties properties = System.getProperties();
            properties.load(stream);
            System.setProperties(properties);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
