package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static utilities.properties.PropertiesManager.WebConfig;


public class ChromeDriverFactory extends DriverAbstract{

    @Override
    public WebDriver startDriver() {
        ChromeOptions options=new ChromeOptions();
        if (WebConfig.getProperty("HeadlessMode").equalsIgnoreCase("true")) {
            options.addArguments("--headless");
        }
        driver=new ChromeDriver(options);
        return driver;
    }
}








