package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Integer.parseInt;

public class CartPage extends BasePage {

    private By cartItems = By.cssSelector(".cart_item");
    private By cartAllProductQuantity = By.cssSelector(".text");
    private By goToCheckoutButtonLocator = By.cssSelector(".wc-forward");

    public CartPage(WebDriver driver) {
        super(driver);
        WebDriver wait;
    }

    public int getAmountOfProducts() {
        int a = driver.findElements(cartItems).size();
        return a;
    }
    
    public int getQuantityOfProducts() {
        int quantityOfProducts = 0;
        List<WebElement> listElement = driver.findElements(cartAllProductQuantity);
        for(WebElement webElement : listElement){
            String elementValue = webElement.getAttribute("value");
            int elementValueInt = parseInt(elementValue);
            quantityOfProducts += elementValueInt;
        }
        return quantityOfProducts;
        }

    public CheckoutPage acceptAndGoToCheckout(){
        driver.findElement(goToCheckoutButtonLocator).click();
        return new CheckoutPage(driver);
    }
    }