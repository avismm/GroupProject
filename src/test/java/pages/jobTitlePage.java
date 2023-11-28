package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class jobTitlePage extends CommonMethods {
    @FindBy(xpath = "//b[text()='Dashboard']")
    public WebElement DashboardButtonLocator;
    @FindBy(xpath = "//a[text()='Welcome Admin']")
    public WebElement welcomeAdminLocator;
    @FindBy(id="menu_admin_viewAdminModule")
    public WebElement adminButton;

    @FindBy(id="menu_admin_Qualifications")
    public WebElement qualificationsButtonLocator;

    @FindBy(id="menu_admin_viewLanguages")
    public WebElement languagesButtonLocator;

    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimButtonLocator;
    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmployeeButtonLocator;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logoutAdminLocator;

    @FindBy(xpath = "//a[@id='menu_admin_Job']")
    public WebElement adminJobBtn;

    @FindBy(xpath = "//a[@id='menu_admin_viewJobTitleList']")
    public WebElement adminJobTitleBtn;

    @FindBy(xpath = "//input[@id='btnAdd']")
    public WebElement addJobBtn;

    @FindBy(xpath = "//input[@id='jobTitle_jobTitle']")
    public WebElement addJobTitleField;


    @FindBy(xpath = "//textarea[@id='jobTitle_jobDescription']")
    public WebElement addJobDesc;

    @FindBy(xpath = "//textarea[@id='jobTitle_note']")
    public WebElement addJobNote;


    @FindBy(xpath = "//input[@id='btnSave']")
    public WebElement addJobSvBtn;


    public jobTitlePage(){
        PageFactory.initElements(driver, this);
    }
}
