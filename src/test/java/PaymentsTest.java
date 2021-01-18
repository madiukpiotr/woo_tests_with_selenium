import PageObjects.CheckoutPage;
import PageObjects.ProductPage;
import PageObjects.SummaryPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void orderProductWithoutAccountTest(){
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
}
