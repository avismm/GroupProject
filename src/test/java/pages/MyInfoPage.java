package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.CommonMethods.driver;
//Ahmed's class
public class MyInfoPage {
    @FindBy(linkText = "My Info")
    public WebElement myInfoBtn;

    @FindBy(linkText = "Qualifications")
    public WebElement qualificationsBtn;
    @FindBy(id = "addLanguage")
    public WebElement addLanguageBtn;
    @FindBy(id="language_code")
    public WebElement languageDropDown;
    @FindBy(xpath = "//*[text()='English']")
    public WebElement englishLanguageLoc;
    @FindBy(id="language_lang_type")
    public WebElement languageFluencyDropDown;
    @FindBy(id="language_competency")
    public WebElement languageCompetencyDropDown;
    @FindBy(id="language_comments")
    public WebElement commentsTextBox;



    public MyInfoPage() {

        PageFactory.initElements(driver,this);
    }
}
