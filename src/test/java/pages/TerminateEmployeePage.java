package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;


public class TerminateEmployeePage extends CommonMethods {
    @FindBy(id="dialogConfirm")
    public WebElement confirmBtn;

    @FindBy(id="btnTerminateEmployement")
    public WebElement activateBtn;

    public TerminateEmployeePage(){
        //we will call the page factory class to initialize the elements
        //because when the object is created, the constructor will be called which will initialize the elements
        PageFactory.initElements(driver, this);
    }
}
