Feature: WebElements reachability
  It will be test the capability of the WebElements of being reach.

  Background:Lucas gets into the Practice Page

  @ignore
  Scenario: Filling the textBox fields
    When Lucas enters his names and date into the respective field
    Then Lucas should see what his names and date on the respective field

  @ignore
  Scenario: Selecting in groupButtoms and checkBoxes
    When Lucas selects and option of the groupButttoms
    And checks all the checkBoxes
    Then Lucas should see what he selected and checked

  @ignore
  Scenario: Selecting into the selectBoxes and the multi-selectBoxes
    When Lucas selects and option from the select box
    And selects an option of the multi-selected box
    Then Lucas should see what he selected

  @ignore
  Scenario: Uploading a document
    When Lucas uploads a document
    Then Lucas Should see the name of the document.

  @Execute
  Scenario: Downloading a document
    When Lucas download a document
    Then he should see the document

  @Execute
  Scenario: A thousand clicks to a button
    When lucas clicks thousand times on the button
    Then the test should ends.