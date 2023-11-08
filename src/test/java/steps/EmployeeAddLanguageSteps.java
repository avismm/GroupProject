package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import pages.MyInfoPage;
import utils.CommonMethods;
import utils.ConfigReader;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeAddLanguageSteps extends CommonMethods {
    @Given("employee enters user name and password")
    public void employee_enters_user_name_and_password() {
       sendText(loginPage.usernameTextField, ConfigReader.getPropertyValue("employeeUserName"));
       sendText(loginPage.passwordField, ConfigReader.getPropertyValue("password"));
    }

    @Given("employee clicks on my login button")
    public void employee_clicks_on_my_login_button() {
     click(loginPage.loginBtn);
    }

    @Given("employee clicks on my info button")
    public void employee_clicks_on_my_info_button() {
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

    @When("employee selects a language from language dropdown")
    public void employee_selects_a_language_from_language_dropdown() {
        Select select=new Select(myInfoPage.languageDropDown);
        select.selectByVisibleText("English");
    }
    @Then("the selected language is selected")
    public void the_selected_language_is_selected() {

        JavascriptExecutor Js=(JavascriptExecutor)driver;
        Js.executeScript("window.scrollBy(0, 300)");
        Js.executeScript("arguments[0].style.border='2px solid green'",myInfoPage.languageDropDown);
        Assert.assertTrue(myInfoPage.englishLanguageLoc.isSelected());
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

        List<String> actualListText=new ArrayList<>();

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
       // Js.executeScript("arguments[0].style.border='3px solid red'",myInfoPage.languageCompetencyDropDown);
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

    }