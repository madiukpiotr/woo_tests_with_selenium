package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {
    public HeaderPage header;
    public DemoFooterPage demoNotice;
    private final WebDriverWait wait;

    private final By quantityField = By.cssSelector("input.qty");
    private final By addToCardButton = By.cssSelector("button[name='add-to-cart']");
    private final By viewCartButton = By.linkText("Zobacz koszyk");


    public ProductPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver,7);
        header = new HeaderPage(driver);
        demoNotice = new DemoFooterPage(driver);
    }

    public ProductPage goTo(String url) {
        driver.get(url);
        return this;
    }

    public ProductPage addToCart(String quantity) {
        driver.findElement(quantityField).clear();
        driver.findElement(quantityField).sendKeys(quantity);
        driver.findElement(addToCardButton).click();
        return this;
    }

    public CartPage viewCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartButton)).click();
        return new CartPage(driver);
    }

}
