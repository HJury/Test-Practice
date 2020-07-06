Feature: Campaign: List

  Background: A web browser is at WeCruit "Campaign List"  page and the list displayed contains campaigns
    Given the user login into WeCruitIO
    And gets into Campaign List page


  @EXECUTE
  #Verify that All the existent campaigns are shown When the filter "All" is applied##
  Scenario: The "All" Filter shows all the campaigns
    When the user clicks on the 'All' Filter button
    Then the user should see all the campaign displayed on the list

  @EXECUTE
  #Verify that All the existent campaigns are shown When the filter "All" is applied##
  Scenario: The "My Campaigns" Filter shows all the campaigns
    When the user clicks on the 'My Campaigns' Filter button
    Then the user should see the campaign that he created

  @EXECUTE
  Scenario Outline: Long values on the fields shows ellipsis and tooltips
  The value of the columns: Name, Role, Requestor, Project show ellipsis when the value doesn't fit
  and a tooltip is present with the whole value of the columns
    Given a campaign with long values on <field> exists
    When the user puts the mouse over the value of the <field>
    Then the user should see a hover with the whole value of the <field>

    Examples:
      | field     |
      | Name      |
      | Requestor |
#      | Project   |
      | Role      |
 #     | Skill     |


  @EXECUTE
  Scenario Outline: Change of Campaign state with action buttons
    And a campaign has the status <current status>
    When the user click on the action <button>
    Then the state of the campaign should change to <status>
    And the action buttons <action> and Edit are shown

    Examples:
      | current status | button       | status  | action |
      | Active         | Pause Button | On Hold | Play   |
      | On Hold        | Play Button  | Active  | Pause  |

  @EXECUTE
  #Verify that the user is redirected to the Add new campaign page when the user clicks/taps on "+ Add New"##
  Scenario: Redirection towards "Add New Campaign" page
    When the user click on the + Add New button
    Then the user should be redirected towards 'Campaign Add' page
      #I should add a introction to return towards Campaign list

  @EXECUTE
  #Verify that the list of campaigns contains the following columns: Name, Role, Requestor, Skills, End Date, Status, Actions##
  Scenario: The list contains the columns :Name, Role, Requestor, Skills,
  End Date, Status, Actions and a second line info with:Project Name,
  Start Date and Created by.
    Then the list should contains the column
