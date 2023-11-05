package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps extends CommonMethods {

  //  public WebDriver driver;
    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() throws InterruptedException {
       // Write code here that turns the phrase above into concrete actions
        /*driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard");
        //Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));*/
        openBrowserAndLaunchApplication();
    }
    @When("user enters username and password")
    public void user_enters_username_and_password() throws InterruptedException {
//object of the login class to access all the elements
        //LoginPage lp =new LoginPage();
        //WebElement usernameTextField=driver.findElement((By.xpath("//*[@id='txtUsername']")));
      //  usernameTextField.sendKeys("admin");
        //  Thread.sleep(2000);
        sendText(loginPage.usernameTextField, ConfigReader.getPropertyValue("username"));
      //  WebElement passwordField=driver.findElement((By.cssSelector("input#txtPassword")));
      //  passwordField.sendKeys("Hum@nhrm123");
        sendText(loginPage.passwordField, ConfigReader.getPropertyValue("password"));
        //Thread.sleep(2000);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
        //LoginPage lp =new LoginPage();
       // WebElement loginBtn=driver.findElement((By.xpath("//*[@id='btnLogin']")));
       click(loginPage.loginBtn);
       // Thread.sleep(2000);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        //System.out.println(1/0);
        System.out.println("This test passed");
        //assertion to check if element exists
        //the moment assertions finds an error, it forces stop of the execution and captures the screenshot
        //assertTrue is boolean condition to check if it returns true or false
        Assert.assertTrue(dashboardPage.welcomeAdminLocator.isDisplayed());
        //Assert.assertEquals();
    }
}
