package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;

public class InvalidLoginSteps extends CommonMethods {


    @When("user enters only valid password")
    public void user_enters_only_valid_password() {
        sendText(invalidLoginPage.passwordTextField, "Hum@nhrm123");
    }
    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        click(invalidLoginPage.loginBtn);
    }
    @Then("error message Username cannot be empty should be displayed")
    public void error_message_username_cannot_be_empty_should_be_displayed() {
        String expectedMsg = "Username cannot be empty";
        String actualMsg = invalidLoginPage.errorMsg3.getText();
        Assert.assertEquals(expectedMsg,actualMsg);

    }
    @When("user enters only valid user name")
    public void user_enters_only_valid_user_name() {
        sendText(invalidLoginPage.usernameTextField, "Admin");
    }
    @Then("error message Password cannot be empty should be displayed")
    public void error_message_password_cannot_be_empty_should_be_displayed() {
        String expectedMsg = "Password cannot be empty";
        String actualMsg = invalidLoginPage.errorMsg3.getText();
        Assert.assertEquals(expectedMsg,actualMsg);
    }
    @When("user enters incorrect user name")
    public void user_enters_incorrect_user_name() {
        sendText(invalidLoginPage.usernameTextField, "Adimn");
    }
    @When("user enters valid password")
    public void user_enters_valid_password() {
        sendText(invalidLoginPage.passwordTextField, "Hum@nhrm123");
    }
    @Then("error message Invalid credentials..etc should be displayed")
    public void error_message_invalid_credentials_etc_should_be_displayed() {
        String expectedMsg = "Invalid credentials. Please check your username and password and try again";
        String actualMsg = invalidLoginPage.errorMsg3.getText();
        Assert.assertEquals(expectedMsg,actualMsg);
    }
    @When("user enters valid user name")
    public void user_enters_valid_user_name() {
        sendText(invalidLoginPage.usernameTextField, "Admin");
    }
    @When("user enters incorrect password")
    public void user_enters_incorrect_password() {
        sendText(invalidLoginPage.passwordTextField, "Hu@nhrm123");
    }

    @Then("System should allow the user to correct their input and attempt to log in again.")
    public void system_should_allow_the_user_to_correct_their_input_and_attempt_to_log_in_again() {
        Assert.assertTrue(invalidLoginPage.usernameTextField.isEnabled());
        Assert.assertTrue(invalidLoginPage.passwordTextField.isEnabled());


 }

}

