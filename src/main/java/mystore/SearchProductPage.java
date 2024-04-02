package mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchProductPage {
    private WebDriver driver;


    public SearchProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(){
        WebElement search = driver.findElement(By.cssSelector("input[aria-label=Search]"));
        search.sendKeys("Hummingbird Printed Sweater");
        search.sendKeys(Keys.ENTER);

    }
}
