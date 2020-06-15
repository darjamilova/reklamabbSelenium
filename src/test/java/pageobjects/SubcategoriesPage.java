package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import seleniumsupport.BaseTestClass;

import java.util.List;

public class SubcategoriesPage extends BaseTestClass {
    //e.g. https://reklama.bb.lv/ru/transport/cars/audi/menus.html

    private static final By CATEGORIES_LOCATOR = By.xpath(".//fieldset[contains(@class, 'cats')]//label/h2");
    private static final By PRICE_BOX_LOCATOR = By.id("filter-price");
    private static final By PRICE_MIN = By.name("f_pricemin");
    private static final By PRICE_MAX = By.name("f_pricemax");
    private static final By FILTER_BTN = By.xpath(".//div[@class='popUp']/input[@name='btnSearch']");

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

    public ListOfAdds clickFinalCategory(String categoryName) {
        List<WebElement> categories = getCategories();
        for (WebElement category : categories) {
            if (category.getText().equals(categoryName)) {
                category.click();
                return new ListOfAdds();
            }
        }
        throw new NotFoundException("There is no such category: " + categoryName);
    }

    public ListOfAdds searchByPrice(String minPrice, String maxPrice) {
        findElement(PRICE_BOX_LOCATOR).click();
        findElement(PRICE_MIN).sendKeys(minPrice);
        findElement(PRICE_MAX).sendKeys(maxPrice);
        findElement(FILTER_BTN).click();
        return new ListOfAdds();
    }
}
