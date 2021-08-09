package Support;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {
    private Properties properties;

    public ConfigReader() {

        BufferedReader reader;
        String propertyFilePath = "src/test/resources/config/TestConfiguration.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Properties could not be located " + propertyFilePath);
        }


    }

    public String getDriverPathChrome(){
        String driverPath = properties.getProperty("driver_path_chrome");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not present in the properties File.");
    }

    public String getApplicationURL(){
        String URL = properties.getProperty("URL");
        if(URL!= null) return URL;
        else throw new RuntimeException("URL not present in the properties File.");
    }

    public String getBrowserName(){
        String browser_name = properties.getProperty("browser");
        if(browser_name!=null) return browser_name;
        else throw new RuntimeException("Browser name is not present in the properties file.");

    }
    public String getDriverPathFirefox(){
        String driverPath = properties.getProperty("driver_path_firefox");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not present in the properties File.");
    }
}

