Feature: add any Memberships scenarios
  Background:
    #Given user is navigated to HRMS application
    When user enters username and password
    And user clicks on login button
    Then user is successfully logged in
    @addMemberships @test123
    Scenario: add different memberships under qualifications
      When  Admin clicks on Admin option
      And   Admin clicks on Qualifications option
      Then  Admin clicks on Memberships option
      Then  Admin clicks on Add option
      Then  Admin enter Membership Name
      Then  Admin clicks on save button



