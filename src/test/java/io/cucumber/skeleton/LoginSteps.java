package io.cucumber.skeleton;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps {
    WebDriver driver;
    WebDriverWait wait; //każe czekać testom na wykonanie się poleceń na stronie

//    @Given("I open browser") //usuwam i zastępuję poniższym wierszem '@Before 'io.cucumber.java'' - to jest ważne żeby ten @Before był dobrze wybrany
    @Before //zastępuje wyższy wiersz, dzięki temu nie musimy wpisywać tego kroku w scenariuszu, automatycznie wykonuje nam się ten krok przed wszystkimi innymi (before:)
    public void iOpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\winse\\WebDrivers\\chromedriver.exe");    //fizyczna reprezentacja przeglądarki, żeby ją otworzyć
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);    //dla nowej wersji selenium zamiast 'timeOutlnSeconds: 3' powinno być 'duration.ofSeconds(3)'
    }
    @After  //zasady jak dla '@Before', automatyzacja po wszystkich krokach (after), "@Before" i "@After" to są tak zwane "haczyki', czyli metody wykonujace się automatycznie bez definiowania ich w "login.feature"
    public void closeBrowser(){
        driver.quit();  //metoda quit() zamyka wszystko i procesy, jest jeszcze close(), ale ona nie zamyka procesów (w menadżerze urządzeń w Windowsie)
    }

    @And("I go to login page")
    public void iGoToLoginPage() {
        driver.get("https://the-internet.herokuapp.com/login"); //powoduje otwarcie strony, którą testujemy
    }

    @When("I type login {string}")
    public void iTypeLogin(String login) {
        WebElement username = driver.findElement(By.cssSelector("input[id=username]"));
        username.sendKeys(login);

//        username = driver.findElement(By.id("username")); //inna wersje wpisania loginu (username)
//        username.sendKeys(login);
//        username = driver.findElement(By.cssSelector("#username")); //inna wersje wpisania loginu (username)
//        username.sendKeys(login);
    }

    @And("I type password {string}")
    public void iTypePassword(String password) {
        WebElement password1 = driver.findElement(By.cssSelector("input[id=password]"));
        password1.sendKeys(password);
    }

    @And("I click login button")
    public void iClickLoginButton() {
        WebElement logButton = driver.findElement(By.cssSelector("button[type=submit]"));   //lokalizuje przycisk, który chcemy użyć
        logButton.click(); //naciska się przycisk
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        wait.until(ExpectedConditions.urlContains("/secure")); //"wait.until(ExpectedConditions." - to trzeba zapamiętać "urlContains("/secure"));"
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/logout']")));
        // ten "wait.until(ExpectedConditions.urlContains("/secure"));" sprawdza czy po zadziałaniu występuje określony adres url (tutaj tylko końcówka adresu url)
        String expectedValue = "You logged into a secure area!";
        verifyText(expectedValue);                                                      //wykorzystanie zmiennej z podmienionej metody verifyText
//        WebElement element = driver.findElement(By.cssSelector("div#flash"));         //podmieniono metodą verifyText
//        String currentValue = element.getText();                                      //podmieniono metodą verifyText
////        Assert.assertEquals(expectedValue, currentValue.contains(expectedValue)); //zła metoda, bo porównuje dwa elementy (tutaj expected do current)
//        Assert.assertTrue(currentValue.contains(expectedValue));                      //podmieniono metodą verifyText
    }

    @Then("I am not logged in")
    public void iAmNotLoggedIn() {
        String expectedValue = "Your password is invalid!";
        verifyText(expectedValue);                                              //wykorzystanie zmiennej z podmienionej metody verifyText
//        WebElement element = driver.findElement(By.cssSelector("div#flash")); //podmieniono metodą verifyText
//        String currentValue = element.getText();                              //podmieniono metodą verifyText
//        Assert.assertTrue(currentValue.contains(expectedValue));              //podmieniono metodą verifyText
    }
    private void verifyText(String expectedText) {
        WebElement element = driver.findElement(By.cssSelector("div#flash"));   //'#' - to jest równoznaczne z 'id'
        String currentValue = element.getText();
        Assert.assertTrue(currentValue.contains(expectedText));
    }

    @When("I type login {string} and password {string}")
    public void iTypeLoginAndPassword(String login, String password) {
    iTypeLogin(login);
    iTypePassword(password);
    iClickLoginButton();
    }
}
