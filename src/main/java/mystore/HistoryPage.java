package mystore;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HistoryPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private OrderPage reference;

    public HistoryPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void verifyStatusOrder() {   //tu sprawdzam czy zamówienie znajduje się na liście

        WebElement orderStatus = driver.findElement(By.cssSelector("#content > table > tbody > tr:nth-child(1) > td:nth-child(5) > span"));
        String statusOrder = orderStatus.getText();
        if (statusOrder.contains("Awaiting check payment")) {
            System.out.print("");
        } else {
            System.out.println("Nie udało się złożyć zamówienia.");
        }
        Assert.assertTrue(statusOrder.contains("Awaiting check payment"));
    }
    public void verifyPrice(){
        WebElement price = driver.findElement(By.cssSelector("#content > table > tbody > tr:nth-child(1) > td.text-xs-right"));
        String priceCheck = price.getText();
        if (priceCheck.contains("143.60")) {
            System.out.println("ZGADZA SIĘ, zamówienie ma status: Awaiting check payment. \nKwota do zapaty to 143.60 EUR.");
        } else {
            System.out.println("Nie udało się złożyć zamówienia.");
        }

        Assert.assertTrue(priceCheck.contains("143.60"));
    }
}
