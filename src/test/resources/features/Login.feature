Feature: Login scenarios

  @sprint2 @test2
  Scenario: valid admin login
   # Given user is navigated to HRMS application
    When user enters username and password
    And  user clicks on login button
    Then user is successfully logged in
    #Then user close the browser