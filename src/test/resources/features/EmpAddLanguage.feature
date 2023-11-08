Feature: Employee language proficiency details
#Ahmed's feature file
  Background:
     When employee enters user name and password
     And employee clicks on my login button
     And employee clicks on my info button
     And employee clicks on qualifications button

  @empAddLanguage @test
  Scenario: Employee can add a language to his language proficiency section

    *  employee clicks on Add button in languages section
    *  employee selects a language from language dropdown
       Then the selected language is selected

  @FluencyDD @test
  Scenario: A dropdown field where the employee can select their level of fluency in the language

    *  employee clicks on Add button in languages section
    Then employee can select the fluency level from fluency dropdown as (Basic, Intermediate, Advanced, Fluent)

  @CompetencyDD @test
  Scenario: A dropdown field where the employee can select their competency level in the language
    *  employee clicks on Add button in languages section
    Then employee can select the Competency level from Competency dropdown as (Speaking, Reading, Writing)

  @CommentsTextBox @test
    Scenario: text box where the employee can enter additional comments about their language proficiency

    *  employee clicks on Add button in languages section
    Then  employee can enter text in additional comments in language proficiency text box

  @MandatoryFieldsValidation
  Scenario: system validates mandatory fields

   # *  system validates mandatory fields (Language, Fluency, Competency) are filled in before saving
   # *  verify language proficiency details have been added in the employee's profile.
   # *  employee clicks on language check box in the previously saved languages table
   # *  employee clicks on delete button
   # *  employee previously saved language is deleted
   # *  employee clicks on a language in the languages table
   # *  employee can edit the previously saved language
   # *  employee can edit the fluency field
   # *  employee can edit the additional comments language proficiency text box

