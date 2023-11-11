package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.*;

public class EmployeeAddLanguageSteps extends CommonMethods {
    @Given("employee enters valid user name and password")
    public void employee_enters_valid_user_name_and_password() {
       sendText(loginPage.usernameTextField, ConfigReader.getPropertyValue("empUserName"));
       sendText(loginPage.passwordField, ConfigReader.getPropertyValue("password"));
    }

    @Given("employee clicks on login button")
    public void employee_clicks_on_login_button() {
     click(loginPage.loginBtn);
    }

    @Given("employee navigates to My Info page")
    public void employee_navigates_to_My_Info_page() {
    click(myInfoPage.myInfoBtn);
    }

    @Given("employee clicks on qualifications button")
    public void employee_clicks_on_qualifications_button() {
       click(myInfoPage.qualificationsBtn);
    }

    @Given("employee clicks on Add button in languages section")
    public void employee_clicks_on_add_button_in_languages_section() {
        click(myInfoPage.addLanguageBtn);
    }

    @Then("employee should see a list of available languages to choose Chinese later")
    public void employee_should_see_a_list_of_available_languages_to_choose_chinese_later() {

        List<String> standardLanguagesList = Arrays.asList("Afrikaans",
     "Albanian", "Arabic", "Belarusian", "Bulgarian", "Catalan", "Chinese", "Croatian", "Czech", "Danish",
     "Dutch", "English", "Esperanto", "Estonian", "Filipino", "Finnish", "French", "Galician", "Georgian",
     "German", "Greek", "Creole", "Hebrew", "Hindi", "Hungarian", "Icelandic", "Indonesian", "Irish",
     "Italian", "Japanese", "Korean", "Latvian", "Lithuanian", "Macedonian", "Malay", "Maltese",
     "Norwegian", "Persian", "Polish", "Portuguese", "Romanian", "Russian", "Slovak", "Slovenian",
     "Spanish", "Swahili", "Swedish", "Thai", "Turkish", "Ukrainian", "Vietnamese", "Welsh");
        List<String> actualLanguagesList=new LinkedList<>();
        Select select=new Select(myInfoPage.languageDropDown);

        for (int i = 1; i <select.getOptions().size(); i++) {

            actualLanguagesList.add(select.getOptions().get(i).getText());

        }

        JavascriptExecutor Js=(JavascriptExecutor)driver;
      //  Js.executeScript("window.scrollBy(0, 300)");
        Js.executeScript("arguments[0].style.border='3px solid red'",myInfoPage.languageDropDown);
        click(myInfoPage.languageDropDown);
        Assert.assertEquals(standardLanguagesList,actualLanguagesList);


    }

   @When("employee selects a language from language dropdown")
    public void employee_selects_a_language_from_language_dropdown() {
        Select select=new Select(myInfoPage.languageDropDown);
        select.selectByVisibleText("French");
       // myInfoPage.languageDropDown.sendKeys("Chinese");
    }

    @When("employee fills mandatory fields for next 2 dropdowns and clicks save")
    public void employee_fills_mandatory_fields_for_next_2_dropdowns_and_clicks_save() {
        Select select=new Select(myInfoPage.languageFluencyDropDown);
        select.selectByIndex(1);
        Select select2=new Select(myInfoPage.languageCompetencyDropDown);
        select2.selectByIndex(1);
        click(myInfoPage.languageSaveBtn);
    }
    @Then("the selected language is saved")
    public void the_selected_language_is_saved() {

        String textLanguageCellContentAfterSaving = myInfoPage.languageCellContentAfterSavingLocator.getText();
        Assert.assertEquals("French",textLanguageCellContentAfterSaving);
        JavascriptExecutor Js=(JavascriptExecutor)driver;
        Js.executeScript("arguments[0].style.border='2px solid green'",myInfoPage.languageCellContentAfterSavingLocator);
    }
    @Given("employee can select the fluency level from fluency dropdown as \\(Basic, Intermediate, Advanced, Fluent)")
    public void employee_can_select_the_fluency_level_from_fluency_dropdown_as_basic_intermediate_advanced_fluent() throws InterruptedException {
        List<String> expectedList=new ArrayList();
        expectedList.add("Basic");
        expectedList.add("Intermediate");
        expectedList.add("Advanced");
        expectedList.add("Fluent");
        Select select=new Select(myInfoPage.languageFluencyDropDown);
        List<WebElement> langFluencyDropDownOptions = select.getOptions();

        List<String> actualListText=new ArrayList();

        for (int i = 1; i <langFluencyDropDownOptions.size() ; i++) {

            actualListText.add(langFluencyDropDownOptions.get(i).getText());
        }

        JavascriptExecutor Js=(JavascriptExecutor)driver;
        Js.executeScript("window.scrollBy(0, 300)");
        Js.executeScript("arguments[0].style.border='3px solid red'",myInfoPage.languageFluencyDropDown);

        click(myInfoPage.languageFluencyDropDown);

        Assert.assertEquals(expectedList,actualListText);

    }

