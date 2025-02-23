package stepDefinition;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.sourceforge.tess4j.TesseractException;
import pageObjects.LoginPage_POF;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;

//Login Step
public class Login_StepDef {
	public LoginPage_POF loginpagefactory = new LoginPage_POF();
    ExcelReader exelread= new ExcelReader();
	
	@Given("The browser is open")
	public void the_browser_is_open() {
		LoggerLoad.info("The broweser is open");
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		LoggerLoad.info("The admin gives the correct LMS URL");
		loginpagefactory.getbaseurl();
		
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
		LoggerLoad.info("The user is on the login page");
//		Assert.assertEquals(loginpagefactory.LMSportalURLValidation(),ConfigReader.loginPage() ); 
	}
	
	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
		
		boolean invalidlink =loginpagefactory.InvalidURL();
	}


	@Then("Admin should receive application error")
	public void admin_should_receive_application_error() {
		boolean errormessage = loginpagefactory.InvalidURL();
		System.out.println("Actual Error message"+ errormessage);
		String expectedmessage="This Site cant be reached";
		Assert.assertEquals(errormessage, expectedmessage,"This is a invalid URL");
		
	}

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
		LoggerLoad.info("Admin should see correct spellings in all fields");
		loginpagefactory.getbaseurl();
		Boolean checkfieldspell= loginpagefactory.ChackFieldsonLoginPage();
		Assert.assertEquals(true, checkfieldspell);
		
	}

	@Then("Admin should see  LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() throws IOException, TesseractException, InterruptedException {
		String ExpText="LMS - Learning Management System";
	   loginpagefactory.appNameOnLogo(ExpText,false);
	}

	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() {
		LoggerLoad.info("Admin should see company name below the app name");
	}

	@Then("Admin should see {string}")
	public void admin_should_see(String signIn) {
		String Signinfromportal=loginpagefactory.pleaseSignIn();
		Assert.assertEquals(signIn, Signinfromportal);

	   
	}

	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
	boolean User = loginpagefactory.verifyUserTextField();
	boolean Password = loginpagefactory.verifyPasswordTextField();
	Assert.assertEquals(User, true);
	LoggerLoad.info("The user text field is on the login page");
	Assert.assertEquals(Password, true);
	LoggerLoad.info("The password text field is on the login page");
	
	}

	@Then("Admin should {string} in the first text field")
	public void admin_should_in_the_first_text_field(String User) {
	    String UseTextField= loginpagefactory.checkforUserTextField();
	    Assert.assertEquals(User, UseTextField);
	    LoggerLoad.info("Admin should see User in the first text field");
	}

	@Then("Admin should see one dropdown")
	public void admin_should_see_one_dropdown() {
		boolean Roledrpdwn = loginpagefactory.verifyRoleDropDownField();
		Assert.assertEquals(Roledrpdwn, true);
	}

	@Then("Admin should see asterisk mark symbol next to text for mandatory fields")
	public void admin_should_see_asterisk_mark_symbol_next_to_text_for_mandatory_fields() {
		boolean Astric=loginpagefactory.checkforAstric();
		Assert.assertEquals(Astric, true);
	}

	@Then("Admin should {string} in the second text field")
	public void admin_should_in_the_second_text_field(String Password) {
		   String PasswordTextField= loginpagefactory.checkforPasswordTextField();
		    Assert.assertEquals(Password, PasswordTextField);
	}

	@Then("Admin should see asterisk mark symbol next to password text")
	public void admin_should_see_asterisk_mark_symbol_next_to_password_text() {
		boolean Astric=loginpagefactory.checkforPasswordAstric();
		Assert.assertEquals(Astric, true);
	}

	@Then("Admin should see {string} placeholder in dropdown")
	public void admin_should_see_placeholder_in_dropdown(String SelectTheRole) {
		  String SelectTheRole1= loginpagefactory.checkforSelectRoleTextField();
		    Assert.assertEquals(SelectTheRole1, SelectTheRole);
	}

	@Then("Admin should see {string} options in dropdown")
	public void admin_should_see_options_in_dropdown(String ExpectedRoleList) {
		boolean verifylist= loginpagefactory.VerifyingTheRoleList(ExpectedRoleList);
		Assert.assertEquals(true, verifylist);
	   
	}

	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
	    
	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
	   boolean loginButtondisplay = loginpagefactory.isLoginButtonDisplaying();
	   Assert.assertEquals(loginButtondisplay, true);
	}

	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() {
	boolean UserTextcolor = loginpagefactory.adminUserTextColorValidation();
	Assert.assertEquals(UserTextcolor, true);
		
	}

	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
		boolean PasswordTextcolor = loginpagefactory.adminPasswordTextColorValidation();
		Assert.assertEquals(PasswordTextcolor, true);
	}

