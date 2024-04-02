package hotel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {
    public FormPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private WebDriver driver;
    private WebDriverWait wait;

    public void selectTitle() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id=id_gender1]")));
        WebElement logButton = driver.findElement(By.cssSelector("input[id=id_gender1]"));
        logButton.click();
    }

    public void typeFirstName() {
        WebElement firstName = driver.findElement(By.cssSelector("input[id=customer_firstname]"));
        firstName.sendKeys("Mieczysław");
    }

    public void typeLastName() {
        WebElement lastName = driver.findElement(By.cssSelector("input[id=customer_lastname]"));
        lastName.sendKeys("Kowalski");
    }

    public void checkEmail(String email) {
        WebElement emailAddress = driver.findElement(By.cssSelector("input[type=email]"));
        String currentEmail = emailAddress.getAttribute("value");
        Assert.assertEquals(currentEmail, email);


    }

    public void typePassword() {
        WebElement password = driver.findElement(By.cssSelector("input[id=passwd]"));
        password.sendKeys("1234fhgj");
    }

    public void chooseDay() {
    WebElement x= driver.findElement(By.id("days"));
    Select select = new Select(x);
        select.selectByValue("24");
    }

    public void chooseMonth() {
        WebElement x= driver.findElement(By.id("months"));
        Select select = new Select(x);
        select.selectByValue("1");
    }

    public void chooseYear() {
        WebElement x= driver.findElement(By.id("years"));
        Select select = new Select(x);
        select.selectByValue("1999");
    }
    public void selectCheckbox1() {
        WebElement logButton = driver.findElement(By.id("newsletter"));
        logButton.click();
    }
    public void selectCheckbox2() {
        WebElement logButton = driver.findElement(By.cssSelector("input[id=optin]"));
        logButton.click();
    }

    public void register() {
        WebElement logButton = driver.findElement(By.cssSelector("button[id=submitAccount]"));
        logButton.click();
    }
}
