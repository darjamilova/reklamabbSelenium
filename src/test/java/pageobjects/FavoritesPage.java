package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import seleniumsupport.BaseTestClass;

import java.util.List;

public class FavoritesPage extends BaseTestClass {

    private final static By TEXT_OF_ADVERT = By.xpath(".//div[@id='icon_view']//p");
    private final static By REMOVE_FAVORITE_ICON = By.className("fav-remove");


    public int numberOfAdvertsOnThePage() {
        return findElements(TEXT_OF_ADVERT).size();
    }

    private boolean isAddInTheList(String addText) {
        List<WebElement> listOfAdds = findElements(TEXT_OF_ADVERT);
        if (listOfAdds.size() == 0) return false;
        else
            for (WebElement add : listOfAdds) {
                if (add.getText().contains(addText)) return true;
            }
        return false;
    }

    public boolean checkIfAllAdvertsAddedToFavoritesPage(List<String> shouldBeInFavorites) {
        boolean allGood = true;
        for (String advert : shouldBeInFavorites) {
            System.out.println(advert);
            if (!isAddInTheList(advert)) allGood = false;
        }
        return allGood;
    }

    public void removeAllAdvertFromFavs() {
        while (findElements(TEXT_OF_ADVERT).size() != 0) {
            WebElement advert = findElements(TEXT_OF_ADVERT).get(0);
            scrollToElement(advert);
            Actions builder = new Actions(driver());
            builder.moveToElement(advert).build().perform();
            List<WebElement> favsButtons = findElements(REMOVE_FAVORITE_ICON);
            for (WebElement button : favsButtons) {
                if (button.isDisplayed()){
                    button.click();
                    break;
                }
            }
        }
    }


}
