package junit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerificationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public VerificationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void userShouldBeLoggedIn() {
        wait.until(ExpectedConditions.urlContains("/secure")); //"wait.until(ExpectedConditions." - to trzeba zapamiętać "urlContains("/secure"));"
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/logout']")));
        // ten "wait.until(ExpectedConditions.urlContains("/secure"));" sprawdza czy po zadziałaniu występuje określony adres url (tutaj tylko końcówka adresu url)
        String expectedValue = "You logged into a secure area!";
        verifyText(expectedValue);
    }

    public void userShouldNotBeLoggedIn() {
        String expectedValue = "Your password is invalid!";
        verifyText(expectedValue);
    }

    private void verifyText(String expectedText) {
        WebElement element = driver.findElement(By.cssSelector("div#flash"));   //'#' - to jest równoznaczne z 'id'
        String currentValue = element.getText();
        Assert.assertTrue(currentValue.contains(expectedText));
    }


}
