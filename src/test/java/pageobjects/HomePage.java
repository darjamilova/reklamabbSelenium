package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import seleniumsupport.BaseTestClass;

import java.util.List;

public class HomePage extends BaseTestClass {
    //https://reklama.bb.lv/ru/
    private static final By CATEGORIES_LOCATOR = By.xpath(".//ul[contains(@class, 'categories')]//a/h3");

    private List<WebElement> getCategories() {
        return findElements(CATEGORIES_LOCATOR);
    }

    public SubcategoriesPage clickCategory(String categoryName) {
        List<WebElement> categories = getCategories();
        for (WebElement category : categories) {
            if (category.getText().equals(categoryName)) {
                category.click();
                return new SubcategoriesPage();
            }
        }
        throw new NotFoundException("There is no such category: " + categoryName);
    }

}
