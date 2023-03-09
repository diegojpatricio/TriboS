package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxCapabilities implements Capabilities{
    private final FirefoxOptions options = new FirefoxOptions();
    private  WebDriver driver;
    public FirefoxCapabilities(){
        setCapabilities();
    }
    @Override
    public void setCapabilities() {
        capabilities.setCapability(CapabilityType.BROWSER_NAME, Browser.FIREFOX.browserName());
    }

    @Override
    public DesiredCapabilities getCapabilities() {
        return capabilities;
    }

    @Override
    public void setDriver(RemoteWebDriver driver) {
    }

    @Override
    public WebDriver getDriver() {
        return null;
    }
}
