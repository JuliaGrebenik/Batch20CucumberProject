package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class LoginValidationSteps extends CommonMethods {
    @Given("user navigates to HRMS application")
    public void user_navigates_to_hrms_application() {
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @When("user attempts to log in with an empty username")
    public void user_attempts_to_log_in_with_an_empty_username() {
        //WebElement userNameField= driver.findElement(By.xpath("//input[@id='txtUsername']"));
    //userNameField.sendKeys("");
        //sendText(ConfigReader.read("username"), loginPage.usernameField);
    }
    @When("user enters valid password")
    public void user_enters_valid_password() {
        //WebElement passwordField= driver.findElement(By.xpath("//input[@id='txtPassword']"));
    //passwordField.sendKeys("Hum@nhrm123");
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
      // WebElement loginButton= driver.findElement(By.xpath("//input[@id='btnLogin']"));
    //loginButton.click();
        click(LoginPage.loginPage.loginButton);
    }
    @Then("user can see the error message")
    public void user_can_see_the_error_message() {
       // System.out.println("Username cannot be empty");
    String actualMessage=loginPage.errorMessage.getText();
    Assert.assertEquals("Username cannot be empty",actualMessage);
    }
    @When("user enters a valid username")
    public void user_enters_a_valid_username() {
        //WebElement userNameField= driver.findElement(By.xpath("//input[@id='txtUsername']"));
        //userNameField.sendKeys("Admin");
        sendText(ConfigReader.read("userName"),loginPage.usernameField);
    }
    @When("user attempts to log in with an empty password")
    public void user_attempts_to_log_in_with_an_empty_password() {
        //WebElement passwordField= driver.findElement(By.xpath("//input[@id='txtPassword']"));
        //passwordField.sendKeys("");
        //sendText(ConfigReader.read("password"), loginPage.passwordField);

    }
    @Then("user can see the error message stating")
    public void user_can_see_the_error_message_stating() {
        //System.out.println("Password is empty");
        String actualMessage=loginPage.errorMessage.getText();
        Assert.assertEquals("Password is Empty",actualMessage);
    }
    @When("the user enters an invalid username and password")
    public void the_user_enters_an_invalid_username_and_password() {
        sendText("admin", loginPage.usernameField);
        sendText("Hum@h", loginPage.passwordField);
    }

    @Then("the error message about invalid credentials should be displayed")
    public void the_error_message_about_invalid_credentials_should_be_displayed() {
        String actualMessage=loginPage.errorMessage.getText();
        Assert.assertEquals("Invalid credentials",actualMessage);
        loginPage.errorMessage.isDisplayed();
    }
    @When("the user enters valid username and password")
    public void the_user_enters_valid_username_and_password() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }
    @Then("user is navigated to dashboard page")
    public void user_is_navigated_to_dashboard_page() {
        Assert.assertTrue(dashboardPage.welcomeText.isDisplayed());

    }



}




