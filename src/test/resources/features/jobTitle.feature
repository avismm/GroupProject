Feature: add Job Title feature

  Background:
    * user enters username and password
    * user clicks on login button
    * user is successfully logged in

  @jobTitle
  Scenario: add  new job Title
    When user clicks on admin button
    And user clicks on Job button
    And user clicks on Job Title button
    And user clicks on Add Button
    And user enters jobTitle "SDET45301219" desc "Automating and testing website" note "Exceptional well"
    And user clicks on the save button
    And verify same info from backend