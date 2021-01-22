package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {

    private final By cartLocator = By.cssSelector(".cart-contents");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void viewCart(){
        driver.findElement(cartLocator).click();
    }
}
