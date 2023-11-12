Feature: Login Functionality
@LoginIncorrectCredentials @regression @test1 @passed
  Scenario: Login with only valid password
  When user enters only valid password
  And user clicks on the login button
  Then error message Username cannot be empty should be displayed

  @LoginIncorrectCredentials @regression @test2 @passed
  Scenario: Login with only valid user name

  When user enters only valid user name
  And user clicks on the login button
  Then error message Password cannot be empty should be displayed

  @LoginIncorrectCredentials @regression @test3 @failed
  Scenario: Login with incorrect user name and valid password

  When user enters incorrect user name
  And user enters valid password
  And user clicks on the login button
  Then error message Invalid credentials..etc should be displayed

  @LoginIncorrectCredentials @regression @test4 @failed
  Scenario: Login with valid user name and incorrect password

  When user enters valid user name
  And user enters incorrect password
  And user clicks on the login button
  Then error message Invalid credentials..etc should be displayed

  @LoginCorrectCredentials @regression @test5 @passed
  Scenario: User can correct their inputs and attempt to log in again
     # When user attempts to clear user name field after displaying the error message

    When user enters incorrect user name
    And user enters incorrect password
    And user clicks on the login button
    And user enters valid user name
    And user enters valid password
    Then System should allow the user to correct their input and attempt to log in again.




