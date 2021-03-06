package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoFooterPage extends BasePage {
    public DemoFooterPage(WebDriver driver) {
        super(driver);
    }

    private final By closeDemoLocator = By.cssSelector(".woocommerce-store-notice__dismiss-link");

    public void close(){
        driver.findElement(closeDemoLocator).click();
    }
}
