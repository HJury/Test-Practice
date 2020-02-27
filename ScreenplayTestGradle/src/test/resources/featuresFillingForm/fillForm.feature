Feature: Filling out the form
  in this form an user will try to fill a form and submit the information.

  @Execute
  Scenario: Filling out correctly the form
    Given Luisa gets into the automation practice form
    When Luisa enters the information needed
    Then She should see his profile in the webTable