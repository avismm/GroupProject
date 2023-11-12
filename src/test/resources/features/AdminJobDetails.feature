Feature: Add current job details for employees
  Background:
    When user enters username and password
    And user clicks on login button
    Then user is successfully logged in
    Given user clicks on PIM option

  @adminAddJobDetails @all
  Scenario: Add job details
    When user clicks on Employee List option
    And user enters employees id
    And user clicks on search button
    And user selects the specified employee from the list
    And user navigates to the employee job page
    And user clicks on edit option
    When user clicks on job title dropdown
    And user clicks on desired job title
    Then user clicks on employment status dropdown
    And user clicks on current employment status
    When user clicks on job category dropdown
    And user clicks on current job category
    Then user clicks joined date calendar
    And user clicks the date they joined
    When user clicks on sub unit dropdown
    And user clicks on current sub unit
    Then user clicks on location dropdown
    And user clicks on location
    When user clicks on start date calendar
    And user clicks on start date
    Then user clicks on end date calendar
    And user clicks on end date
    Given user uploads contract details
    Given user has filled out all required fields
    Then user may click the save button
    And job details have been changed successfully