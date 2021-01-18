package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    WebDriver driver;
    private String hubUrl = "http://192.168.8.114:4444/wd/hub";

    public WebDriver create(Browser browserType) throws MalformedURLException {
        switch (browserType) {
            case CHROME:
                return getChromeDriver();
//            case FIREFOX:
//                return getFirefoxDriver();
            default:
                throw new IllegalArgumentException("Provided browser does not exist");
        }
    }

    private WebDriver getChromeDriver() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.VERSION,"66");
        driver = new RemoteWebDriver(new URL(hubUrl), options);
        return driver;
    }

//    private WebDriver getFirefoxDriver() throws MalformedURLException {
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        return new RemoteWebDriver(new URL(hubUrl), options);
//    }
}
