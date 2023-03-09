package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeCapabilities implements Capabilities{
    private final ChromeOptions options = new ChromeOptions();
    private  WebDriver driver;
    public ChromeCapabilities(){
        setCapabilities();
    }
    @Override
    public void setCapabilities() {
        capabilities.setCapability(CapabilityType.BROWSER_NAME, Browser.CHROME.browserName());
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
