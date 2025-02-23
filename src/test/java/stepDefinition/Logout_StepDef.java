package stepDefinition;

import org.testng.Assert;

import driverFactory.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage_POF;
import pageObjects.Logout_POF;
import utilities.ConfigReader;

public class Logout_StepDef {
	
LoginPage_POF loginpagefactory= new LoginPage_POF();
	Logout_POF logoutpagefactory= new Logout_POF(DriverFactory.getDriver());
	
	@Given("Admin is on homepage")
	public void admin_is_on_homepage() throws InterruptedException {
		loginpagefactory.getbaseurl();
		loginpagefactory.enter_user_name(ConfigReader.userName());
		loginpagefactory.enter_user_password(ConfigReader.passWord());
		loginpagefactory.SelectingTheRole();
		loginpagefactory.clickLoginButton();
	}

	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() throws InterruptedException {
		logoutpagefactory.isElementDisplayed(DriverFactory.getDriver(), logoutpagefactory.getlogout());
		logoutpagefactory.clickLogout();
	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
	   Assert.assertEquals(logoutpagefactory.logoutvalidation(), true);
	}
	
	// Verify back button
	
	@Given("Admin is on loginpage")
	public void admin_is_on_loginpage() {
		loginpagefactory.getbaseurl();
	}	
	
	@When("Admin is in login page and clicks the back button")
	public void admin_is_in_login_page_and_clicks_the_back_button() {
		Assert.assertEquals(logoutpagefactory.logoutvalidation(), true);
		DriverFactory.getDriver().navigate().back();
	}

	@Then("Admin should receive error message")
	public void admin_should_receive_error_message() {
		//Assert.assertEquals(null, "ErrorMessage");
	}


}
