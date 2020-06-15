package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumsupport.BaseTestClass;

public class Header extends BaseTestClass {
    private final static By linkToFavoritesPage = By.id("favorites-link");

    public FavoritesPage goToFavoritesPage() {
        WebElement linkToFavorites = findElements(linkToFavoritesPage).get(0);
        scrollToElement(linkToFavorites);
        linkToFavorites.click();
        return new FavoritesPage();
    }
}
