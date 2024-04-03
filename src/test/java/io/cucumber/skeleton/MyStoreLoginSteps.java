package io.cucumber.skeleton;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MyStoreLoginSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void iOpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\winse\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);
    }

        @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("I go to log page")
    public void iGoToLogPage() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?");
        WebElement logPage = driver.findElement(By.cssSelector("#_desktop_user_info > div > a > span"));
        logPage.click();
    }

    @And("I log in")
    public void iLogIn() {
        WebElement typeEmail = driver.findElement(By.cssSelector("#field-email"));
        typeEmail.sendKeys("winsent@o2.pl");
        WebElement typePassword = driver.findElement(By.cssSelector("#field-password"));
        typePassword.sendKeys("Burek22");
        WebElement signIn = driver.findElement(By.cssSelector("#submit-login"));
        signIn.click();
    }

    @When("I choose addresses tile")
    public void iChooseAddressesTile() {
        WebElement clickAddressTile = driver.findElement(By.cssSelector("#addresses-link > span"));
        clickAddressTile.click();

    }

    @And("I create new address")
    public void iCreateNewAddress() {
        WebElement createNewAddress = driver.findElement(By.cssSelector("#content > div.addresses-footer > a > span"));
        createNewAddress.click();
    }

    @And("I type new data")
    public void iTypeNewData() {
        System.out.println("CZY DANE W DODANYM ADRESIE SĄ POPRAWNE?");
        WebElement typeAlias = driver.findElement(By.cssSelector("#field-alias"));
        typeAlias.sendKeys("Spokojny");
        WebElement typeAddress = driver.findElement(By.cssSelector("#field-address1"));
        typeAddress.sendKeys("Wieczna 5");
        WebElement typeCity = driver.findElement(By.cssSelector("#field-city"));
        typeCity.sendKeys("Wieliczka");
        WebElement typePostal = driver.findElement(By.cssSelector("#field-postcode"));
        typePostal.sendKeys("32-998");
        WebElement saveData = driver.findElement(By.cssSelector("#content > div > div > form > footer > button"));
        saveData.click();
    }

    @And("I check written data")
    public void iCheckWrittenData() {
        String alias = "Spokojny";
        String address = "Wieczna 5";
        String city = "Wieliczka";
        String postal = "32-998";
        verifyData(alias);
        verifyData(address);
        verifyData(city);
        verifyData(postal);
    }

    private void verifyData(String expectedData) {
        WebElement element = driver.findElement(By.xpath("//*[@id='content']/div[5]"));
        String currentText = element.getText();
        Assert.assertTrue(currentText.contains(expectedData));
        System.out.println(expectedData + " -> dane poprawne.");
    }

    @When("I delete address")
    public void iDeleteAddress() {
        //nie poradziłem sobie tym sposobem
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("a[data-link-action='delete-address']")));
//        WebElement deleteAddress = driver.findElement(By.cssSelector("a[data-link-action='delete-address']"));
//        deleteAddress.click();
// Znajdź wszystkie adresy na stronie
        List<WebElement> addresses = driver.findElements(By.cssSelector("article.address"));

        //to jest sposób dzięki chatGPT
// Sprawdź, czy lista nie jest pusta
        if (!addresses.isEmpty()) {
            // Znajdź ostatni adres na liście
            WebElement lastAddress = addresses.get(addresses.size() - 1);

            // Znajdź przycisk "Delete" dla ostatniego adresu
            WebElement deleteButton = lastAddress.findElement(By.cssSelector("a[data-link-action='delete-address']"));

            // Kliknij przycisk "Delete"
            deleteButton.click();
        } else {
            System.out.println("Nie znaleziono żadnych adresów.");
        }

    }

    @And("I verify deleting")
    public void iVerifyDeleting() {
        String alias = "Spokojny";
        String address = "Wieczna 5";
        String city = "Wieliczka";
        String postal = "32-998";
        try {
            verifyData(alias);
            verifyData(address);
            verifyData(city);
            verifyData(postal);
        } catch (AssertionError a) {
            System.out.println("POWYŻSZY ADRES ZOSTAŁ USUNIĘTY");

        }


    }
}
