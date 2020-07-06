Feature: Add new Campaign

  Background: User is logged in
    Given the user login into WeCruitIO
    And select Create new campaign

  @EXECUTE
  Scenario: Valid campaigns creation
  The User will create a new campaign filling all the mandatory fields and using valid information, when him clicks on the save
  button a new campaign should be created.
    When the user fills out the form with valid information
    And Save the modifications
    Then a new campaign should be created

  @EXECUTE
  Scenario: invalid campaigns creation
  The user will try to create a new campaign using invalid information and the system should not allow it.
    When the user fills out the form with invalid information
    And Save the modifications
    Then a message about the campaign status should be displayed

  @EXECUTE
  Scenario: Cancelation of campaign creation
  The user will try to cancel the campaign creation before typing some information into the the fields and then will click on the cancel buttom.
    When the user fills out the form with valid information
    And Cancel the modifications
    Then the campaign shouldn't be created