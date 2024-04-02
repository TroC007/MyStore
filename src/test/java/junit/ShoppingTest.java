package junit;

import mystore.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class ShoppingTest extends AbstractTest {
    private SearchProductPage searchProductPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private OrderPage orderPage;
    private UserPage userPage;
    private HistoryPage historyPage;

    @Before
    public void openBrowser() {
        setUp("chrome");
        //próba ustawienia cookies, żeby strona załączała się z zalogowanym użytkownikiem
//    Set<Cookie> cookies = driver.manage().getCookies();
////    driver.manage().getCookieNamed();
//    for(Cookie cookie: cookies){
//        driver.manage().addCookie(cookie);
        driver.get("https://mystore-testlab.coderslab.pl/");
        WebElement signInButton = driver.findElement(By.cssSelector("span.hidden-sm-down"));
        signInButton.click();
        WebElement email = driver.findElement(By.cssSelector("input[id=field-email]"));
        email.sendKeys("winsent@o2.pl");
        WebElement password = driver.findElement(By.cssSelector("input[id=field-password]"));
        password.sendKeys("Burek22");
        WebElement signInButton1 = driver.findElement(By.cssSelector("button[id=submit-login]"));
        signInButton1.click();

    }

    @Test
    public void shoppingTest() {
        searchProductPage = new SearchProductPage(driver);
        searchProductPage.search();
        productPage = new ProductPage(driver, wait);
        productPage.product1();
        productPage.verifyDiscount("20%");
        productPage.size("M");
        productPage.quantity("5");
        productPage.addToCart();
        cartPage = new CartPage(driver, wait);
        cartPage.proceedToCheckout();
        orderPage = new OrderPage(driver, wait);
        orderPage.chooseAddress();
        orderPage.chooseShippingMethod();
        orderPage.payment();
        orderPage.placeOrder();
        orderPage.prtSc();
        orderPage.goToUserPage();
        userPage = new UserPage(driver, wait);
        userPage.historyOrderPage();
        historyPage = new HistoryPage(driver, wait);
        historyPage.verifyStatusOrder();
        historyPage.verifyPrice();
    }
}
