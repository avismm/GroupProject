package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        click(dashboardPage.addEmployeeButton);
    }

    @When("user enters firstName middleName and lastName")
    public void user_enters_first_name_middle_name_and_last_name() {
        sendText(addEmployeePage.firstNameLoc, "nind");
        sendText(addEmployeePage.middleNameLoc, "esha");
        sendText(addEmployeePage.lastNameLoc, "lata");
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveBtn);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added");
    }

    @Then("user closes the browser")
    public void user_closes_the_browser() {
        closeBrowser();
    }

    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String firstN, String middleN, String lastN) {

        sendText(addEmployeePage.firstNameLoc, firstN);
        sendText(addEmployeePage.middleNameLoc, middleN);
        sendText(addEmployeePage.lastNameLoc, lastN);
    }

    @When("user enters {string} and {string} and enters {string}")
    public void user_enters_and_and_enters(String firstN, String middleN, String lastN) {

        sendText(addEmployeePage.firstNameLoc, firstN);
        sendText(addEmployeePage.middleNameLoc, middleN);
        sendText(addEmployeePage.lastNameLoc, lastN);

    }

    @When("user adds multiple employees from excel using {string} and verify them")
    public void user_adds_multiple_employees_from_excel_using_and_verify_them
            (String sheetName) throws InterruptedException {
        List<Map<String, String>> newEmployees =
                ExcelReader.read(sheetName, Constants.TESTDATA_FILEPATH);
        //from the list of maps, we need one map at one point of time
        // this iterator will give me one map to add one employee at a time
        Iterator<Map<String, String>> itr = newEmployees.iterator();
        //it checks whether we have values in map or not
        while (itr.hasNext()){
            //it will return the keys and the values of the map which we store in this
            // variable
            Map<String, String> employeeMap = itr.next();
            sendText(addEmployeePage.firstNameLoc, employeeMap.get("firstName"));
            sendText(addEmployeePage.middleNameLoc, employeeMap.get("middleName"));
            sendText(addEmployeePage.lastNameLoc, employeeMap.get("lastName"));
            sendText(addEmployeePage.photograph, employeeMap.get("Photograph"));
            if(!addEmployeePage.checkBox.isSelected()){
                click(addEmployeePage.checkBox);
            }
            sendText(addEmployeePage.usernameEmp, employeeMap.get("Username"));
            sendText(addEmployeePage.passwordEmp, employeeMap.get("Password"));
            sendText(addEmployeePage.confirmPassword, employeeMap.get("confirmPassword"));

            //we are storing the emp id from the locator before we save the new employee
            String empIdValue =
                    addEmployeePage.employeeIdLocator.getAttribute("value");
            click(addEmployeePage.saveBtn);
            Thread.sleep(2000);

            //verification of employee still pending
            click(dashboardPage.empListButton);
            //we need to search the employee by the stored employee id
            sendText(employeeSearchPage.empSearchIdField, empIdValue);
            click(employeeSearchPage.searchBtn);

            //after searching the employee, it returns the info in format
            //empid firstname middleName lastname in that format
            List<WebElement> rowData =
                    driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));

            for (int i=0; i<rowData.size(); i++){
                //it will give me the data from all the cell of the row
                String rowText = rowData.get(i).getText();
                System.out.println(rowText);
                //it is we are getting from Excel to compare with web table data
                String expectedDataFromExcel = empIdValue + " " + employeeMap.get("firstName")
                        + " " + employeeMap.get("middleName") + " "
                        + employeeMap.get("lastName");
                System.out.println(expectedDataFromExcel);
                Assert.assertEquals(expectedDataFromExcel, rowText);

            }

            //because we want to add many employees
            click(dashboardPage.addEmployeeButton);
            Thread.sleep(2000);
            //verification of employee still pending
        }

    }
    @When("user adds multiple employees from data table")
    public void user_adds_multiple_employees_from_data_table(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> employeeNames = dataTable.asMaps();

        for (Map<String, String> map:employeeNames) {
            sendText(addEmployeePage.firstNameLoc, map.get("firstName"));
            sendText(addEmployeePage.middleNameLoc, map.get("middleName"));
            sendText(addEmployeePage.lastNameLoc, map.get("lastName"));
            addEmployeePage.employeeIdLocator.clear();
            sendText(addEmployeePage.employeeIdLocator, map.get("employeeId"));

            //Storing of the emp id from the locator before we save the new employee
            String empIdValue =
                    addEmployeePage.employeeIdLocator.getAttribute("value");
            click(addEmployeePage.saveBtn);

            //verification if employee exists after they were created
            click(dashboardPage.empListButton);
            //we need to search the employee by the stored employee ID as this should be unique
            sendText(employeeSearchPage.empSearchIdField, empIdValue);
            click(employeeSearchPage.searchBtn);
            //if the id exists, it should always be in the first cell of the table
            WebElement firstCellValue=driver.findElement(By.xpath("//table//td[a[text()='"+empIdValue+"']]"));
            Thread.sleep(3000);
            //comparing the text extracted from the element (if it exists) with the employee ID
            String elementTxt =firstCellValue.getText();
            Assert.assertEquals(empIdValue, elementTxt);

            Thread.sleep(2000);
            //continue to add the next employee
            click(dashboardPage.addEmployeeButton);
            Thread.sleep(2000);

        }

    }

}
