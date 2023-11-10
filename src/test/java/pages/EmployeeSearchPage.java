package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeSearchPage extends CommonMethods {
    @FindBy(id="empsearch_employee_name_empName")
    public WebElement empSearchNameField;
    @FindBy(id="empsearch_id")
    public WebElement empSearchIdField;

    @FindBy(id="searchBtn")
    public WebElement searchBtn;

    public EmployeeSearchPage(){
        //we will call the page factory class to initialize the elements
        //because when the object is created, the constructor will be called which will initialize the elements
        PageFactory.initElements(driver, this);
    }
}
