package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumsupport.BaseTestClass;

public class AdvertDetailsPage extends BaseTestClass {
    //e.g. https://reklama.bb.lv/ru/transport/cars/audi/a6/buy/11350134.html

    private static final By FAVOURITE_BUTTON = By.id("favs-link");

    public void addRemoveFavorite() {
        WebElement favouriteButton = findElement(FAVOURITE_BUTTON);
        scrollToElement(favouriteButton);
        favouriteButton.click();
    }
}
