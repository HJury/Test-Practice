Feature: Campaign Edit

  Background: A web browser is at WeCruit "Campaign List"  page and the list displayed contains campaigns
    #This will wait until the page it's fully charged, will create a new campaign
      # and gets into the edit campaign waiting for the information to be displayed
    Given the user login into WeCruitIO
    And gets into Edit Campaign page

  @EXECUTE
  Scenario: Editing a campaign successfully
    When the user edits the campaign information correctly
    And Save the changes
    Then the campaign information should be updated
    #Falta implementar la fecha

  @EXECUTE
  Scenario: Editing a campaign unsuccessfully
    When the user edits the campaign information incorrectly
    And Save the changes
    Then the campaign information shouldn't be updated

  @EXECUTE
  Scenario: Cancel an edition of a campaign
    When the user edits the campaign information correctly
    And Cancel the changes
    Then the modifications should be canceled


