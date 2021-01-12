package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage extends BasePage {

    private By addToCartButton = By.cssSelector("a[data-product_id=\"386\"]");
    private By viewCardButton = By.cssSelector("a.added_to_cart");
    private By cartItems = By.cssSelector(".cart_item");

    public CategoryPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver,5);
    }

    public CategoryPage goTo(String url) {
        driver.get(url);
        return new CategoryPage(driver);
    }

    public CategoryPage addToCart() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        return this;
    }
    public CategoryPage viewCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCardButton)).click();
        return this;
    }

    public int getAmountOfProducts() {
        int a = driver.findElements(cartItems).size();
        return a;
    }
}
