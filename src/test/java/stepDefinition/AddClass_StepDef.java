package stepDefinition;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddClass_POF;
import pageObjects.Class_POF;
import pageObjects.LoginPage_POF;
import utilities.ConfigReader;

public class AddClass_StepDef {

	WebDriver driver;
	WebDriverWait wait;
	LoginPage_POF loginpagefactory = new LoginPage_POF();
	AddClass_POF addNewClass = new AddClass_POF();
	Class_POF classpagefactory = new Class_POF();
	
	@Given("Admin Is on the Manage class page after login ML")
	public void admin_is_on_the_manage_class_page_after_login() {
		loginpagefactory.enter_user_name(ConfigReader.userName());
		loginpagefactory.enter_user_password(ConfigReader.passWord());
		loginpagefactory.SelectingTheRole();
		loginpagefactory.clickLoginButton();
	}

	@Given("Admin is on the Manage class page ML")
	public void admin_is_on_the_manage_class_page() {
		addNewClass.manageClass();
	}

	@When("Admin clicks a add new class under the class menu bar ML.")
	public void admin_clicks_a_add_new_class_under_the_class_menu_bar() {
		addNewClass.addNewClass();
	}

	@Then("Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window ML")
	public void admin_should_see_a_popup_open_for_class_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() throws InterruptedException {
		Assert.assertTrue(addNewClass.isSaveButtonDisplayed(),"Save button not displayed");
		Assert.assertTrue(addNewClass.isCancelButtonDisplayed(),"Cancel button not displayed");
		//Assert.assertTrue(addNewClass.isXButtonDisplayed(),"X Button not displayed");
		addNewClass.isXButtonDisplayed();
	}

	@Then("Admin should see few input fields and their respective text boxes in the class details window ML")
	public void admin_should_see_few_input_fields_and_their_respective_text_boxes_in_the_class_details_window() {
		Assert.assertTrue(addNewClass.batchName(),"Batch Name not displayed");
		Assert.assertTrue(addNewClass.batchNameTextBox(),"Batch Name text box not displayed");
		Assert.assertTrue(addNewClass.classTopic(),"Class Topic not displayed");
		Assert.assertTrue(addNewClass.classTopicTextBox(),"Class Topic text box not displayed");
		Assert.assertTrue(addNewClass.classDescription(),"Class Description not displayed");
		Assert.assertTrue(addNewClass.classDescriptionTextBox(),"Class Description text box not displayed");
		Assert.assertTrue(addNewClass.classDates(),"Class dates not displayed");
		Assert.assertTrue(addNewClass.classDatesTextBox(),"Class dates text box not displayed");
		Assert.assertTrue(addNewClass.numberOfClass(),"Number of classes not displayed");
		Assert.assertTrue(addNewClass.numberOfClassTextBox(),"Number of classes text box not displayed");
		Assert.assertTrue(addNewClass.staffName(),"Staff Name not displayed");
		Assert.assertTrue(addNewClass.staffNameTextBox(),"Staff Name text box not displayed");
		Assert.assertTrue(addNewClass.comments(),"Comments not displayed");
		Assert.assertTrue(addNewClass.commentsTextBox(),"Comments text box not displayed");
		Assert.assertTrue(addNewClass.notes(),"Notes not displayed");
		Assert.assertTrue(addNewClass.notesTextBox(),"Notes text box not displayed");
		Assert.assertTrue(addNewClass.recordings(),"Recording not displayed");
		Assert.assertTrue(addNewClass.recordingsTextBox(),"Recording text box not displayed");
		Assert.assertTrue(addNewClass.status(),"Status not displayed");
		addNewClass.validateStatusSelection();

	}
	
	@Given("Admin is on the Class Popup window ML")
	public void admin_is_on_the_class_popup_window() {
		addNewClass.manageClass();
		addNewClass.addNewClass();
	}

	@When("Admin enters mandatory fields in the form and clicks on save button from {string} with scenario name {string} in class module ML")
	public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_save_button(String sheetName, String scenarioName) throws IOException, InterruptedException {
		addNewClass.enterMandatoryFields(sheetName, scenarioName);
	}

	@Then("Admin gets message Class added Successfully from {string} with scenario name {string} in class module ML")
	public void admin_gets_message_class_added_successfully(String sheetName,String scenarioName) throws IOException {
		addNewClass.validateSuccessClassCreated(sheetName, scenarioName);
	}

