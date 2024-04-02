package mystore;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void product1() {    //tu wybieram produkt Hummingbird Printed Sweater
        WebElement tumbnailButton = driver.findElement(By.xpath("//*[@id='js-product-list']/div[1]/div[1]/article/div/div[2]/h2/a"));
        tumbnailButton.click();
    }
    public void verifyDiscount(String expectedDiscount) {   //tu sprawdzam czy rabat wynosi 20%
        WebElement element = driver.findElement(By.cssSelector("#main > div.row.product-container.js-product-container > div:nth-child(2) > div.product-prices.js-product-prices > div.product-price.h5.has-discount > div > span.discount.discount-percentage"));
        String discountValue = element.getText();
        if (discountValue.contains(expectedDiscount)) {
            System.out.println("Obecny rabat zgadza się z oczekiwanym, czyli: " + expectedDiscount);
        } else {
            System.out.println("Obecny rabat jest inny niż oczekiwany. " + "\nOczekiwany rabat to: " + expectedDiscount + "\nRzeczywisty rabat to: " + discountValue);
        }
        Assert.assertTrue(discountValue.contains(expectedDiscount));
    }
    public void size(String size) { //tu wybieram rozmiar koszulki
        int numericSize = changingSize(size);
        WebElement chooseSize = driver.findElement(By.cssSelector("select[id=group_1]"));
        Select x = new Select(chooseSize);
        x.selectByValue(String.valueOf(numericSize));
    }
    public int changingSize(String size) {  //tu umożliwiam wpisanie rozmiaru koszulki w ogólnie uzywanej konwencji, czyli, (S,M,L,XL) zamiast cyfr jakie są wymagane przez kod html strony
        switch (size) {
            case "S":
                return 1;
            case "M":
                return 2;
            case "L":
                return 3;
            case "XL":
                return 4;
            default:
                return 1;
        }
    }
    public void quantity(String a) { //tu wybieram ilość koszulek i tu jest ten głupi "czekacz"
        wait.until(driver -> driver.getCurrentUrl().contains("2-size-m") ||
                driver.getCurrentUrl().contains("3-size-l") ||
                driver.getCurrentUrl().contains("4-size-xl"));
        WebElement typeQuantity = driver.findElement(By.cssSelector("input[id=quantity_wanted]"));
        typeQuantity.sendKeys(a);
        typeQuantity.sendKeys(Keys.DELETE);
    }
    public void addToCart() {   //dodaję produkt do koszyka
        WebElement addToCart = driver.findElement(By.cssSelector("button[data-button-action=add-to-cart]"));
        addToCart.click();
    }
}
