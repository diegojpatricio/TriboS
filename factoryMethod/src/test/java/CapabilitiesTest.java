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
}