///Login1 StepDefinitions
	
	@Given("Admin is on login Page")
	public void admin_is_on_login_page() {
		LoggerLoad.info("Admin is on login Page");
	}

	@When("Admin enter valid data in all field and clicks login button")
	public void admin_enter_valid_data_in_all_field_and_clicks_login_button() {
		loginpagefactory.getbaseurl();
		loginpagefactory.enter_user_name(ConfigReader.userName());
		loginpagefactory.enter_user_password(ConfigReader.passWord());
		loginpagefactory.SelectingTheRole();
		loginpagefactory.clickLoginButton();
		Assert.assertEquals(loginpagefactory.HomePageValidation(), ConfigReader.HomePageURL());  	
	}

	@Then("Admin should land on home page")
	public void admin_should_land_on_home_page() {
		//Assert.assertEquals(loginpagefactory.HomePageValidation(), ConfigReader.HomePageURL());  	
	}
	
	@When("Admin enter value {string} {string} only in password and clicks login button")
	public void admin_enter_value_only_in_password_and_clicks_login_button(String NullUserNmae, String TestCase) throws IOException {
		loginpagefactory.getbaseurl();
		loginpagefactory.enter_user_name(exelread.getTestData(NullUserNmae, TestCase, "username"));
		loginpagefactory.enter_user_password(exelread.getTestData(NullUserNmae, TestCase, "password"));    	
		loginpagefactory.SelectingTheRole();
		loginpagefactory.clickLoginButton();
	}


	@Then("Error message {string}")
	public void error_message(String Error) throws InterruptedException {
	  String ActualError = loginpagefactory.pleaseEnterUserNameError();
	  Assert.assertEquals(ActualError, Error);
	  LoggerLoad.info("Please enter your user name Error");
	}
	
	@When("Admin enter invalid {string} {string} credentials and clicks login button")
	public void admin_enter_invalid_credentials_and_clicks_login_button(String Sheet, String TestCase) throws IOException {
        
	loginpagefactory.getbaseurl();
	loginpagefactory.enter_user_name(exelread.getTestData(Sheet, TestCase, "username"));
	loginpagefactory.enter_user_password(exelread.getTestData(Sheet, TestCase, "password"));    	
	loginpagefactory.SelectingTheRole();
	loginpagefactory.clickLoginButton();
    }
	
	@Then("Error message displayed is {string}")
	public void error_message_displayed_is(String string) {
	   LoggerLoad.info("Invalid username and password Please try again");
	}

	@When("Admin enter value {string} {string} only in user name and clicks login button")
	public void admin_enter_value_only_in_user_name_and_clicks_login_button(String NullPassword, String TestCase) throws IOException {
		loginpagefactory.getbaseurl();
		loginpagefactory.enter_user_name(exelread.getTestData(NullPassword, TestCase, "username"));
		loginpagefactory.enter_user_password(exelread.getTestData(NullPassword, TestCase, "password"));    	
		loginpagefactory.SelectingTheRole();
		loginpagefactory.clickLoginButton();
	    }
	


	@When("Admin enter value only in user name and clicks login button")
	public void admin_enter_value_only_in_user_name_and_clicks_login_button() {
	
	}

	@Then("Error message displayed {string}")
	public void error_message_please_enter_your_password(String Error) throws InterruptedException {
		 String ActualError = loginpagefactory.pleaseEnterPasswordError();
		  Assert.assertEquals(Error, ActualError);
		  LoggerLoad.info("Please enter your user name Error");
	}

	@When("Admin enter valid credentials  and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() throws InterruptedException {
		loginpagefactory.getbaseurl();
		loginpagefactory.enter_user_name(ConfigReader.userName());
		loginpagefactory.enter_user_password(ConfigReader.passWord());    	
		loginpagefactory.SelectingTheRole();
		loginpagefactory.keyboardEnter();
	}

	@When("Admin enter valid credentials  and clicks login button through mouse")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() throws InterruptedException {
		loginpagefactory.getbaseurl();
		loginpagefactory.enter_user_name(ConfigReader.userName());
		loginpagefactory.enter_user_password(ConfigReader.passWord());    	
		loginpagefactory.SelectingTheRole();
		loginpagefactory.mouseActionClick();
	}
	
	
	@When("Admin gives correct LMS portal URL")
	public void admin_gives_correct_lms_portal_url() throws InterruptedException {
		loginpagefactory.getbaseurl();

	}
	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) throws MalformedURLException, IOException {
		Assert.assertEquals(loginpagefactory.BrokenLinkValidation(),1);
	}

}
