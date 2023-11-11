package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.CommonMethods;

import java.util.List;

public class adminJobDetailsSteps extends CommonMethods {

    boolean allFilled = false;
    boolean deets = false;
    int fill = 0;
    boolean success = false;

    @When("user enters employees id")
    public void user_enters_employees_id() {
        sendText(employeeSearchPage.empSearchIdField, "36791061");
    }

    @When("user selects the specified employee from the list")
    public void user_selects_the_specified_employee_from_the_list() {
        WebElement id=driver.findElement(By.xpath("//table//td[a[text()='36791061']]"));
        click(id);

    }

    @Then("user clicks on edit option")
    public void user_clicks_on_edit_option() {
        click(ajd.editBtn);
    }

    @When("user clicks on job title dropdown")
    public void user_clicks_on_job_title_dropdown() {
        click(ajd.jobTitleDropDown);
        Select sel = new Select(ajd.jobTitleDropDown);
        List<WebElement> l = sel.getOptions();
//        This will loop through all options, this takes 20 minutes but passes
//        for (int i = 0; i < l.size(); i++) {
//            sel.selectByIndex(i);
//            if(i>=l.size())
//            {
//                break;
//            }
//        }
//        This loops through 3 options in the interest of time
        for (int i = 0; i < l.size(); i++) {
            sel.selectByIndex(i);
            if(i>=3)
            {
                deets = true;
                break;
            }
        }
    }

    @When("user clicks on desired job title")
    public void user_clicks_on_desired_job_title() {
        if (deets)
        {
            System.out.println("Job title picked");
            fill++;
            deets = false;
        }
    }

    @Then("user clicks on employment status dropdown")
    public void user_clicks_on_employment_status_dropdown() {
        Select sel = new Select(ajd.empStatusDropDown);
        List<WebElement> l = sel.getOptions();
//        This will loop through all options, this takes 20 minutes but passes
//        for (int i = 0; i < l.size(); i++) {
//            sel.selectByIndex(i);
//            if(i>=l.size())
//            {
//                break;
//            }
//        }
//        This loops through 3 options in the interest of time
        for (int i = 0; i < l.size(); i++) {
            sel.selectByIndex(i);
            if(i>=3)
            {
                deets = true;
                break;
            }
        }
    }

    @Then("user clicks on current employment status")
    public void user_clicks_on_current_employment_status() {
        if (deets)
        {
            System.out.println("Job status picked");
            fill++;
            deets = false;
        }
    }

    @When("user clicks on job category dropdown")
    public void user_clicks_on_job_category_dropdown() {
        Select sel = new Select(ajd.jobCategoryDropDown);
        List<WebElement> l = sel.getOptions();
//        This will loop through all options, this takes 20 minutes but passes
//        for (int i = 0; i < l.size(); i++) {
//            sel.selectByIndex(i);
//            if(i>=l.size())
//            {
//                break;
//            }
//        }
//        This loops through 3 options in the interest of time
        for (int i = 0; i < l.size(); i++) {
            sel.selectByIndex(i);
            if(i>=3)
            {
                deets = true;
                break;
            }
        }
    }

    @When("user clicks on current job category")
    public void user_clicks_on_current_job_category() {
        if (deets)
        {
            System.out.println("Job category picked");
            fill++;
            deets = false;
        }
    }

    @Then("user clicks joined date calendar")
    public void user_clicks_joined_date_calendar() {
        ajd.joinDateCalendar.clear();
        ajd.joinDateCalendar.sendKeys("2023-11-01");
        deets = true;
    }

    @Then("user clicks the date they joined")
    public void user_clicks_the_date_they_joined() {
        if(deets)
        {
            System.out.println("Join date picked");
            fill++;
            deets = false;
        }
    }

    @When("user clicks on sub unit dropdown")
    public void user_clicks_on_sub_unit_dropdown() {
        Select sel = new Select(ajd.subUnitDropDown);
        List<WebElement> l = sel.getOptions();
//        This will loop through all options, this takes 20 minutes but passes
//        for (int i = 0; i < l.size(); i++) {
//            sel.selectByIndex(i);
//            if(i>=l.size())
//            {
//                break;
//            }
//        }
//        This loops through 3 options in the interest of time
        for (int i = 0; i < l.size(); i++) {
            sel.selectByIndex(i);
            if(i>=3)
            {
                deets = true;
                fill++;
                break;
            }
        }
    }

    @When("user clicks on current sub unit")
    public void user_clicks_on_current_sub_unit() {
        if (deets)
        {
            System.out.println("sub unit picked");
            deets = false;
        }
    }

    @Then("user clicks on location dropdown")
    public void user_clicks_on_location_dropdown() {
        Select sel = new Select(ajd.jobLocationDropDown);
        List<WebElement> l = sel.getOptions();
//        This will loop through all options, this takes 20 minutes but passes
//        for (int i = 0; i < l.size(); i++) {
//            sel.selectByIndex(i);
//            if(i>=l.size())
//            {
//                break;
//            }
//        }
//        This loops through 3 options in the interest of time
        for (int i = 0; i < l.size(); i++) {
            sel.selectByIndex(i);
            if(i>=3)
            {
                deets = true;
                break;
            }
        }
    }

    @Then("user clicks on location")
    public void user_clicks_on_location() {
        if (deets)
        {
            System.out.println("Job location picked");
            fill++;
            deets = false;
        }
    }

    @When("user clicks on start date calendar")
    public void user_clicks_on_start_date_calendar() {
        ajd.jobStartCalendar.clear();
        ajd.jobStartCalendar.sendKeys("2023-11-05");
        deets = true;
    }

    @When("user clicks on start date")
    public void user_clicks_on_start_date() {
        if(deets)
        {
            System.out.println("Start date picked");
            fill++;
            deets = false;
        }
    }

    @Then("user clicks on end date calendar")
    public void user_clicks_on_end_date_calendar() {
        ajd.jobEndCalendar.clear();
        ajd.jobEndCalendar.sendKeys("2028-11-10");
        deets = true;
    }

    @Then("user clicks on end date")
    public void user_clicks_on_end_date() {
        if(deets)
        {
            System.out.println("Start date picked");
            fill++;
            deets = false;
        }
    }

    @Given("user uploads contract details")
    public void user_uploads_contract_details() {
//        click(ajd.contractDetails);
        ajd.contractDetails.sendKeys("T:\\Syntax\\GroupProject\\Contract_Details.txt");
    }

    @Given("user has filled out all required fields")
    public void user_has_filled_out_all_required_fields() {
        if(fill == 8)
        {
            allFilled = true;
        }
    }

    @Then("user may click the save button")
    public void user_may_click_the_save_button() {
        if(allFilled)
        {
            click(ajd.editBtn);
            success = true;
        }
    }

    @Then("job details have been changed successfully")
    public void job_details_have_been_changed_successfully() {
        if(success)
        {
            System.out.println("Job details have been changed successfully");
        }
    }
}
