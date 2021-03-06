import PageObjects.CartPage;
import PageObjects.CategoryPage;
import PageObjects.ProductPage;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;


public class CardTest extends BaseTest {

    private final String url = "https://fakestore.testelka.pl/product/egipt-el-gouna/";
    private final String defaultProductUrl = "https://fakestore.testelka.pl/product/";
    private final String categoryURL = "https://fakestore.testelka.pl/product-category/windsurfing/";
    private final String[] productURLs = {"egipt-el-gouna/","fuerteventura-sotavento/","grecja-limnos/","windsurfing-w-karpathos/","windsurfing-w-lanzarote-costa-teguise/"
    ,"wyspy-zielonego-przyladka-sal/","gran-koscielcow/","wspinaczka-island-peak/","wspinaczka-via-ferraty/"};

    @Test
    public void addToCardFromProductPageTest() {
        ProductPage productPage = new ProductPage(driver).goTo(url);
        productPage.closeDemoNotification();
        int amountOfProduct = productPage.addToCart("1").viewCart().getAmountOfProducts();
        assertEquals(1,amountOfProduct,"Expected item/s in cart is invalid");
    }

    @Test
    public void addToCardFromProductPageTenTimes() {
        int expectedAmountOfProduct = 10;
        ProductPage productPage = new ProductPage(driver).goTo(url);
        productPage.closeDemoNotification();
        int quantityOfProducts = productPage.addToCart("10").viewCart().getQuantityOfProducts();
        assertEquals(expectedAmountOfProduct,quantityOfProducts,"Expected quantity of items is invalid.");
    }

    @Test
    public void addToCardFromCategoryPageTest() throws InterruptedException {
        CategoryPage categoryPage = new CategoryPage(driver).goTo(categoryURL);
        categoryPage.closeDemoNotification();
        int amountOfProducts = categoryPage.addToCart().viewCart().getAmountOfProducts();
        assertEquals(1, amountOfProducts,"Expected item/s in cart is invalid ");
    }

    @Test
    public void addToCardTenProductsTest(){
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        for(String product : productURLs){
            productPage.goTo(defaultProductUrl + product).addToCart("1");
        }
        productPage.header.viewCart();
        int amountOfProducts = cartPage.getAmountOfProducts();
        assertEquals(9,amountOfProducts,"Expected amount of items in cart is invalid");
    }

    @Test
    public void changeItemsInCartTest(){
        CartPage cartPage = new CartPage(driver);
        ProductPage productPage = new ProductPage(driver).goTo("https://fakestore.testelka.pl/product/egipt-el-gouna/");
        productPage.header.closeDemoNotification();
        productPage.addToCart("1");
        productPage.header.viewCart();
        cartPage.changeProductQuantity("2").updateCart();
        int quantityAfterChange = cartPage.getQuantityOfProducts();
        assertEquals(quantityAfterChange, 2, "Expected quantity of product is invalid");
    }

    @Test
    public void applyPromoCodeTest() throws ParseException {
        CartPage cartPage = new CartPage(driver);
        ProductPage productPage = new ProductPage(driver).goTo("https://fakestore.testelka.pl/product/egipt-el-gouna/");
        productPage.header.closeDemoNotification();
        productPage.addToCart("1");
        productPage.header.viewCart();
        String sumBeforeApplyPromoCode = cartPage.sumItems();
        double sumDouble = Double.parseDouble(sumBeforeApplyPromoCode);
        System.out.println(sumDouble);
    }

}

