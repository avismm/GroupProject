package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LanguagePage extends CommonMethods {

    @FindBy(id = "btnAdd")
    public WebElement addButton;

    @FindBy (id = "language_name")
    public WebElement languageBox;

    @FindBy (id = "btnSave")
    public WebElement saveButton;




    public LanguagePage(){
        //we will call the page factory class to initialize the elements
        //because when the object is created, the constructor will be called which will initialize the elements
        PageFactory.initElements(driver, this);
    }

}
