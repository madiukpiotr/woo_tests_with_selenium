package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.sum;

public class CartPage extends BasePage  {

    private final By cartItems = By.cssSelector(".cart_item");
    private final By cartAllProductQuantity = By.cssSelector(".text");
    private final By goToCheckoutButtonLocator = By.cssSelector(".wc-forward");
    private final By productQuantityLocator = By.cssSelector(".text");
    private final By updateCartLocator = By.cssSelector("button[name=\"update_cart\"]");
    private final By sumLocator = By.xpath("//*[@id=\"post-6\"]/div/div/div[2]/div/table/tbody/tr[2]/td/strong/span/bdi");

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

    public String sumItems() throws ParseException {
        NumberFormat numberFormat = new DecimalFormat("¤#.00", new DecimalFormatSymbols(Locale.UK));
        numberFormat.parse("£123.5678");
        String sumString = driver.findElement(sumLocator).getText();
/*        double sumInt = Double.parseDouble(sumString);*/
        return sumString;
    }
}