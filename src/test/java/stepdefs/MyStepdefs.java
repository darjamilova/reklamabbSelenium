package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageobjects.*;
import seleniumsupport.BaseTestClass;

import java.util.List;

public class MyStepdefs {
    BaseTestClass baseTestClass = new BaseTestClass();
    HomePage homePage = new HomePage();
    Header header = new Header();
    SubcategoriesPage subcategoriesPage;
    ListOfAdds listOfAdds = new ListOfAdds();
    AdvertDetailsPage advertDetailsPage;
    FavoritesPage favoritesPage;
    List<String> advertsAddedToFavorites;

    @Given("^We have opened the home page$")
    public void weHaveOpenedTheHomePage() {
        baseTestClass.getURL("https://reklama.bb.lv/ru/");
    }

    @When("^We enter category \"([^\"]*)\"$")
    public void weEnterAnyCategory(String categoryName) {
        subcategoriesPage = homePage.clickCategory(categoryName);
    }

    @And("^Open subcategory \"([^\"]*)\" \"([^\"]*)\"$")
    public void openSubcategory(String categoryName, String subcategoryName) {
        subcategoriesPage.clickCategory(categoryName);
        listOfAdds = subcategoriesPage.clickFinalCategory(subcategoryName);
    }

    @And("^Open first advertisement$")
    public void openFirstAdvertisement() {
        advertDetailsPage = listOfAdds.clickAdd(0);
    }

    @And("^Add it to favorites$")
    public void addItToFavorites() {
        advertDetailsPage.addRemoveFavorite();
    }

    @Then("^Advertisement appears in the favorites category$")
    public void advertisementAppearsInTheFavoritesCategory() {
        favoritesPage = header.goToFavoritesPage();
        Assert.assertTrue("Advert not added to favorites", favoritesPage.numberOfAdvertsOnThePage() == 1);
        //to-do: check if correct advert was added to favorites
    }

    @And("^Add (\\d+) advertisements to the favorites from the list$")
    public void addAdvertisementsToTheFavoritesFromTheList(int numberOfAdvertsToAdd) {
        for (int i = 0; i < numberOfAdvertsToAdd; i++) {
            listOfAdds.addRemoveAdvertToFavs(i, true);
        }
    }

    @Then("^(\\d+) advertisements appear in the favorites category$")
    public void advertisementsAppearInTheFavoritesCategory(int numberOfAdvertsAdded) {
        header.goToFavoritesPage();
        Assert.assertTrue("Number of adverts not correct", numberOfAdvertsAdded == 3);
    }

    @When("^We have filtered by min price (\\d+) and max price (\\d+)$")
    public void weHaveFilteredByMinPriceAndMaxPrice(String minPrice, String maxPrice) {
        listOfAdds = subcategoriesPage.searchByPrice(minPrice, maxPrice);
    }

    @When("^We add advertisement to favorites from the search page$")
    public void weAddAdvertisementToFavoritesFromTheSearchPage() {
        listOfAdds.addRemoveAdvertToFavs(0,true);
    }

    @Then("^Advertisement appears in the favorites page$")
    public void advertisementAppearsInTheFavoritesPage() {
        favoritesPage = header.goToFavoritesPage();
        Assert.assertTrue("Advert not added to favorites", favoritesPage.numberOfAdvertsOnThePage() == 1);
    }

    @Given("^We have already added some advertisements in favorites category$")
    public void weHaveAlreadyAddedSomeAdvertisementsInFavoritesCategory() {
        baseTestClass.getURL("https://reklama.bb.lv/ru/transport/cars/audi/a6/table.html");
        listOfAdds.addRemoveAdvertToFavs(0, true);
    }

    @When("^We remove all advertisements form favorites$")
    public void weRemoveAllAdvertisementsFormFavorites() {
        favoritesPage=header.goToFavoritesPage();
        favoritesPage.removeAllAdvertFromFavs();
    }

    @Then("^Then there are no advertisements in favorites$")
    public void thenThereAreNoAdvertisementsInFavorites()  {
        Assert.assertTrue("Adds are not removed",favoritesPage.numberOfAdvertsOnThePage()==0);
    }
}
