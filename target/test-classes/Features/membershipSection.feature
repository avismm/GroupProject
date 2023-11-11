Feature: Employee Membership Management


Background:
    #Given user is navigated to HRMS application
    When employee enters username and password
    And user clicks on login button
    Then user is successfully logged in
    #Then user closes the browser
    #Given the employee is logged in
    When the employee accesses their profile
    And navigates to the membership section
    Then the employee should be able to view the membership details

  @membership @regression @passed
  Scenario: Add a Membership details
    When the employee selects the membership type from the dropdown field and validate that is filled in
    And selects the entity that paid for the subscription paid by from the dropdown field and validate that is filled in
    And enters the subscription amount in the text box and validate that is filled in
    And selects the currency used for the subscription from the dropdown field
    And selects the subscription commence date from the calendar and validate that is filled in
    And selects the subscription renewal date from the calendar
    And clicks on the save button
    Then the system should store the membership details in the employee's profile

  @membership @regression @passed
  Scenario: Editing Previously Saved Membership Details
    #Given the employee is on the membership section of their profile
    When the employee selects the previously saved membership details
    And makes the necessary edits
    And clicks on the save button after editing
    Then the system should update the membership details in the employee's profile


    @membership @regression @passed
  Scenario: Displaying Membership Details on Profile Page
    #Given the employee is on their profile page
    Then the membership details should be displayed in a clear and organized format

  @membership @regression @passed
  Scenario: Deleting Previously Saved Membership Details
    #Given the employee is on the membership section of their profile
    When the employee selects the previously saved membership details in membership profile
    And clicks on the delete button
    Then the system should remove the membership details from the employee's profile





