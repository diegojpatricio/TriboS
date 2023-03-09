package driver;

public class CapabilitiesFactory {

    public Capabilities getCapabilities(String browserName){
        switch (browserName){
            case "chrome":
                return new ChromeCapabilities();
            case "firefox":
                return new FirefoxCapabilities();
            default: throw new RuntimeException("Escolha entre Chrome e Firefox");
        }
    }
}