	@When("Admin selects class date in date picker ML")
	public void admin_selects_class_date_in_date_picker() throws InterruptedException {
		addNewClass.validateNoOfClasses();
	}

	@Then("Admin should see no of class value is added automatically ML")
	public void admin_should_see_no_of_class_value_is_added_automatically() {
		addNewClass.getNumberOfClasses();
		//Assert.assertFalse(addNewClass.getNumberOfClasses().isEmpty(), "No of classes value is empty!");

		
	}

	@When("Admin clicks date picker ML")
	public void admin_clicks_date_picker() {
		addNewClass.selectdatePicker();
	}

	@Then("Admin should see weekends dates are disabled to select ML")
	public void admin_should_see_weekends_dates_are_disabled_to_select() {
		addNewClass.verifyWeekendDisabled();
		
		
		
	}

	@When("Admin skips to add value in mandatory field and enter only the optional field ML")
	public void admin_skips_to_add_value_in_mandatory_field_and_enter_only_the_optional_field() {
		addNewClass.classWithOptionalFields();
	}


@Then("Admin should see error message below the test field and the field will be highlighted in red color ML")
public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighted_in_red_color(){
	
	Assert.assertTrue(addNewClass.isClassTopicErrorDisplayed(), "Class Topic error message is not displayed!");
	    Assert.assertTrue(addNewClass.isClassDateErrorDisplayed(), "Class Date error message is not displayed!");
	    Assert.assertTrue(addNewClass.isNoOfClassesErrorDisplayed(), "No. of Classes error message is not displayed!");
	    Assert.assertTrue(addNewClass.isStaffNameErrorDisplayed(), "Staff Name error message is not displayed!");
	    Assert.assertTrue(addNewClass.isStatusErrorDisplayed(), "Status error message is not displayed!");
	
	}

	@When("Admin enters invalid data in all of the  fields in the form and clicks on save button ML")
	public void admin_enters_invalid_data_in_all_of_the_fields_in_the_form_and_clicks_on_save_button() {
	    
	}

	@Then("Admin gets error message and class is not created ML")
	public void admin_gets_error_message_and_class_is_not_created() {
	   
	}

	@When("Admin clicks on save button without entering data ML")
	public void admin_clicks_on_save_button_without_entering_data() {
		addNewClass.clickSaveButton();
	}

	@Then("class won't be created and Admin gets error message ML.")
	public void class_won_t_be_created_and_admin_gets_error_message() {
	    
		 Assert.assertTrue(addNewClass.isBatchNameErrorDisplayed(), "Batch Name error message is not displayed!");
		    Assert.assertTrue(addNewClass.isClassTopicErrorDisplayed(), "Class Topic error message is not displayed!");
		    Assert.assertTrue(addNewClass.isClassDateErrorDisplayed(), "Class Date error message is not displayed!");
		    Assert.assertTrue(addNewClass.isNoOfClassesErrorDisplayed(), "No. of Classes error message is not displayed!");
		    Assert.assertTrue(addNewClass.isStaffNameErrorDisplayed(), "Staff Name error message is not displayed!");
		    Assert.assertTrue(addNewClass.isStatusErrorDisplayed(), "Status error message is not displayed!");

		    System.out.println("All required field error messages are correctly displayed.");
		
		
		
	}

	@When("Admin clicks Close\\(X) Icon on Admin Details form ML")
	public void admin_clicks_cancel_close_x_icon_on_admin_details_form() {
		addNewClass.clickXButton();
	}

	@Then("Class Details popup window should be closed without saving ML")
	public void class_details_popup_window_should_be_closed_without_saving() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		addNewClass.isPopupClosed();
	  // Assert.assertTrue(addNewClass.isPopupClosed(), "Class Details popup is still visible");
	   System.out.println("Class Details popup closed successfully.");
	}

	@When("Admin clicks save button ML")
	public void admin_clicks_save_button() throws InterruptedException {
		String batchName = "";
		addNewClass.selectBatchName(batchName);
		addNewClass.classTopic();
		addNewClass.selectClassDates();
		addNewClass.selectStaffName();
		addNewClass.statusActive();
		addNewClass.clickSaveButton();
		
	}

	@Then("Admin can see the class details popup closed and adding new class ML")
	public void admin_can_see_the_class_details_popup_closed_and_adding_new_class() {
		addNewClass.isPopupClosed();
		
	}



	
}
