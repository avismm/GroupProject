package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class membershipSectionPage extends CommonMethods {


    @FindBy(xpath = "//*[@id='menu_pim_viewMyDetails']/b")
    public WebElement myInfoButton;

    @FindBy(xpath = "//ul[@id='sidenav']//a[text()='Memberships']")
    public WebElement membershipButton;

    @FindBy(xpath = "//input[@id='btnAddMembershipDetail']")
    public WebElement AddMembershipButton;


    @FindBy(xpath = "//h1[@id='membershipHeading']")
    public WebElement addMembershipText;

    @FindBy(xpath = "//select[@id='membership_membership']")
    public WebElement membershipDropDown;

    @FindBy(xpath = "//select[@id='membership_subscriptionPaidBy']")
    public WebElement subscriptionPaidByDropDown;

    @FindBy(xpath = "//select[@id='membership_currency']")
    public WebElement CurrencyDropDown;

    @FindBy(xpath = "//input[@id='membership_subscriptionAmount']")
    public WebElement subscriptionAmount;

    @FindBy(xpath = "//input[@id='membership_subscriptionCommenceDate']")
    public WebElement membershipSubCommenceDate;

    @FindBy(xpath = "//input[@id='membership_subscriptionRenewalDate']")
    public WebElement membershipSubRenewalDate;

    @FindBy(xpath = "//input[@id='btnSaveMembership']")
    public WebElement membershipSaveButton;

    @FindBy(xpath = "//div[@id='listMembershipDetails']/div")
    public WebElement assignedMembershipText;

    @FindBy(xpath = "//input[@id='delMemsBtn']")
    public WebElement deleteButton;

    @FindBy(xpath = "//input[@id='btnCancel']")
    public WebElement cancelButton;



public membershipSectionPage(){
    PageFactory.initElements(driver,this);
}
}
