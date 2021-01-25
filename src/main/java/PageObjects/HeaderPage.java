package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage extends BasePage {

    private final By cartLocator = By.cssSelector(".cart-contents");

    public HeaderPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver,10);
    }

    public void viewCart(){
        wait.until(ExpectedConditions.elementToBeClickable(cartLocator));
        driver.findElement(cartLocator).click();
    }
}
