Feature: Language scenarios

Scenario: As an admin user should be able to add different languages in qualifications

  Given “Admin” user is logged in
  When “Admin” navigates to Qualifications
  And selects Language
  Then “Admin” user can add any Language
