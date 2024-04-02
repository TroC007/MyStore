package mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public UserPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void historyOrderPage() { //przenoszę się na stronę konta użytkownika
        WebElement historyOrderPage = driver.findElement(By.cssSelector("#history-link > span"));
        historyOrderPage.click();
    }

}
