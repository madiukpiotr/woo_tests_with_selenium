package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    By cartLocator = By.cssSelector(".cart-contents");

    public void viewCart(){
        driver.findElement(cartLocator).click();
    }
}
