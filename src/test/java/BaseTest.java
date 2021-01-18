import Drivers.Browser;
import Drivers.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

@ExtendWith(MyTestWatcher.class)
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
