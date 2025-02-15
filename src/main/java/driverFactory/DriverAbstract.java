package driverFactory;

import org.openqa.selenium.WebDriver;

public abstract class DriverAbstract {

  protected WebDriver driver;

  public abstract WebDriver startDriver();

}