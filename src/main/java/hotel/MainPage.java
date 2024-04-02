package hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {
    //5. W tej klasie wykonując czynności w przeglądarce, musimy je wykonać na przeglądarce
    // już otwartej dzięki zmiennej driver, ale tej utworzonej w klasie 'AbstractTest'.
    // Żeby to zrobić musimy użyć interfejsu 'WebDriver', który jest odpowiedzialny za
    // sterowanie? przeglądarkami, więc deklarujemy zmienną takiego interfejsu, ale niestety
    // to jest już inna zmienna (bo w klasie 'AbstractTest' metody inicjalizujące zmienną driver
    // są 'private', żeby nie było dostępu do tej klasy)......
    private WebDriver driver;
    // ...... a tu dzięki zparametryzowaniu klasy 'MainPage' (parametrem jest właśnie ten driver
    // który odpowiada za to pierwsze uruchomienie przeglądarki, który będzie wywoływany w klasie
    // 'RegistrationPage', która dziedziczy po klasie 'AbstractTest' i dzięki czemu jest to cały
    // czas ten sam'driver') możemy użyć tej dobrej zmiennej driver i przypisać ją do tej, którą
    // w tej klasie utworzyliśmy za pomocą 'this.driver = driver'. Pierwszy driver to jest
    // nasza nowa zmienna, a drugi driver to ten z klasy 'AbstractTest'. Dopiero teraz można
    // wywoływać w tej klasie tego pierwszego "drivera", który już otworzył przeglądarkę, w której
    // chcemy wykonywać następne czynności.
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //zakomentowałem to poniżej, bo użyłem tego bezpośrednio w haczyku @Before w 'RegistrationTest.java'
//    public void goToMainPage() {
//        driver.get("https://hotel-testlab.coderslab.pl/pl/");
//    }

    public void goToRegistrationPage(){
        WebElement logButton = driver.findElement(By.cssSelector("a.user_login"));
        logButton.click();
    }
}
