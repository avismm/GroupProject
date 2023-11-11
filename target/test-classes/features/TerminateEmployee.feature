Feature: Terminate employee

  Background:
    * user enters username and password
    * user clicks on login button
    * user is successfully logged in
    * user clicks on PIM option

  @terminate
  Scenario: Terminating employment of an employee
    #Given user has navigated to HRMS application
    When user clicks on Employee List option
    And user enters employee id
    And user clicks on search button
    And user selects a specified employee from the list
    And user navigates to the employee job page
    And user selects the terminate employee button
    And user clicks on the confirm button
    Then employee is terminated successfully


