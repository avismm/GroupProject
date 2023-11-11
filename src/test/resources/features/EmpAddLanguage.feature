Feature: Employee language proficiency details
#Ahmed's feature file
  Background:
     When employee enters valid user name and password
     And  employee clicks on login button
     *    employee navigates to My Info page
     *    employee clicks on qualifications button

  @empAddLanguage @failed @regression
  Scenario: Language dropdown field where employee can select language they are proficient in

    *    employee clicks on Add button in languages section
    Then employee should see a list of available languages to choose Chinese later

    Then the selected language is saved

  @FluencyDD  @failed @regression
  Scenario: Fluency dropdown field where employee can select fluency level

    *  employee clicks on Add button in languages section

    Then employee can select the fluency level from fluency dropdown as (Basic, Intermediate, Advanced, Fluent)

  @CompetencyDD @failed @regression
  Scenario: Competency dropdown field where employee can select competency level

    *  employee clicks on Add button in languages section
    Then employee can select the Competency level from Competency dropdown as (Speaking, Reading, Writing)

  @CommentsTextBox @regression @passed
    Scenario: Comments text box where the employee can enter additional comments

    *    employee clicks on Add button in languages section
    Then employee can enter text in additional comments in language proficiency text box

  @MandatoryFieldsValidation @regression @passed
  Scenario: System validates mandatory fields before saving

    * employee clicks on Add button in languages section
    * employee has not filled mandatory fields and tries to save language proficiency
    Then the system should display an error message

  @EditingSavedLanguageDetails @failed @regression
  Scenario: Employee can edit saved language option

    *  employee clicks on Add button in languages section
    *  employee selects a language from language dropdown
    *  employee fills mandatory fields for next 2 dropdowns and clicks save
    *  employee clicks on the saved language to edit the language proficiency details
    Then the system should allow him to edit the language option

  @EditingSavedLanguageDetails @failed @regression

  Scenario: Employee can edit saved fluency option

    *  employee clicks on Add button in languages section
    *  employee selects a language from language dropdown
    *  employee fills mandatory fields for next 2 dropdowns and clicks save
    *  employee clicks on the saved language to edit the language proficiency details
    Then the system should allow him to edit the fluency option

  @EditingSavedLanguageDetails @regression @passed
  Scenario: Employee can edit saved competency option

    *  employee clicks on Add button in languages section
    *  employee selects a language from language dropdown
    *  employee fills mandatory fields for next 2 dropdowns and clicks save
    *  employee clicks on the saved language to edit the language proficiency details
    Then the system should allow him to edit the competency option

  @EditingSavedLanguageDetails @regression @passed
  Scenario: Employee can edit saved comments text box

    *  employee clicks on Add button in languages section
    *  employee selects a language from language dropdown
    *  employee fills mandatory fields for next 2 dropdowns and clicks save
    *  employee clicks on the saved language to edit the language proficiency details
    Then the system should allow him to edit the comments box

  @DeletingSavedLanguageDetails @regression @passed
  Scenario: Employee can delete previously saved language proficiency details

    *  employee clicks on Add button in languages section
    *  employee selects a language from language dropdown
    *  employee fills mandatory fields for next 2 dropdowns and clicks save
    *  employee clicks on language check box in the previously saved languages table
    *  employee clicks on delete button
    Then the previously saved language is deleted