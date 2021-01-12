package PageObjects;

import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage(WebDriver driver){
        this.driver = driver;
    }

    private By closeDemoLocator = By.cssSelector(".woocommerce-store-notice__dismiss-link");
    public void closeDemoNotification(){
        driver.findElement(closeDemoLocator).click();
    }

}
