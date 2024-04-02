package junit;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest extends AbstractTest {
    //dwie poniższe linijki są usunięte bo utworzyłem klasę 'AbstractTest()'
//    private WebDriver driver;
//    private WebDriverWait wait;
    private LoginPage loginPage;
    private VerificationPage verificationPage;

    @Before
    public void openBrowser() {
        setUp("chrome");    // tu wpisuję przeglądarkę z której korzystam, domyslnie ustawiona jest przeglądarka chrome
        //trzy poniższe linijki są usunięte bo utworzyłem klasę 'AbstractTest()', ale musiałem dodać odwołanie się do metody 'setUp()'
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\winse\\WebDrivers\\chromedriver.exe");
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, 3);
        loginPage = new LoginPage(driver);
        verificationPage = new VerificationPage(driver, wait);

        //pobieranie ciasteczek i ich używanie, np.: żeby strona w kolejnych testach mogła być juz zalogowana (to tylko schemat niesprawdzony)
//        Cookie c = driver.manage().getCookieNamed("rack session");
//        driver.manage().addCookie(c);


    }
    // usunąłem, bo utworzyłem to w klasie "AbstractTest", a nasza klasa "LoginTest" dziedziczy po "AbstractTest", a haczyki (te z małpką np.: @After) wykonują się same
//    @After
//    public void closeBrowser() {
//        driver.quit();


    @Test
    public void correctCredentialsTest() {  //tu skopiowałem kroki z "LoginSteps.java"

        loginPage.goToLoginPage();  //trzeba wcześniej zainicjalizować obiekt "loginPage = new LoginPage();"
//        driver.get("https://the-internet.herokuapp.com/login");   //usunąłem to, bo jest ta metoda wywoływana powyżej 'loginPage.goToLoginPage();'

        loginPage.typeLogin("tomsmith");
        //usunąłem to poniżej, bo jest ta metoda wywoływana powyżej 'loginPage.typeLogin("tomsmith");'
//        WebElement username = driver.findElement(By.cssSelector("input[id=username]"));
//        username.sendKeys("tomsmith");  //tu jest konkretna wartość

        loginPage.typePassword("SuperSecretPassword!");
        //usunąłem to poniżej, bo jest ta metoda wywoływana powyżej 'loginPage.typePassword("SuperSecretPassword!");'
//        WebElement password1 = driver.findElement(By.cssSelector("input[id=password]"));
//        password1.sendKeys("SuperSecretPassword!");

        loginPage.clickLoginButton();
        //usunąłem to poniżej, bo jest ta metoda wywoływana powyżej 'loginPage.clickLoginButton();'
//        WebElement logButton = driver.findElement(By.cssSelector("button[type=submit]"));   //lokalizuje przycisk, który chcemy użyć
//        logButton.click();

        verificationPage.userShouldBeLoggedIn();
//        wait.until(ExpectedConditions.urlContains("/secure")); //"wait.until(ExpectedConditions." - to trzeba zapamiętać "urlContains("/secure"));"
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/logout']")));
//        // ten "wait.until(ExpectedConditions.urlContains("/secure"));" sprawdza czy po zadziałaniu występuje określony adres url (tutaj tylko końcówka adresu url)
//        String expectedValue = "You logged into a secure area!";
//        verifyText(expectedValue);


    }

    @Test
    public void incorrectCredentialsTest() {    //tu skopiowałem kroki z "LoginSteps.java"
        loginPage.goToLoginPage();
//        driver.get("https://the-internet.herokuapp.com/login");   //usunąłem to, bo jest ta metoda wywoływana powyżej 'loginPage.goToLoginPage();'

        loginPage.typeLogin("tomsmith");
//        WebElement username = driver.findElement(By.cssSelector("input[id=username]"));
//        username.sendKeys("tomsmith");  //tu jest konkretna wartość

        loginPage.typePassword("IncorrectPassword");
//        WebElement password1 = driver.findElement(By.cssSelector("input[id=password]"));
//        password1.sendKeys("IncorrectPassword");

        loginPage.clickLoginButton();
//        WebElement logButton = driver.findElement(By.cssSelector("button[type=submit]"));   //lokalizuje przycisk, który chcemy użyć
//        logButton.click();

        verificationPage.userShouldNotBeLoggedIn();
//        String expectedValue = "Your password is invalid!";
//        verifyText(expectedValue);

    }

    //przeniosłem to do innej klasy "VerificationPage.java"
//    private void verifyText(String expectedText) {
//        WebElement element = driver.findElement(By.cssSelector("div#flash"));   //'#' - to jest równoznaczne z 'id'
//        String currentValue = element.getText();
//        Assert.assertTrue(currentValue.contains(expectedText));
//    }

}
