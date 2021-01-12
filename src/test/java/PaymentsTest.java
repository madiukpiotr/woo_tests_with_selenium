import PageObjects.CheckoutPage;
import PageObjects.ProductPage;
import org.junit.jupiter.api.Test;

public class PaymentsTest extends BaseTest {

    private String name = "Peter";
    private String lastName = "Tester";
    private String street = "Testowa 23/32";
    private String postalCode = "21-345";
    private String city = "21-345";
    private String phoneNumber = "123123123";
    private String email = "test@123.com";
    private String cartNumber = "4242424242424242";
    private String expiryDate = "11/23";
    private String cvcNumber = "123";

    @Test
    public void orderProductWithoutAccountTest(){
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

    }
}
