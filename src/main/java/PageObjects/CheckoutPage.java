package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPage extends BasePage {

    private final By nameLocator = By.cssSelector("#billing_first_name");
    private final By lastNameLocator = By.cssSelector("#billing_last_name");
    private final By streetLocator = By.cssSelector("#billing_address_1");
    private final By postalCodeLocator = By.cssSelector("#billing_postcode");
    private final By cityLocator = By.cssSelector("#billing_city");
    private final By phoneNumberLocator = By.cssSelector("#billing_phone");
    private final By emailLocator = By.cssSelector("#billing_email");
    private final By cartNumberLocator = By.cssSelector("input[autocomplete=\"cc-number\"]");
    private final By expiryDateLocator = By.cssSelector("input[name='exp-date']");
    private final By cvcNumberLocator = By.cssSelector("input[name='cvc']");
    private final By acceptStripeTermsLocator = By.cssSelector("#terms");
    private final By placeOrderLocator = By.cssSelector("#place_order");
    private final By errorList = By.cssSelector("ul.woocommerce-error");


    public CheckoutPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    public CheckoutPage typeName(String name) {
        driver.findElement(nameLocator).sendKeys(name);
        return this;
    }

    public CheckoutPage typeLastName(String lastName) {
        driver.findElement(lastNameLocator).sendKeys(lastName);
        return this;
    }

    public CheckoutPage typeStreet(String street) {
        driver.findElement(streetLocator).sendKeys(street);
        return this;
    }

    public CheckoutPage typePostalCode(String postalCode) {
        driver.findElement(postalCodeLocator).sendKeys(postalCode);
        return this;
    }

    public CheckoutPage typeCity(String city) {
        driver.findElement(cityLocator).sendKeys(city);
        return this;
    }

    public CheckoutPage typePhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberLocator).sendKeys(phoneNumber);
        return this;
    }

    public CheckoutPage typeEmail(String email) {
        driver.findElement(emailLocator).sendKeys(email);
        return this;
    }

    public CheckoutPage typeCartNumber(String cartNumber) throws InterruptedException {
        Thread.sleep(4000);
        driver.switchTo().frame(0);
        Thread.sleep(4000);
        driver.findElement(cartNumberLocator).sendKeys(cartNumber);
        driver.switchTo().defaultContent();
        return this;
    }

    public CheckoutPage typeCartExpiryDate(String expiryDate){
        driver.switchTo().frame(1);
        driver.findElement(expiryDateLocator).sendKeys(expiryDate);
        driver.switchTo().defaultContent();
        return this;
    }

    public CheckoutPage typeCartCvc(String cvcNumber){
        driver.switchTo().frame(2);
        driver.findElement(cvcNumberLocator).sendKeys(cvcNumber);
        driver.switchTo().defaultContent();
        return this;
    }

    public CheckoutPage acceptStripeTerms(){
        driver.findElement(acceptStripeTermsLocator).click();
        return this;
    }

    public SummaryPage placeOrder() {
        driver.findElement(placeOrderLocator).click();
        wait.until(ExpectedConditions.urlContains("/zamowienie/zamowienie-otrzymane"));
        return new SummaryPage(driver);
    }

    public String getErrorMessage() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderLocator));
        driver.findElement(placeOrderLocator).click();
        return wait.until(ExpectedConditions.presenceOfElementLocated(errorList)).getText();
    }
}