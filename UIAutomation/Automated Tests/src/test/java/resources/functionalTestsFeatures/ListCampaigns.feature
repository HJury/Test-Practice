Feature: Campaign: List

  Background: A web browser is at WeCruit "Campaign List"  page and the list displayed contains campaigns

  @EXECUTE
  #Verify the List has 2 possible filters with the following labels: "All" and "My Campaigns"
  Scenario: The "All" and "My Campaigns" filters exist.
    Then the user should see the 'All' and 'My Campaigns' filters

  @EXECUTE
  #Verify that "All" filter is shown selected by default when the Campaign List is opened
  Scenario: The "All" Filter is show by default
    Then the user should see the 'All' filter is selected

  @EXECUTE
  #Verify that "My Campaigns" filter is shown without selection When "All" filter is applied
  Scenario: The "My Campaigns" filter is not selected.
    When the user click on the 'All filter' button
    Then the user should see the 'All Campaigns' filter is not selected

  #Verify that "All" filter is shown unselected When "My Campaigns" filter is applied
  Scenario: The "All" filter is not selected.
    When the user click on the 'All Campaign filter' button
    Then the user should see the 'All' filter is not selected

  @EXECUTE
  #Verify that All the existent campaigns are shown When the filter "All" is applied
  Scenario: The "All" Filter shows all the campaigns
    When the user click on the 'My Campaigns filter' button
    Then the user should see all the campaign displayed on the list

  @EXECUTE
  #Verify that the user is redirected to the Add new campaign page when the user clicks/taps on "+ Add New"
  Scenario: Redirection towards "Add New Campaign" page
    When the user click on the '+ Add New' button
    Then the user should be redirected towards "New Campaign"
      #I should add a introction to return towards Campaign list

#  @EXECUTE
#  #Verify the Campaign list is sorted by Last modified campaign
#  Scenario Outline: Campaign list is sorted by last modified campaign
#    When When the user carried out one of the following <actions>
#    Then the user should see the list sort for last campaign modified
#
#    Examples:
#      | actions             |
#      | Adds new campaign   | Preguntar si el cambiar el estado de una campaña cuenta como un cambio de estado

  @EXECUTE
  #Verify that ellipsis is shown When the value for the column doesn't fit the column width
  Scenario Outline: The columns Name - Role - Requestor show ellipsis when the value doesn't fit
    Given a web browser is at the WeCruitIO New Campaign page
    When the user creates a new campaign with long values on <column>
    And the user click on save button
    Then the user should be redirected towards "Campaing List"
    And the last campaign created be the user should have ellipsis on the <column> values

    Examples:
      | column    |
      | Name      |
      | Role      |
      | Requestor |
      | Project   |

  @EXECUTE
  #Verify that a tooltip is presented with the full column value when the user mouse over the cell for the column
  Scenario Outline: A tooltip is present with the whole value of the columns(Name - Role - Requestor)
    Given a campaign with ellipsis on column exists on the list
    When the user puts the mouse over the value of the <column>
    Then the user should see a hover with the whole value of the <column>

    Examples:
      | column    |
      | Name      |
      | Role      |
      | Requestor |
      | Project   |
#I should add an scenario for each column

  @EXECUTE
  #Verify that a tooltip is presented with the list of Skills required for the campaign when the user hovers over the Skills count
  Scenario:  A tooltip is presented with the list of Skills as a hover
    When the user puts the mouse over the value of the Skill
    Then the user should see a hover with the whole value of the Skill

  @EXECUTE
  #Verify that Play action Icon is shown for campaigns in status "On Hold"
  Scenario: Play action icon is shown for campaigns in status "On Hold"
    Given a Campaign has the status On Hold
    Then the action buttons Play and Edit is shown

  @EXECUTE
  #Verify that Edit action button and Pause action button are shown for each campaign
  Scenario: Edit and Pause action button are shown for each campaign
    Given the Campaign has any status but "On Hold"
    Then the action buttons Pause and Edit are shown for each campaign

  @EXECUTE
  Scenario Outline: Change of Campaign state with action buttons
    Given a campaign has the status <current status>
    When the user click on the <button> button
    Then the state of the campaign should change to <status>

    Examples:
    |current status|button|status|
    |Active  |Pause |On Hold     |
    |Oh Hold |Play  |Active      |

  @EXECUTE
  #Verify that the list of campaigns contains the following columns: Name, Role, Requestor, Skills, End Date, Status, Actions
  Scenario: The list contains the columns
  Name, Role, Requestor, Skills, End Date, Status, Actions
    Then the list should contains the column Name, Role, Requestor, Skills, End Date, Status, Actions

  @EXECUTE
  #Verify that each campaign record presents as a second line info:
  Scenario: Campaigns contain a second line info with:
  Project Name: ProjectName Start Date: CampaignStartDate Created by: User who created the campaign
    Then the list should contains the column: Project Name: ProjectName Start Date: CampaignStartDate Created by: User who created the campaign

  @EXECUTE
  #Verify that the Date Format is
  Scenario: The date format is DD-MonthShortName-YYYY
  The date format should be show as DD-MonthShotName-YYYY