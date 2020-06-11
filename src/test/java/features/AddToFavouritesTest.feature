Feature:  Advertisements in favourites

  Scenario: Checking if button 'Add to favs' button is visible and clickable
    Given We have opened the web page
    When We enter any category and open first add
    Then There is a button
    And It is clickable
    And It is visible

#  Scenario: Clicking 'Add to favs' in the category adds add to favorites
#    When We click 'Add to favs' button in category listing
#    Then Add is added to favorites
#
#  Scenario: Clicking 'Add to favs' in the serarch adds add to favorites
#    When We click 'Add to favs' button in search
#    Then Add is added to favorites
#
#  Scenario: Removing advertisements from favorites
#    When We remove all adevertisements form favorites
#    Then Then there are no adversiments in favorites
#
#  Scenario: Adding multiple adds to favorites
#    When Adding 3 atdvertisements to favorites
#    Then There are 3 adversisement in favorites