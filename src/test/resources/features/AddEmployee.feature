Feature: add employee scenario

  Background:
    * user enters username and password
    * user clicks on login button
    * user is successfully logged in
    * user clicks on PIM option
    * user clicks on add employee option

    @excel @regression @passed
      # Don't forget to change the data in the excel sheet as well as the path for the picture
    Scenario: Adding multiple employees from excel files
      When user adds multiple employees from excel using "Sheet1" and verify them

      @datatable @regression @passed
        #Don't forget to change the data everytime you want to test
        # and don't add more than 9 digits for the employee ID
      Scenario: adding multiple employees from data table
        When user adds multiple employees from data table
          | firstName | middleName | lastName | employeeId|
          | Alvisae     | Samaae          | Muhweraae  | B711121 |
          | Kenanae     | Jonesae         | Andrewae   | B612029  |


  @db
  Scenario: Add Employee from Frontend and verify from DB
    When user enters "fahim7321" and "Naughty1" and "Hedaiy2"
    And user clicks on save button
    Then employee added successfully
    And fetch employee info from backend
    Then verify employee info is properly stored in db
