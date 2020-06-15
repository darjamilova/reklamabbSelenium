package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import seleniumsupport.BaseTestClass;

import java.util.LinkedList;
import java.util.List;

public class ListOfAdds extends BaseTestClass {
    //e.g. https://reklama.bb.lv/ru/job_and_studies/jobs_offered/administration/managers/otrasli/table.html
    private final static By ADVERT_TEXT_LOCATOR = By.xpath(".//div[@class='text']/a");
    private final static By ADD_FAVORITE_ICON = By.xpath(".//a[@class='fav-add']/img");
    private final static By REMOVE_FAVORITE_ICON = By.xpath(".//a[@class='fav-remove']/img");
    private List<WebElement> advertsAddedToFavorites = new LinkedList<WebElement>();

    public List<WebElement> getAdvertsAddedToFavorites() {
        return advertsAddedToFavorites;
    }

    private List<WebElement> getAllAddTexts() {
        return findElements(ADVERT_TEXT_LOCATOR);
    }

    public AdvertDetailsPage clickAdd(int addIndexInList) {
        WebElement advertToClick = getAllAddTexts().get(addIndexInList);
        advertsAddedToFavorites.add(advertToClick);
        advertToClick.click();
        return new AdvertDetailsPage();
    }

    public void addRemoveAdvertToFavs(int indexOfAdvert, boolean actionAdd) {
        WebElement advert = findElements(ADVERT_TEXT_LOCATOR).get(indexOfAdvert);
//        scrollToElement(advert);
//        Actions builder = new Actions(driver());
//        builder.moveToElement(advert).build().perform();
        hoverOverElement(advert);
        if (actionAdd) {
            WebElement advertFavoriteIcon = findElements(ADD_FAVORITE_ICON).get(indexOfAdvert);
            advertFavoriteIcon.click();

        } else {
            WebElement advertFavoriteIcon = findElements(REMOVE_FAVORITE_ICON).get(indexOfAdvert);
            advertFavoriteIcon.click();
        }
    }
}
