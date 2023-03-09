package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface Capabilities {
    DesiredCapabilities capabilities = new DesiredCapabilities();
     void setCapabilities();

     public DesiredCapabilities getCapabilities();
     void setDriver(RemoteWebDriver driver);
     WebDriver getDriver();

}
