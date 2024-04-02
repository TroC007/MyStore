package hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;


public class RegistrationPage {
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public void typeEmail(String email) {
        WebElement emailAddress = driver.findElement(By.cssSelector("input[type=email]"));
        emailAddress.sendKeys(email);
    }

    public String randomEmail() {
        Random r = new Random();
        return "user" + r.nextInt() + "@o2.pl";
    }

    public void createAccount() {
        WebElement logButton = driver.findElement(By.cssSelector("button[type=submit]"));   //lokalizuje przycisk, który chcemy użyć
        logButton.click();
    }

}
