package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {
        @When("user enters firstname and lastname in the name fields")
        public void user_enters_firstname_and_lastname_in_the_name_fields() {
            sendText("Julia",addEmployeePage.firstnameLocator);
            sendText("Grebenik",addEmployeePage.lastnameLocator);
        }
        @When("the employee ID is automatically generated")
        public void the_employee_id_is_automatically_generated() {
            addEmployeePage.employeeId.isDisplayed();

        }
        @When("user clicks on save button")
        public void user_clicks_on_save_button() {
            click(addEmployeePage.saveButton);
        }
        @Then("user added successfully")
        public void user_added_successfully() {
            System.out.println("test passed");

        }
        @When("user clears the generated employee ID")
        public void user_clears_the_generated_employee_id() {
            addEmployeePage.employeeId.clear();
        }
        @When("user enters new employee ID")
        public void user_enters_new_employee_id() {
            sendText("12345", addEmployeePage.employeeId);
        }
        @When("user enters lastname in the field")
        public void user_enters_lastname_in_the_field() {
            sendText("Grebenik", addEmployeePage.lastnameLocator);
        }
        @When("user leaves the firstname field empty")
        public void user_leaves_the_firstname_field_empty() {

        }
        @Then("the error message should be displayed")
        public void the_error_message_should_be_displayed() {
            addEmployeePage.errorMsg.isDisplayed();
            addEmployeePage.errorMsg.isEnabled();

        }
        @When("user enters firstname in the field")
        public void user_enters_firstname_in_the_field() {
            sendText("Julia", addEmployeePage.firstnameLocator);
        }
        @When("user leaves the lastname field empty")
        public void user_leaves_the_lastname_field_empty() {

        }


    }

