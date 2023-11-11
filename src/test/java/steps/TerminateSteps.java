package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.EmployeeJobPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class TerminateSteps extends CommonMethods {

    @Given("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        click(dashboardPage.pimButton);
    }

    @When("user clicks on Employee List option")
    public void user_accesses_a_list_of_employees_in_the_system() {
        click(dashboardPage.empListButton);
    }

    @When("user enters employee id")
    public void user_enters_employee_id() {
        sendText(employeeSearchPage.empSearchIdField, ConfigReader.getPropertyValue("empId"));
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        click(employeeSearchPage.searchBtn);
    }

    @When("user selects a specified employee from the list")
    public void user_selects_the_specified_employee_from_the_list() {
        WebElement tableCell=driver.findElement(By.xpath("//table//td[a[text()='"+ConfigReader.getPropertyValue("empId")+"']]"));
        tableCell.click();

    }

    @When("user navigates to the employee job page")
    public void user_navigates_to_the_employee_job_page() {
        click(employeeDetailsPage.employeeJobBtn);
    }

    @When("user selects the terminate employee button")
    public void user_selects_the_terminate_employee_button() {
        click(employeeJobPage.employeeTerminateBtn);
    }

    @When("user clicks on the confirm button")
    public void user_clicks_on_the_confirm_button() {
        By elementLocator = By.xpath("//input[@id='dialogConfirm']");
        WebElement element = getWait().until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        element.click();
    }
    @Then("employee is terminated successfully")
    public void employee_is_terminated_successfully()  {
        By elementLocator = By.xpath("//input[@value='Activate Employment']");
        WebElement activateBtn = getWait().until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
       String elementTxt =activateBtn.getAttribute("value");
        Assert.assertEquals("Activate Employment", elementTxt);
    }

}
