Feature: Editing Employee Personal Information

  Background:
    #Given user is navigated to HRMS application
    When employee enters username and password
    Then employee clicks on the login button
    #Then user closes the browser



  @editEmployeeInfo @test987
  Scenario: Employee can Edits Personal Information

    When employee clicks on the My Info button
    And employee clicks on Edit Button
    And employee enters updated personal information
    And employee saves the changes by clicking on Save Button
    Then employee's personal information is successfully updated