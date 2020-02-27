Feature: Fill out of the form
  In this feature the form located in the Automation Demo Site Page will be filled it and submitted.

  Scenario: The form is filled and submitted
    Given Lucas gets into the Automation Demo Site
    When Lucas fills out the form with his information
    Then Lucas should see his submit on the WebTable
