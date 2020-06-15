Feature:  Advertisements in favourites

  Scenario: Adding advertisement to favorites from the advertisement details page
    Given We have opened the home page
    When We enter category "Легковые авто"
    And Open subcategory "Audi" "A6"
    And Open first advertisement
    And Add it to favorites
    Then Advertisement appears in the favorites category

  Scenario: Adding multiple advertisements to favorites from the list of the advertisements
    Given We have opened the home page
    When We enter category "Легковые авто"
    And Open subcategory "Audi" "A6"
    And Add 3 advertisements to the favorites from the list
    Then 3 advertisements appear in the favorites category

# To-do   And these are exactly those advertisements we have added

  Scenario: Adding advertisement to favorites from the search page
    Given We have opened the home page
    And We enter category "Легковые авто"
    When We have filtered by min price 1000 and max price 5000
    And We add advertisement to favorites from the search page
    Then Advertisement appears in the favorites page

  Scenario: Removing advertisements from favorites
    Given We have already added some advertisements in favorites category
    When We remove all advertisements form favorites
    Then Then there are no advertisements in favorites
