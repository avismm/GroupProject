package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.CommonMethods.driver;

public class adminJobDetailsPage {
//    @FindBy(linkText = "Dan Ivan")
//    public WebElement empButton;
//    @FindBy(linkText = "Job")
//    public WebElement jobBtn;
    @FindBy(id = "btnSave")
    public WebElement editBtn;
    @FindBy(id="job_job_title")
    public WebElement jobTitleDropDown;
    @FindBy(id = "job_emp_status")
    public WebElement empStatusDropDown;
    @FindBy(id="job_eeo_category")
    public WebElement jobCategoryDropDown;
    @FindBy(id="job_joined_date")
    public WebElement joinDateCalendar;
//    @FindBy(id="language_comments")
//    public WebElement joinDateValue;
    @FindBy(id="job_sub_unit")
    public WebElement subUnitDropDown;
    @FindBy(id = "job_location")
    public WebElement jobLocationDropDown;
    @FindBy(id = "job_contract_start_date")
    public WebElement jobStartCalendar;
//    @FindBy(xpath = "//*[@id='lang_data_table']/tbody/tr/td[1]/input[5]")
//    public WebElement jobStartValue;
    @FindBy(id="job_contract_end_date")
    public WebElement jobEndCalendar;
//    @FindBy(xpath = "//*[@id='lang_data_table']/tbody/tr/td[2]")
//    public WebElement jobEndValue;
    @FindBy(id="job_contract_file")
    public WebElement contractDetails;

    public adminJobDetailsPage() {

        PageFactory.initElements(driver,this);
    }
}
