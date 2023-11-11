package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;

public class membershipSectionSteps extends CommonMethods {


    @When("employee enters username and password")
    public void employee_enters_username_and_password()  {
        sendText(loginPage.usernameTextField, ConfigReader.getPropertyValue("youssefUsername"));
        sendText(loginPage.passwordField, ConfigReader.getPropertyValue("youssefPassword"));
    }
    @When("the employee accesses their profile")
    public void the_employee_accesses_their_profile() {
     click(membershipSectionPage.myInfoButton);

    }
    @When("navigates to the membership section")
    public void navigates_to_the_membership_section() {
        click(membershipSectionPage.membershipButton);
        click(membershipSectionPage.AddMembershipButton);

    }
    @Then("the employee should be able to view the membership details")
    public void the_employee_should_be_able_to_view_the_membership_details() {
        String addmemberText=membershipSectionPage.addMembershipText.getText();
        Assert.assertEquals("Add Membership",addmemberText);
        takeScreenshot("all membership details are desplayed on the  ");

    }

    @When("the employee selects the membership type from the dropdown field and validate that is filled in")
    public void the_employee_selects_the_membership_type_from_the_dropdown_field_and_validate_that_is_filled_in() {
        //WebElement membershipDrop=driver.findElement(By.xpath("//select[@id='membership_membership']"));
        Select sel=new Select(membershipSectionPage.membershipDropDown);
        sel.selectByValue("2257");
        WebElement appleOption=driver.findElement(By.xpath("//select[@id='membership_membership']/option[3]"));
        String membershipSelect=appleOption.getText();
        Assert.assertEquals("AmazonPrime",membershipSelect);

    }
    @When("selects the entity that paid for the subscription paid by from the dropdown field and validate that is filled in")
    public void selects_the_entity_that_paid_for_the_subscription_paid_by_from_the_dropdown_field_and_validate_that_is_filled_in() {
        //WebElement subscriptionPaidBy=driver.findElement(By.xpath("//select[@id='membership_subscriptionPaidBy']"));
        Select sel=new Select(membershipSectionPage.subscriptionPaidByDropDown);
        sel.selectByValue("Company");
        WebElement subscriptionOption=driver.findElement(By.xpath("//select[@id='membership_subscriptionPaidBy']/option[2]"));
        String SubscriptionOptionValue=subscriptionOption.getText();
        Assert.assertEquals("Company",SubscriptionOptionValue);


    }
    @When("enters the subscription amount in the text box and validate that is filled in")
    public void enters_the_subscription_amount_in_the_text_box_and_validate_that_is_filled_in() {
        sendText(membershipSectionPage.subscriptionAmount, "400");
        Assert.assertTrue("400",!membershipSectionPage.subscriptionAmount.getAttribute("class").isEmpty());
    }
    @When("selects the currency used for the subscription from the dropdown field")
    public void selects_the_currency_used_for_the_subscription_from_the_dropdown_field() {
       // WebElement membershipCurrency= driver.findElement(By.xpath("//select[@id='membership_currency']"));
        Select sel=new Select(membershipSectionPage.CurrencyDropDown);
        sel.selectByValue("MAD");

    }
    @When("selects the subscription commence date from the calendar and validate that is filled in")
    public void selects_the_subscription_commence_date_from_the_calendar_and_validate_that_is_filled_in() {
        click(membershipSectionPage.membershipSubCommenceDate);
        WebElement monthDropDownCommenceDtae= driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select sel=new Select(monthDropDownCommenceDtae);
        sel.selectByValue("6");
        WebElement yearDropDown=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select select=new Select(yearDropDown);
        select.selectByVisibleText("1990");
        List<WebElement>calenderTableCommenceDate=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement calenderDay:calenderTableCommenceDate){
           String getTextOfDay=calenderDay.getText();
           if(getTextOfDay.equals("14")){
               calenderDay.click();
               break;
           }
        }
        Assert.assertTrue("1990-07-14",!membershipSectionPage.membershipSubCommenceDate.getAttribute("type").isEmpty());

    }
    @When("selects the subscription renewal date from the calendar")
    public void selects_the_subscription_renewal_date_from_the_calendar() {
        click(membershipSectionPage.membershipSubRenewalDate);
        WebElement monthDropDownRenewalDate=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select sel=new Select(monthDropDownRenewalDate);
        sel.selectByVisibleText("May");
        WebElement yearDropDownRenewalDate=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select select=new Select(yearDropDownRenewalDate);
        select.selectByVisibleText("2011");
        List<WebElement>calenderTableRenewalDate=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement calenderDay:calenderTableRenewalDate){
           String getTextOfDay=calenderDay.getText();
           if(getTextOfDay.equals("22")){
               calenderDay.click();
               break;
           }
        }

        takeScreenshot("verification of all mandatory fields are filled in");

    }

    @When("clicks on the save button")
    public void clicks_on_the_save_button() {
        click(membershipSectionPage.membershipSaveButton);

    }
    @Then("the system should store the membership details in the employee's profile")
    public void the_system_should_store_the_membership_details_in_the_employee_s_profile() {
        String assignedMemShipGetText=membershipSectionPage.assignedMembershipText.getText();
        Assert.assertEquals("Assigned Memberships",assignedMemShipGetText);
        takeScreenshot("All membership details are saved in the employee's profile.");


    }


    @When("the employee selects the previously saved membership details")
    public void the_employee_selects_the_previously_saved_membership_details() throws InterruptedException {
        List<WebElement>assignedMembershipTable=driver.findElements(By.xpath("//table[@class='table hover']/tbody/tr/td/a"));
        for(WebElement assignedTable:assignedMembershipTable){
           String assignedMembershipText= assignedTable.getText();
           if(assignedMembershipText.equals("AmazonPrime")){
               assignedTable.click();
               break;
           }
        }

    }
    @When("makes the necessary edits")
    public void makes_the_necessary_edits() {
        Select sel1=new Select(membershipSectionPage.membershipDropDown);
        sel1.selectByValue("2257");
        WebElement appleOption=driver.findElement(By.xpath("//select[@id='membership_membership']/option[3]"));
        String membershipSelect=appleOption.getText();
        Assert.assertEquals("AmazonPrime",membershipSelect);

        Select sel=new Select(membershipSectionPage.subscriptionPaidByDropDown);
        sel.selectByValue("Individual");
        WebElement subscriptionOption=driver.findElement(By.xpath("//select[@id='membership_subscriptionPaidBy']/option[3]"));
        String SubscriptionOptionValue=subscriptionOption.getText();
        Assert.assertEquals("Individual",SubscriptionOptionValue);

        sendText(membershipSectionPage.subscriptionAmount, "1000");

        Select sel2=new Select(membershipSectionPage.CurrencyDropDown);
        sel2.selectByValue("MAD");
        click(membershipSectionPage.membershipSubCommenceDate);

        WebElement monthDropDownCommenceDtae= driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select sel3=new Select(monthDropDownCommenceDtae);
        sel3.selectByValue("2");
        WebElement yearDropDown=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select select=new Select(yearDropDown);
        select.selectByVisibleText("2000");
        List<WebElement>calenderTableCommenceDate=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement calenderDay:calenderTableCommenceDate){
            String getTextOfDay=calenderDay.getText();
            if(getTextOfDay.equals("18")){
                calenderDay.click();
                break;
            }
        }

        click(membershipSectionPage.membershipSubRenewalDate);
        WebElement monthDropDownRenewalDate=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select sel4=new Select(monthDropDownRenewalDate);
        sel4.selectByVisibleText("Aug");
        WebElement yearDropDownRenewalDate=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select sel5=new Select(yearDropDownRenewalDate);
        sel5.selectByVisibleText("2018");
        List<WebElement>calenderTableRenewalDate=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement calenderDay:calenderTableRenewalDate){
            String getTextOfDay=calenderDay.getText();
            if(getTextOfDay.equals("15")){
                calenderDay.click();
                break;
            }
        }

    }

    @When("clicks on the save button after editing")
    public void clicks_on_the_save_button_2() {
        click(membershipSectionPage.membershipSaveButton);
    }

    @Then("the system should update the membership details in the employee's profile")
    public void the_system_should_update_the_membership_details_in_the_employee_s_profile() {
        WebElement updatedSubscAmount=driver.findElement(By.xpath("//table[@class='table hover']/tbody/tr/td[4]"));
        String updatedInformationText= updatedSubscAmount.getText();
        Assert.assertEquals("1000.00",updatedInformationText);
        WebElement updatedSubsCommenceDate =driver.findElement(By.xpath("//table[@class='table hover']/tbody/tr/td[6]"));
        String updatedSubCommDateText=updatedSubsCommenceDate.getText();
        Assert.assertEquals("2000-03-18",updatedSubCommDateText);


    }

    @Then("the membership details should be displayed in a clear and organized format")
    public void the_membership_details_should_be_displayed_in_a_clear_and_organized_format() {
        click(membershipSectionPage.cancelButton);// i added this click to take me back one more step to the page where i can select the membership
        WebElement membershipDetailsInFormat=driver.findElement(By.xpath("//*[@id='frmEmpDelMemberships']/table/tbody/tr/td[2]/a"));
        String amazonTextOnTable=membershipDetailsInFormat.getText();
        Assert.assertEquals("AmazonPrime",amazonTextOnTable);
        takeScreenshot("membership details displayed in a clear and organized format");
    }

    @When("the employee selects the previously saved membership details in membership profile")
    public void the_employee_selects_the_previously_saved_membership_details_in_membership_profile() {
        click(membershipSectionPage.cancelButton);// i added this click to take me back one more step to the page where i can select the membership
        WebElement selectPreviousMembership=driver.findElement(By.xpath("//table[@class='table hover']/tbody/tr/td[1]"));
        selectPreviousMembership.click();

    }
    @When("clicks on the delete button")
    public void clicks_on_the_delete_button1() {
        click(membershipSectionPage.deleteButton);

    }
    @Then("the system should remove the membership details from the employee's profile")
    public void the_system_should_remove_the_membership_details_from_the_employee_s_profile() {
        WebElement noRecordsFound=driver.findElement(By.xpath("//table[@class='table hover']/tbody/tr/td[1]"));
        String noRecordsFoundText=noRecordsFound.getText();
        Assert.assertEquals("No Records Found",noRecordsFoundText);


    }



}
