package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EditEmployeeInfoPage extends CommonMethods {

  /* @FindBy(id="txtUsername")
    public WebElement usernameTextField;
    @FindBy(id="txtPassword")
    public WebElement passwordFields;

    @FindBy(id="btnLogin")
    public WebElement LoginBtn;

    @FindBy(linkText = "My Info")
    public static WebElement MyInfoBtn;*/

        @FindBy(xpath = "//*[@id='btnSave']")
        public static WebElement EditBtn;

        @FindBy(xpath = "//*[@id='personal_txtEmpFirstName']")
        public static WebElement enterFirstName;

        @FindBy(xpath= "//input[@id='personal_txtEmpMiddleName']")
        public static WebElement enterMiddleName;
        @FindBy(xpath = "//input[@id='personal_txtEmpLastName']")
        public static WebElement enterLastName;
        @FindBy(xpath = "//*[@id='personal_optGender_2']")
        public static WebElement selectGender;
        @FindBy(xpath = "//*[@id='personal_cmbNation']")
        public static WebElement selectNationality;
        @FindBy(xpath = "//*[@id='personal_cmbMarital']")
        public static WebElement selectMaritalStatus;
        @FindBy(xpath = "//*[@id='btnSave']")
        public static WebElement saveBtn;

        @FindBy(linkText = "My Info")
        public WebElement myInfoBtn;

        public EditEmployeeInfoPage() {
            PageFactory.initElements(driver, this);
        }

    }
