import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.ProductPage;
import PageObjects.SummaryPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentsTest extends BaseTest {

    private final String name = "Peter";
    private final String lastName = "Tester";
    private final String street = "Testowa 23/32";
    private final String postalCode = "21-345";
    private final String city = "21-345";
    private final String phoneNumber = "123123123";
    private final String email = "test@123.com";
    private final String cartNumber = "4242424242424242";
    private final String expiryDate = "11/23";
    private final String cvcNumber = "123";

    @Test
    public void orderProductWithoutAccountTest() throws InterruptedException {
        SummaryPage summaryPage = new SummaryPage(driver);
        ProductPage productPage = new ProductPage(driver).goTo("https://fakestore.testelka.pl/product/egipt-el-gouna/");
        productPage.demoNotice.close();
        CheckoutPage checkoutPage = productPage.addToCart("1").viewCart().acceptAndGoToCheckout();
        checkoutPage.typeName(name)
                    .typeLastName(lastName)
                    .typeStreet(street)
                    .typePostalCode(postalCode)
                    .typeCity(city)
                    .typePhoneNumber(phoneNumber)
                    .typeEmail(email)
                    .typeCartNumber(cartNumber)
                    .typeCartExpiryDate(expiryDate)
                    .typeCartCvc(cvcNumber)
                    .acceptStripeTerms()
                    .placeOrder();
        String expectedMessage = "Dziękujemy. Otrzymaliśmy Twoje zamówienie.";
        String actualMessage = summaryPage.getOrderMessage();
        assertEquals(expectedMessage,actualMessage,"The expected successful order message is invalid");
    }

    @Test
    public void obligatoryFieldsValidationMessageTest() throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CartPage cartPage = new CartPage(driver);
        ProductPage productPage = new ProductPage(driver).goTo("https://fakestore.testelka.pl/product/egipt-el-gouna/");
        productPage.demoNotice.closeDemoNotification();
        productPage.addToCart("1").viewCart();
        cartPage.acceptAndGoToCheckout();
        checkoutPage.typeCartNumber(cartNumber).typeCartCvc(cvcNumber).typeCartExpiryDate(expiryDate).getErrorMessage();
        String errorMessage = checkoutPage.getErrorMessage();
        assertAll(
                ()->assertTrue(errorMessage.contains("Imię płatnika jest wymaganym polem."),
                        "Error message doesn't contain lack of first name error."),
                ()->assertTrue(errorMessage.contains("Nazwisko płatnika jest wymaganym polem."),
                        "Error message doesn't contain lack of last name error."),
                ()->assertTrue(errorMessage.contains("Ulica płatnika jest wymaganym polem."),
                        "Error message doesn't contain lack of street name error."),
                ()->assertTrue(errorMessage.contains("Miasto płatnika jest wymaganym polem."),
                        "Error message doesn't contain lack of city name error."),
                ()->assertTrue(errorMessage.contains("Telefon płatnika jest wymaganym polem."),
                        "Error message doesn't contain lack of phone number error."),
                ()->assertTrue(errorMessage.contains("Adres email płatnika jest wymaganym polem."),
                        "Error message doesn't contain lack of email address error."),
                ()->assertTrue(errorMessage.contains("Kod pocztowy płatnika nie jest prawidłowym kodem pocztowym."),
                        "Error message doesn't contain lack of postal code error."),
                ()->assertTrue(errorMessage.contains("Proszę przeczytać i zaakceptować regulamin sklepu aby móc sfinalizować zamówienie.")));
    }
}
