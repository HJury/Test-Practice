Feature: Navigation funtionality on Google page

  Scenario: Verification of Goldilocks title

    Given Open the Firefox and searching for Goldilocks Tale on Google.com
    When Goldilocks tale's page is full charger
    Then Compare the title of the page with "Goldilocks Tale - Buscar con Google"