    @Given("employee can select the Competency level from Competency dropdown as \\(Speaking, Reading, Writing)")
    public void employee_can_select_the_competency_level_from_competency_dropdown_as_speaking_reading_writing() {
        List<String> expectedCompetencyList=new ArrayList();
        expectedCompetencyList.add("Speaking");
        expectedCompetencyList.add("Reading");
        expectedCompetencyList.add("Writing");
        Select select=new Select(myInfoPage.languageCompetencyDropDown);
        List<WebElement> langCompetencyDropDownOptions = select.getOptions();

        List<String> actualCompetencyListText=new ArrayList<>();

        for (int i = 1; i <langCompetencyDropDownOptions.size() ; i++) {

            actualCompetencyListText.add(langCompetencyDropDownOptions.get(i).getText());
        }

        JavascriptExecutor Js=(JavascriptExecutor)driver;
        Js.executeScript("window.scrollBy(0, 300)");

        click(myInfoPage.languageCompetencyDropDown);
        Js.executeScript("arguments[0].style.border='3px solid red'",myInfoPage.languageCompetencyDropDown);
        Assert.assertEquals(expectedCompetencyList,actualCompetencyListText);

    }
    @Then("employee can enter text in additional comments in language proficiency text box")
    public void employee_can_enter_text_in_additional_comments_in_language_proficiency_text_box() {

        sendText(myInfoPage.commentsTextBox, "Text comment for testing purpose");
        JavascriptExecutor Js=(JavascriptExecutor)driver;
        Js.executeScript("window.scrollBy(0, 100)");
        Js.executeScript("arguments[0].style.border='2px solid green'",myInfoPage.commentsTextBox);
        Assert.assertTrue(myInfoPage.commentsTextBox.isEnabled());
    }

    @When("employee has not filled mandatory fields and tries to save language proficiency")
    public void employee_has_not_filled_mandatory_fields_and_tries_to_save_language_proficiency() {
      click(myInfoPage.languageSaveBtn);
    }
    @Then("the system should display an error message")
    public void the_system_should_display_an_error_message() {
        Assert.assertTrue(myInfoPage.mandatoryFieldsErrorMsg.isDisplayed());
    }
    @When("employee clicks on the saved language to edit the language proficiency details")
    public void employee_clicks_on_the_saved_language_to_edit_the_language_proficiency_details() {
        click(myInfoPage.languageEditAfterSavingLocator);
    }
    @Then("the system should allow him to edit the language option")
    public void the_system_should_allow_him_to_edit_the_language_option() {
        Assert.assertTrue(myInfoPage.languageDropDown.isDisplayed());
    }
    @Then("the system should allow him to edit the fluency option")
    public void the_system_should_allow_him_to_edit_the_fluency_option() {
        Assert.assertTrue(myInfoPage.languageFluencyDropDown.isDisplayed());
    }
    @Then("the system should allow him to edit the competency option")
    public void the_system_should_allow_him_to_edit_the_competency_option() {
        Assert.assertTrue(myInfoPage.languageCompetencyDropDown.isDisplayed());
    }
    @Then("the system should allow him to edit the comments box")
    public void the_system_should_allow_him_to_edit_the_comments_box() {
        Assert.assertTrue(myInfoPage.commentsTextBox.isDisplayed());
    }
    @When("employee clicks on language check box in the previously saved languages table")
    public void employee_clicks_on_language_check_box_in_the_previously_saved_languages_table() {
       click(myInfoPage.languageCheckBox);
    }
    @When("employee clicks on delete button")
    public void employee_clicks_on_delete_button() {
        click(myInfoPage.deleteLanguageBtn);
    }
    @Then("the previously saved language is deleted")
    public void the_previously_saved_language_is_deleted() {
        Assert.assertNotEquals("French",myInfoPage.languageCellContentAfterSavingLocator.getText());
    }



}