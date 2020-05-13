Feature: Create Campaign

  @EXECUTE
  Scenario: Campaigns successfully created
  The User will create a new campaign filling all the mandatory fields and using valid information, when him clicks on the save
  buttom a new campaign should be created.
    Given Lucas login into WeCruitIO and select Create new campaigns
    When Lucas enters information into the mandatory fields
    And the information is valid
    And He clicks on the save buttom
    Then A new campaigns should be created
    And The user should be redirected towards Campaign List

  @EXECUTE
  Scenario: Campaigns unsuccessfully created
  The user will try to create a new campaign using invalid information and the system should not allow it.
    Given Lucas login into WeCruitIO and select Create new campaigns
    When Lucas enters new information into the mandatory fields
    And He clicks on the save buttom
    And The information is invalid
    Then He should see a massagge about the unsuccessfully creation of the campaign
    And The labels that contains invalid information should be highlighted on red
    And The information previously entered should be preserved.

  @EXECUTE
  Scenario: Cancelation of campaign creation
  The user will try to cancel the campaign creation before typing some information into the the fields and then will click on the cancel buttom.
    Given Lucas login into WeCruitIO and select Create new campaigns
    When Lucas enters information into the mandatory fields
    And Clicks on the cancel buttom
    Then The user should be redirected towards Campaign List

  @EXECUTE
  Scenario: Entry of invalid inputs
  The user will try to enter invalid and non-existent inputs into certain fields(Campaign name, Start Date, End Date, Role, Requestor, Project).
    Given Lucas login into WeCruitIO and select Create new campaigns
    When Lucas enters invalid inputs into certain fields
    Then The labels that contains invalid information should be highlighted on red
    And Lucas should see and invalid input message



