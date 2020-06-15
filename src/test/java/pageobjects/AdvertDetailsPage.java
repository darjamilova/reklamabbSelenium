package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumsupport.BaseTestClass;

public class AdvertDetailsPage extends BaseTestClass {

    private static final By FAVOURITE_BUTTON = By.id("favs-link");

    public void addRemoveFavorite() {
//        WebDriverWait wait = new WebDriverWait(driver(), 10);
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(FAVOURITE_BUTTON));
//        } catch (TimeoutException e) {
//            System.out.println("Element by" + FAVOURITE_BUTTON + " was not found or not clickable");
//        }
        WebElement favouriteButton = findElement(FAVOURITE_BUTTON);
        scrollToElement(favouriteButton);
        favouriteButton.click();
    }
}
