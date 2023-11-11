package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import pages.EditEmployeeInfoPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class EditEmployeeSteps extends CommonMethods {
    @When("employee enters username password")
    public void employee_enters_username_password() {
        sendText(loginPage.usernameTextField, ConfigReader.getPropertyValue("EmployeeUserName"));
        sendText(loginPage.passwordField, ConfigReader.getPropertyValue("PW"));
    }

    @Then("employee clicks on the login button")
    public void employee_clicks_on_the_login_button() {
        click(loginPage.loginBtn);
    }

    @When("employee clicks on the My Info button")
    public void employee_clicks_on_the_my_info_button() {
        click(editEmployeeInfoPage.myInfoBtn);
    }

    @When("employee clicks on Edit Button")
    public void employee_clicks_on_the_edit_button() {

        click(editEmployeeInfoPage.EditBtn);
    }

    @When("employee enters updated personal information")
    public void employee_enters_updated_personal_information() {

        sendText(editEmployeeInfoPage.enterFirstName,"zineb");
        sendText(editEmployeeInfoPage.enterMiddleName,"el");
        sendText(editEmployeeInfoPage.enterLastName, "kassami");

        click(editEmployeeInfoPage.selectGender);

        Select select=new Select(editEmployeeInfoPage.selectNationality);
        select.selectByValue("121");

        Select sel=new Select(EditEmployeeInfoPage.selectMaritalStatus);
        sel.selectByVisibleText("Single");
        getWait();
    }

    @When("employee saves the changes by clicking on Save Button")
    public void employee_saves_the_changes_by_clicking_on_the_save_button() {
        click(EditEmployeeInfoPage.saveBtn);
    }

    @Then("employee's personal information is successfully updated")
    public void employee_s_personal_information_is_successfully_updated() {
        takeScreenshot("personal information has been updated successfully");
        System.out.println("Information has been updated");
    }
}