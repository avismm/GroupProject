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



