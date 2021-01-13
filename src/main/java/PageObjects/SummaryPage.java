package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage extends BasePage {

    private By orderMessageLocator = By.cssSelector(".woocommerce-thankyou-order-received");

    public SummaryPage(WebDriver driver) {
        super(driver);
        WebDriver wait;
    }

    public String getOrderMessage() {
        String orderMessage = driver.findElement(orderMessageLocator).getText();
        return orderMessage;
    }
}
