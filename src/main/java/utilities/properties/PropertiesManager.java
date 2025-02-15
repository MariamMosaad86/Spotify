package utilities.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    public static Properties WebConfig;

    public static Properties ReportConfig;


    public PropertiesManager() {
    }

    public static void initializeProperties(){
        FileInputStream webConfigFile=null;
        FileInputStream reportConfigFile=null;
        try {
             webConfigFile=new FileInputStream("src/main/resources/WebConfigurations.properties");
             reportConfigFile=new FileInputStream("src/main/resources/Reporting.properties");

            WebConfig=new Properties();
            ReportConfig=new Properties();

            WebConfig.load(webConfigFile);
            ReportConfig.load(reportConfigFile);

        } catch (FileNotFoundException e) {
            System.out.println("Property File is not found");
        } catch (IOException e) {
            System.out.println("File is not readable");
        }

    }
}
