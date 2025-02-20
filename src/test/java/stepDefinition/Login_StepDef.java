package stepDefinition;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage_POF;
import utilities.ConfigReader;
import utilities.ExcelReader;

//Login Step
public class Login_StepDef {
	public LoginPage_POF loginpagefactory = new LoginPage_POF();
    ExcelReader exelread= new ExcelReader();
	
	@Given("The browser is open")
	public void the_browser_is_open() {

	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		loginpagefactory.getbaseurl();
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
	   
	}
	
	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
		
		loginpagefactory.InvalidURL();
	}


	@Then("Admin should receive application error")
	public void admin_should_receive_application_error() {
		String errormessage = loginpagefactory.InvalidURL();
		System.out.println("Actual Error message"+ errormessage);
		String expectedmessage="This Site cant be reached";
		Assert.assertEquals(errormessage, expectedmessage,"This is a invalid URL");
		
	}

	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) {
	    
	}

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
	   
	}

	@Then("Admin should see  LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() {
	    
	}

	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() {
	  
	}

	@Then("Admin should see {string}")
	public void admin_should_see(String string) {
	   
	}

	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
	    
	}

	@Then("Admin should {string} in the first text field")
	public void admin_should_in_the_first_text_field(String string) {
	    
	}

	@Then("Admin should see one dropdown")
	public void admin_should_see_one_dropdown() {
	   
	}

	@Then("Admin should see asterisk mark symbol next to text for mandatory fields")
	public void admin_should_see_asterisk_mark_symbol_next_to_text_for_mandatory_fields() {
	    
	}

	@Then("Admin should {string} in the second text field")
	public void admin_should_in_the_second_text_field(String string) {
	    
	}

	@Then("Admin should see asterisk mark symbol next to password text")
	public void admin_should_see_asterisk_mark_symbol_next_to_password_text() {
	    
	}

	@Then("Admin should see {string} placeholder in dropdown")
	public void admin_should_see_placeholder_in_dropdown(String string) {
	    
	}

	@Then("Admin should see {string} options in dropdown")
	public void admin_should_see_options_in_dropdown(String string) {
	   
	}

	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
	    
	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
	   
	}

	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() {
	   
	}

	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
	   
	}

///Login1 StepDefinitions
	
	@Given("Admin is on login Page")
	public void admin_is_on_login_page() {
	  
	}

	@When("Admin enter valid data in all field and clicks login button")
	public void admin_enter_valid_data_in_all_field_and_clicks_login_button() {
		loginpagefactory.getbaseurl();
		loginpagefactory.enter_user_name(ConfigReader.userName());
		loginpagefactory.enter_user_password(ConfigReader.passWord());
		
//		loginpagefactory.enter_user_name("sdetnumpyninja@gmail.com");	 
//		loginpagefactory.enter_user_password("Feb@2025");
		loginpagefactory.SelectingTheRole();
		loginpagefactory.clickLoginButton();
	}

	@Then("Admin should land on home page")
	public void admin_should_land_on_home_page() {
	
	}

	@When("Admin enter invalid data and clicks login button")
	public void admin_enter_invalid_data_and_clicks_login_button() {
	
	}

	@Then("Error message {string}")
	public void error_message(String string) {
	  
	}
	@When("Admin enter invalid {string} {string} credentials and clicks login button")
	public void admin_enter_invalid_credentials_and_clicks_login_button(String Sheet, String TestCase) throws IOException {
        
	loginpagefactory.getbaseurl();
	loginpagefactory.enter_user_name(exelread.getTestData(Sheet, TestCase, "username"));
	loginpagefactory.enter_user_password(exelread.getTestData(Sheet, TestCase, "password"));    	
	loginpagefactory.SelectingTheRole();
	loginpagefactory.clickLoginButton();
    }

   
    @Then("Error message please {string} {string} check Adminname\\/password")
    public void error_message_please_check_adminname_password(String Sheet, String TestCase) throws IOException {    	
    	//assertEquals(loginpagefactory.loginErrormessage(),    @When("Admin enter invalid {string} {string} credentials and clicks login button")exelread.getTestData(Sheet, TestCase, "ErrorMessage"));    	
    }
	
//	@When("Admin enter value only in password and clicks login button")
//	public void admin_enter_value_only_in_password_and_clicks_login_button() {
//		loginpagefactory.getbaseurl();
//		loginpagefactory.enterUsername(exelread.getTestData(Sheet, TestCase, "username"));
//		loginpagefactory.enterPassword(exelread.getTestData(Sheet, TestCase, "password"));    	
//    	loginpagefactory.SelectingTheRole();
//		loginpagefactory.clickLoginButton();
//	}
//
//	@Then("Error message\" Please enter your user name\"")
//	public void error_message_please_enter_your_user_name() {
//	  
//	}

	@When("Admin enter value only in user name and clicks login button")
	public void admin_enter_value_only_in_user_name_and_clicks_login_button() {
	
	}

	@Then("Error message\" Please enter your password \"")
	public void error_message_please_enter_your_password() {
	
	}

	@When("Admin enter valid credentials  and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
	
	}

	@When("Admin enter valid credentials  and clicks login button through mouse")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
	   
	}


}
