package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.sum;

public class CartPage extends BasePage {

    private By cartItems = By.cssSelector(".cart_item");
    private By cartAllProductQuantity = By.cssSelector(".text");
    private By goToCheckoutButtonLocator = By.cssSelector(".wc-forward");
    private By productQuantityLocator = By.cssSelector(".text");
    private By updateCartLocator = By.cssSelector("button[name=\"update_cart\"]");
    private By sumLocator = By.cssSelector("bdi[class=\"selectorgadget_selected\"]");

    public CartPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver,8);
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

    public CartPage changeProductQuantity(String productQuantity){
        driver.findElement(productQuantityLocator).clear();
        driver.findElement(productQuantityLocator).sendKeys(productQuantity);
        return this;
    }

    public CartPage updateCart() {
        wait.until(ExpectedConditions.elementToBeClickable(updateCartLocator));
        driver.findElement(updateCartLocator).click();
        return this;
    }

    public double sumItems() {
        String sumString = driver.findElement(sumLocator).getText();
        double sumInt = Double.parseDouble(sumString);
        return sumInt;
    }
}