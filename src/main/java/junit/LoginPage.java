package junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void goToLoginPage() {
        //nie można robić drugiego obiektu ChromeDriver, bo otworzy się druga przeglądarka
//        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void typeLogin(String login) {
        WebElement username = driver.findElement(By.cssSelector("input[id=username]"));
        username.sendKeys(login);
    }

    public void typePassword(String password) {
        WebElement password1 = driver.findElement(By.cssSelector("input[id=password]"));
        password1.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement logButton = driver.findElement(By.cssSelector("button[type=submit]"));   //lokalizuje przycisk, który chcemy użyć
        logButton.click();

    }
}
