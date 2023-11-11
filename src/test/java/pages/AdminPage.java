package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AdminPage extends CommonMethods {
    @FindBy(xpath = "//*[@id='menu_admin_viewAdminModule']/b")//simple way to write the locator
    public WebElement adminButton;//name  of the webelement

    @FindBy (id= "menu_admin_Qualifications")
    public WebElement qualificationButton;

    @FindBy (id="menu_admin_viewLanguages")
    public WebElement languageButton;

    @FindBy (id= "btnAdd")
    public WebElement addButton;

    public AdminPage(){//constructor
        //we will call the page factory class to initialize the elements
        //because when the object is created, the constructor will be called which will initialize the elements
        PageFactory.initElements(driver, this);
    }
}
