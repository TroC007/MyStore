package mystore;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class OrderPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public OrderPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void chooseAddress() {   //wybieram adres dostawy
        wait.until(driver -> driver.getCurrentUrl().contains("order"));
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id-address-delivery-address-8919 > header > label > span.custom-radio > input[type=radio]")));    //ten czekacz tu nie działa
        WebElement chooseAddress = driver.findElement(By.cssSelector("#id-address-delivery-address-8919 > header > label > span.custom-radio > input[type=radio]"));
        chooseAddress.click();
        WebElement confirmAddress = driver.findElement(By.cssSelector("#checkout-addresses-step > div > div > form > div.clearfix > button"));
        confirmAddress.click();
    }

    public void chooseShippingMethod() {    //wybieram sposób dostawy
//        wait.until(driver -> driver.getCurrentUrl().contains("https://mystore-testlab.coderslab.pl/index.php?controller=order")); //okazuje się, że ten czekacz tu nie jest potrzebny
        //tu sie dowiedziałem, że nie można sobie kliknąć czegoś co jest kliknięte, tutaj chodzi o zaznaczenie metody dostawy, która jest już domyslnie wybrana
        //można zrobić jak poniżej, czyli kliknąć inną metodę dostawy, a potem tą, która była domyślna, to jest bez sensu, więc to zakomentowałem:)
//        WebElement chooseShippingMethod1 = driver.findElement(By.cssSelector("input[id=delivery_option_6]"));
//        chooseShippingMethod1.click();
//        WebElement chooseShippingMethod2 = driver.findElement(By.cssSelector("input[id=delivery_option_8]"));
//        chooseShippingMethod2.click();
        WebElement confirmShippingMethod = driver.findElement(By.cssSelector("#js-delivery > button"));
        confirmShippingMethod.click();
    }

    public void payment() { //wybieram sposób płatności
        WebElement choosePayment = driver.findElement(By.cssSelector("#payment-option-1"));
        choosePayment.click();
    }

    public void placeOrder() {   //finalnie potwierdzam zamówienie
        WebElement confirmTerms = driver.findElement(By.cssSelector("#conditions_to_approve\\[terms-and-conditions\\]"));
        confirmTerms.click();
        WebElement placeOrder = driver.findElement(By.cssSelector("#payment-confirmation > div.ps-shown-by-js > button"));
        placeOrder.click();
    }

    public void prtSc() {    //robię printscreen potwierdzonego zamówienia
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("src\\screenshot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToUserPage() { //przenoszę się na stronę konta użytkownika
        WebElement userPage = driver.findElement(By.cssSelector("#_desktop_user_info > div > a.account > span"));
        userPage.click();
    }
}
