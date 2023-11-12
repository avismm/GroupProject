package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class AdminAddMembershipSteps extends CommonMethods {
    @When("Admin clicks on Admin option")
    public void admin_clicks_on_admin_option() {
        click(dashboardPage.adminButton);
    }
    @When("Admin clicks on Qualifications option")
    public void admin_clicks_on_qualifications_option() throws InterruptedException {

        click(adminMembershipPage.qualificationsButton);
        getWait();
    }
    @Then("Admin clicks on Memberships option")
    public void admin_clicks_on_memberships_option() throws InterruptedException {

        click(adminMembershipPage.membershipButton);
        getWait();

    }
    @Then("Admin clicks on Add option")
    public void admin_clicks_on_add_option() {
        click(adminMembershipPage.addButton);
    }
    @Then("Admin enter Membership Name")
    public void admin_enter_membership_name() {
        sendText(adminMembershipPage.nameBox, "member3");
    }
    @Then("Admin clicks on save button")
    public void admin_clicks_on_save_button() {
        click(adminMembershipPage.saveButton);
    }

}
