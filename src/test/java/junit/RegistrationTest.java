package junit;

import hotel.AccountPage;
import hotel.FormPage;
import hotel.MainPage;
import hotel.RegistrationPage;
import org.junit.Before;
import org.junit.Test;


public class RegistrationTest extends AbstractTest {
    //Tu deklarujemy zmienne w typach odpowiadających klasom, które bedziemy używać,
    // (tworzymy pola?)
    private MainPage mainPage;
    private RegistrationPage registrationPage;
    private FormPage formPage;
    private AccountPage accountPage;

    @Before
    public void openBrowser() {
        //2. Tu jest nasza zmienna driver, którą utworzyliśmy w metodzie 'setUp()'.
        // Tu ustawiamy wykonywanie się metody 'setUp()' z klasy AbstractTest,
        // wywołując metodę nie musimy odnosić się do nazwy klasy, dlatego, że
        // klasa w której sie teraz znajdujemy dziedziczy ona po klasie 'AbstractTest'
        setUp("chrome");    //tu jest nasza przeglądarka, którą uruchomilismy.
        // w tej przegladarce musimy wykonywać wszystkie następne czynności, dlatego
        // ta zmienna driver musi byc dalej przekazywana!!!

        //3. Na zmiennej driver uruchamiamy konkretny adres internetowy w przeglądarce, którę
        // uruchomilismy w punkcie 2 za pomocą metody 'setUp()'
        driver.get("https://hotel-testlab.coderslab.pl/pl/");

        //4. Tu nasza zmienna driver jest parametrem klasy 'MainPage', żeby wszystkie czynności
        // z wszystkich metod (np.: metoda "goToRegistrationPage()) klasy 'MainPage' uruchamiały
        // się w tej przeglądarce, którą już uruchomiliśmy zapomocą naszej zmiennej driver (która
        // nie może się nigdzie zmieniać).
        // Tu inicjalizujemy zmienną 'mainPage' pochodzącą z klasy 'MainPage'
        // chociaż mogło to wyglądać tak:'private MainPage mainPage = new MainPage(driver);',
        // to tu jest skrócone, bo wcześniej zadeklarowaliśmy już zmienną (pole klasy) z klasy 'MainPage',
        // więc teraz po prostu zainicjowaliśmy zmienną 'mainPage' w poniższy sposób:
        mainPage = new MainPage(driver);

    }

    @Test
    public void registrationTest() {
        mainPage.goToRegistrationPage();
        registrationPage = new RegistrationPage(driver);
        String mail = registrationPage.randomEmail();
        registrationPage.typeEmail(mail);
        registrationPage.createAccount();
        formPage = new FormPage(driver, wait);
        formPage.selectTitle();
        formPage.typeFirstName();
        formPage.typeLastName();
        formPage.checkEmail(mail);
        formPage.typePassword();
        formPage.chooseDay();
        formPage.chooseMonth();
        formPage.chooseYear();
        formPage.selectCheckbox1();
        formPage.selectCheckbox2();
        formPage.register();
        accountPage = new AccountPage(driver);
        accountPage.countButtons();
        accountPage.buttons();
    }


}
