package junit;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractTest {

    WebDriver driver;
    WebDriverWait wait;

    public void setUp(String browser) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\winse\\WebDrivers\\chromedriver.exe");
        //1.Tu pierwszy raz przypisujemy do zmiennej driver plik otwierający przeglądarkę
        driver = getDriver(browser);
        //        driver = new ChromeDriver(); //usunąłem to bo wybieram inną przeglądarkę parametrem w powyższej linijce
        wait = new WebDriverWait(driver, 5);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    //metoda fabrykująca, różne obiekty w zależności od parametru, ale ten sam 'model' też to jest przeglądarka
    private WebDriver getDriver(String browser) {
        switch (browser.toUpperCase()) {
            case "FIREFOX": {   //ten case nie wykona się, bo nie mam przeglądarki Firefox
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\winse\\WebDrivers\\geckodriver.exe");
                return new FirefoxDriver();
            } //break; // nie może byc bo jest return w każdym case'ie
            default: {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\winse\\WebDrivers\\chromedriver.exe");
                return new ChromeDriver();
            }
        }
    }

}
