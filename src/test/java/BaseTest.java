import Drivers.Browser;
import Drivers.DriverFactory;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected RemoteWebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void testSetUp() throws MalformedURLException {
        DriverFactory driverFactory = new DriverFactory();
        driver = (RemoteWebDriver) driverFactory.create(Browser.CHROME);


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterEach
    public void driverQuit()  {
        driver.quit();
    }

}
