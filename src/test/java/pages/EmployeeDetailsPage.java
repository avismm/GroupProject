package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;


public class EmployeeDetailsPage extends CommonMethods {
    @FindBy(xpath = "//ul[@id='sidenav']//child::li[6]")
    public WebElement employeeJobBtn;

    public EmployeeDetailsPage(){
        //we will call the page factory class to initialize the elements
        //because when the object is created, the constructor will be called which will initialize the elements
        PageFactory.initElements(driver, this);
    }
}
