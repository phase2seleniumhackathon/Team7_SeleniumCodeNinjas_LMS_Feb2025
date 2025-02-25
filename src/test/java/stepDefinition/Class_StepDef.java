package stepDefinition;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddClass_POF;
import pageObjects.Class_POF;
import pageObjects.LoginPage_POF;
import utilities.ConfigReader;

public class Class_StepDef {
	
	WebDriver driver;
	 LoginPage_POF loginpagefactory = new LoginPage_POF();
	 Class_POF classpagefactory = new Class_POF();
	 

	
	@Given("Admin logged on the home page ML")
	public void Admin_logged_on_the_home_page() {
		loginpagefactory.enter_user_name(ConfigReader.userName());
		loginpagefactory.enter_user_password(ConfigReader.passWord());
		loginpagefactory.SelectingTheRole();
		loginpagefactory.clickLoginButton();
	}

	@Given("Admin is on the home Page after login ML")
	public void admin_is_on_the_home_page_after_login() {
	   
	}

	@When("Admin clicks the Class Navigation bar in the Header ML")
	public void admin_clicks_the_class_navigation_bar_in_the_header() {
		classpagefactory.clickClass();
	}

	@Then("Admin should land on the Manage class page ML")
	public void admin_should_land_on_the_manage_class_page() {
	   Assert.assertTrue(classpagefactory.isClassPageDisplayed(),"Class Page is not displayed!");
	}

	@Then("Admin should see the {string} Title ML")
	public void admin_should_see_the_title(String expectedHeading) {
	    String actualHeading = classpagefactory.getLMSHeading().trim();
	    System.out.println("Actual Title: '" + actualHeading + "'");
	    System.out.println("Expected Title: '" + expectedHeading + "'");
	    Assert.assertEquals(expectedHeading.trim(), actualHeading);
    
	}

	@Then("Admin should see the {string} Header ML")
	public void admin_should_see_the_header(String expectedHeading) {
		String actualHeading = classpagefactory.validateManageClassHeader();
		Assert.assertEquals(expectedHeading.trim(), actualHeading);
		
	}

	@Then("Admin should see the Search Bar in Manage class page ML")
	public void admin_should_see_the_search_bar_in_manage_class_page() {
	    classpagefactory.getSearchBar();
	   // Assert.assertEquals(expectedHeading.trim(), actualHeading);
	}

	@Then("Admin should see all expected column headers ML")
	public void admin_should_see_all_expected_column_headers(List<String> expectedHeaders) {
		 List<String> actualColHeaders =classpagefactory.getAllColumnHeaders(); 

		    System.out.println("Actual Headers: " + actualColHeaders);
		    System.out.println("Expected Headers: " + expectedHeaders);

		    for (String expectedHeader : expectedHeaders) {
		        Assert.assertTrue(actualColHeaders.contains(expectedHeader.trim()), "Header not found: " + expectedHeader);
		
		    }
	}

	@Then("Admin should see the {string} and enabled pagination controls under the data table ML")
	public void admin_should_see_the_and_enabled_pagination_controls_under_the_data_table(String expectedPattern) {
	   	
		Assert.assertTrue(classpagefactory.verifyText(),"Invalid Text");
	    Assert.assertTrue(classpagefactory.verifyPagination());
	}

	@Then("Admin should see the Sort icon of all the field in the datatable ML.")
	public void admin_should_see_the_sort_icon_of_all_the_field_in_the_datatable() {
	 Assert.assertTrue(classpagefactory.validateSortIcons(),"Sort Icons not dispalyed");  
	}

	@Then("Admin should see the Delete button under the Manage class page header ML.")
	public void admin_should_see_the_delete_button_under_the_manage_class_page_header() {
		Assert.assertTrue(classpagefactory.validateDeleteBtn(),"Delete Button is not dispalyed");  
	}

	@Then("Admin should see Total no of classes in below of the data table ML.")
	public void admin_should_see_total_no_of_classes_in_below_of_the_data_table() {
		Assert.assertTrue(classpagefactory.validateTotalClasses(),"Total no of classes not displayed");
	}
	
	
}
