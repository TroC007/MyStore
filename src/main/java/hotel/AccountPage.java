package hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;

public class AccountPage {

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public void countButtons() {
        ArrayList<WebElement> buttons = new ArrayList<>();
        buttons.addAll(driver.findElements(By.cssSelector("#center_column > div > div > ul > li")));
        if (buttons.size()==5){
            System.out.println("!!!DOBRZE!!!\nNa stronie jest 5 przycisków, oto one:\n");
        }else{
            System.out.println("!!!UWAGA!!! \nNa stronie nie ma 6 przycisków.\nJest ich:");
            System.out.println(buttons.size());
            System.out.println("Oto one:\n");
        }
        // Wyświetl wszystkie elementy z listy
        for (WebElement button : buttons) {
            System.out.println(button.getText()); // lub inna metoda, która zwraca tekst z elementu
        }

    }

    public void buttons() {
        ArrayList<WebElement> buttonsList = new ArrayList<>();
        WebElement firstButton = driver.findElement(By.cssSelector("a[title='Add my first address']"));
        WebElement secondButton = driver.findElement(By.cssSelector("a[title='Orders']"));
        WebElement thirdButton = driver.findElement(By.cssSelector("a[title='Credit slips']"));
        WebElement fourthButton = driver.findElement(By.cssSelector("a[title='Addresses']"));
        WebElement fifthButton = driver.findElement(By.cssSelector("a[title='Information']"));

        buttonsList.add(firstButton);
        buttonsList.add(secondButton);
        buttonsList.add(thirdButton);
        buttonsList.add(fourthButton);
        buttonsList.add(fifthButton);

        for(WebElement a: buttonsList){
            a.click();
            driver.navigate().back();
        }
    }
}
