package steps;

import io.cucumber.java.en.Then;
import utils.CommonMethods;

public class AddLanguageStep extends CommonMethods {
    @Then("user clicks on Admin tab")
    public void user_clicks_on_admin_tab() {
        click(adminPage.adminButton);
    }

    @Then("user navigates to Qualifications")
    public void user_navigates_to_qualifications() {
        click(adminPage.qualificationButton);
    }

    @Then("clicks on Language tab")
    public void clicks_on_language_tab() {
      click(adminPage.languageButton);
    }

    @Then("clicks on Add button")
    public void clicks_on_add_button() {
       click(adminPage.addButton);

    }

    @Then("enters a language")
    public void enters_a_language() {
       sendText(languagePage.languageBox,"Italian");
        byte[] pic;

    }

    @Then("clicks on save button")
    public void clicks_on_save_button() {
        click(languagePage.saveButton);

    }
}
