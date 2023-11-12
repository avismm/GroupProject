package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class InvalidLoginPage extends CommonMethods {
    @FindBy(id = "txtUsername")
    public WebElement usernameTextField;
    @FindBy(id = "txtPassword")
    public WebElement passwordTextField;
    @FindBy(id = "btnLogin")
    public WebElement loginBtn;
    @FindBy(id="spanMessage")
    public WebElement errorMsg3;

    public InvalidLoginPage() {
        //we will call the page factory class to initialize the elements
        //because when the object is created, the constructor will be called which will initialize the elements
        PageFactory.initElements(driver, this);
    }
}
