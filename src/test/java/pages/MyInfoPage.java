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
    @FindBy(id="btnLanguageSave")
    public WebElement languageSaveBtn;
    @FindBy(className = "edit")
    public WebElement languageEditAfterSavingLocator;
    @FindBy(className = "validation-error")
    public WebElement mandatoryFieldsErrorMsg;

    @FindBy(xpath = "//*[@id='lang_data_table']/tbody/tr/td[1]/input[5]")
    public WebElement languageCheckBox;
    @FindBy(id="delLanguage")
    public WebElement deleteLanguageBtn;
    @FindBy(xpath = "//*[@id='lang_data_table']/tbody/tr/td[2]")
    public WebElement languageCellContentAfterSavingLocator;

    public MyInfoPage() {

        PageFactory.initElements(driver,this);
    }
}
