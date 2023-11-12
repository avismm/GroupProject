package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AdminMembershipPage extends CommonMethods {
    @FindBy(id="menu_admin_membership")
    public WebElement membershipButton;
    @FindBy(id="btnAdd")
    public WebElement addButton;
    @FindBy(id="membership_name")
    public WebElement nameBox;
    @FindBy(id="btnSave")
    public WebElement saveButton;
    @FindBy(linkText = "Qualifications")
    public WebElement qualificationsButton;
    public AdminMembershipPage() {

        PageFactory.initElements(driver,this);
    }
}
