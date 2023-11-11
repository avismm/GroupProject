Feature: Language scenarios


  @language
  Scenario: As an admin user should be able to add different languages in qualifications
    When user enters username and password
    And user clicks on login button
    Then user is successfully logged in
    Then user clicks on Admin tab
    And user navigates to Qualifications
    And clicks on Language tab
    And clicks on Add button
    And enters a language
    And clicks on save button
  # Admin would see Language was Successfully added