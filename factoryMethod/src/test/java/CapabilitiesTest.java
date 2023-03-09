import driver.Capabilities;
import driver.CapabilitiesFactory;
import driver.ChromeCapabilities;
import driver.FirefoxCapabilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.Browser;

public class CapabilitiesTest {
    @Test
    void testChrome(){
        ChromeCapabilities chromeCapabilities = new ChromeCapabilities();
        Assertions.assertEquals(Browser.CHROME.browserName(), chromeCapabilities.getCapabilities().getBrowserName());
    }
    @Test
    void testFirefox(){
        FirefoxCapabilities firefoxCapabilities = new FirefoxCapabilities();
        Assertions.assertEquals(Browser.FIREFOX.browserName(), firefoxCapabilities.getCapabilities().getBrowserName());
    }
    @Test
    void novoChrometest(){
        Capabilities chromeCaps = new CapabilitiesFactory().getCapabilities(Browser.CHROME.browserName());
        Assertions.assertEquals(Browser.CHROME.browserName(), chromeCaps.getCapabilities().getBrowserName());
    }
    @Test
    void novoFireFoxtest(){
        Capabilities foxCaps = new CapabilitiesFactory().getCapabilities(Browser.FIREFOX.browserName());
        Assertions.assertEquals(Browser.FIREFOX.browserName(), foxCaps.getCapabilities().getBrowserName());
    }
}
