package stepDefinition;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.Program_POF;

public class Program_AddNewProgramStepDef {
	private static WebDriver driver;
	private Program_POF ProgramPage;

	public Program_AddNewProgramStepDef() {
		this.driver = DriverFactory.getDriver();
		this.ProgramPage = new Program_POF(driver);
	}

//Background
	@Given("Admin is on the Program details form SS")
	public void admin_is_on_the_program_details_form_SS() {

	}

//@Program17
	@Given("Admin is on Program Page SS")
	public void admin_is_on_program_Page_SS() {
		ProgramPage.clickProgramLink();
		ProgramPage.isProgramPageDisplayed();
	}

	@When("Admin clicks on {string} under the {string} menu bar SS")
	public void Admin_clicks_on_under_the_menu_bar_SS(String string, String string2) throws InterruptedException {
		ProgramPage.clickProgramLink();
		Thread.sleep(1000);
		ProgramPage.clickAddNewProgram();
	}

	@Then("Admin should see pop up window for program details SS")
	public void admin_should_see_pop_up_window_for_program_details_SS() throws InterruptedException {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean ProgrampopupDisplay = ProgramPage.isProgramDetailPopupDisplayed();
		Assert.assertTrue("Program Details form should be visible", ProgrampopupDisplay);
	}

//@Program18
	@Then("Admin should see window title as {string} SS")
	public void admin_should_see_window_title_as_SS(String expectedTitle) {
		System.out.println("WINDOW TITLE");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actualTitle = ProgramPage.getPopupTitle();
		System.out.println("Expected Title " + expectedTitle + "ActualTitle" + actualTitle);
		Assert.assertEquals("Window title does not match!", expectedTitle, actualTitle);
	}

// @Program19
	@Then("Admin should see red  asterisk mark  beside mandatory field {string} SS")
	public void admin_should_see_red_asterisk_mark_beside_mandatory_field_SS(String fieldName) {
		try {
			boolean isRedAsteriskVisible = ProgramPage.isRedasteriskDisplayed();
			Assert.assertTrue("Red asterisk mark is not displayed for the mandatory field: " + fieldName,
					isRedAsteriskVisible);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

//@Program20
	@Given("Admin is on Program details form SS")
	public void Admin_is_on_Program_details_form_SS() {
		ProgramPage.clickProgramLink();
		ProgramPage.isProgramPageDisplayed();
	}

	@When("Admin clicks on {string} under the {string} menu bar and clicks save button without entering mandatory SS")
	public void admin_clicks_on_under_the_menu_bar_and_clicks_save_button_without_entering_mandatory_SS(String string,
			String string2) throws InterruptedException {
		ProgramPage.clickProgramLink();
		Thread.sleep(5000);
		ProgramPage.clickAddNewProgram();
		ProgramPage.saveClick();
		Thread.sleep(5000);
		System.out.println("Clicked Save button successfully.");
	}

	@Then("Admin gets message {string} SS")
	public void admin_gets_message_SS(String expected) throws InterruptedException {
		String actualMessage = ProgramPage.testRequiredFieldMessage();
		Assert.assertEquals("Validation message does not match!", expected, actualMessage);
		System.out.println("Validation message verified: " + actualMessage);
	}

//ProgramPage21
	@Given("Admin is on Program Details form SS")
	public void Admin_is_on_program_Details_form_SS() {
		ProgramPage.clickProgramLink();
		ProgramPage.isProgramPageDisplayed();
	}

	@When("Admin clicks on {string} under the {string} menu bar and clicks Cancel button SS")
	public void admin_clicks_on_under_the_menu_bar_and__clicks_cancel_button_SS(String string, String string2)
			throws InterruptedException {
		ProgramPage.clickProgramLink();
		Thread.sleep(5000);
		ProgramPage.clickAddNewProgram();
		ProgramPage.clickCancelButton();
		Thread.sleep(5000);
		System.out.println("Clicked Save button successfully.");
	}

	@Then("Admin can see Program Details form disappears SS")
	public void admin_can_see_program_details_form_disappears_SS() {
		try {
			boolean isDisplayed = ProgramPage.isProgramDetailsDisplayed();

			if (!isDisplayed) {
				System.out.println("Program Details form has disappeared successfully.");
			} else {
				System.out.println("Program Details form is still visible!");
			}
		} catch (TimeoutException e) {
			System.out.println(" Timeout: Program Details form is still visible after waiting.");

		} catch (NoSuchElementException e) {
			System.out.println(" Program Details form is not found, assumed disappeared.");
		} catch (Exception e) {
			System.out.println(" Unexpected error: " + e.getMessage());

		}
	}

//ProgramPage22
	@Given("Admin is on program details form SS")
	public void admin_is_on_program_details_form_SS() {
		ProgramPage.clickProgramLink();
		ProgramPage.isProgramPageDisplayed();
	}

	@When("Admin clicks on {string} under the {string} menu bar and enters the Name in the text box SS")
	public void admin_clicks_on_under_the_menu_bar_and_enters_the_name_in_the_text_box_SS(String programmenuBar,
			String programName) throws InterruptedException {
		ProgramPage.clickProgramLink();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		ProgramPage.clickAddNewProgram();
		ProgramPage.isProgramDetailPopupDisplayed();
		ProgramPage.enterProgramName(programName);
	}

	@Then("Admin can see the text entered SS")
	public void admin_can_see_the_text_entered_SS() {
		String enteredText = ProgramPage.getEnteredProgramName();
		System.out.println("Entered Text: " + enteredText);
		Assert.assertEquals("The entered program name should match.", "Program", enteredText);
	}

	// ProgramPage23
	@When("Admin clicks on {string} under the {string} menu bar and enters the Description in text box SS")
	public void admin_clicks_on_under_the_menu_bar_and_enters_the_description_in_text_box_SS(String programmenuBar,
			String TestName) {
		ProgramPage.clickProgramLink();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		ProgramPage.clickAddNewProgram();
		ProgramPage.isProgramDetailPopupDisplayed();
		ProgramPage.enterProgramDescription(TestName);
	}

	@Then("Admin can see the text entered in description box SS")
	public void admin_can_see_the_text_entered_in_description_box_SS() {
		{
			String enteredText = ProgramPage.getEnteredProgramDescription();
			System.out.println("Entered Text: " + enteredText);
			Assert.assertEquals("The entered program name should match.", "Program", enteredText);
		}

	}

// ProgramPage24
	@Given("Admin Is On Program Details Form SS")
	public void Admin_Is_On_Program_Details_Form_SS() {
		ProgramPage.clickProgramLink();
		ProgramPage.isProgramPageDisplayed();
	}

	@When("Admin clicks on {string} under the {string} menu bar and selects the status of the program by clicking on the radio button {string} SS")
	public void admin_clicks_on_under_the_menu_bar_and_selects_the_status_of_the_program_by_clicking_on_the_radio_button_SS(
			String string, String string2, String string3) {
		try {
			ProgramPage.clickProgramLink();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			ProgramPage.clickAddNewProgram();
			ProgramPage.isProgramDetailPopupDisplayed();
			ProgramPage.clickStatus();
		} catch (Exception e) {
			System.out.println("Error clicking status: " + e.getMessage());
		}
	}

	@Then("Admin can see {string} status selected SS")
	public void admin_can_see_status_selected_SS(String string) {
		ProgramPage.isStatusSelected();
	}

// ProgramPage25
	@When("Admin clicks On {string} under the {string} menu bar and enter valid details for mandatory fields and Click on save button SS")
	public void admin_clicks_On_under_the_menu_bar_and_enter_valid_details_for_mandatory_fields_and_click_on_save_button_SS(
			String string, String string2) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		ProgramPage.clickProgramLink();
		ProgramPage.isProgramPageDisplayed();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add New Program']")));
		ProgramPage.clickAddNewProgram();
		ProgramPage.isProgramDetailPopupDisplayed();
		ProgramPage.createForm();
		ProgramPage.clickStatus();
		ProgramPage.clickSaveButton();
		Thread.sleep(5000);
	}

	@Then("Admin gets Message {string} SS")
	public void Admin_gets_Message_SS(String expected) {
		String successMsg = ProgramPage.successMsgSave();
		expected = "Program Created Successfully";
		Assert.assertEquals(expected, successMsg);
	}

// ProgramPage26
	@Given("Admin is on Program Details Form SS")
	public void admin_is_on_program_Details_Form_SS() {
		ProgramPage.clickProgramLink();
		ProgramPage.isProgramPageDisplayed();
	}

	@When("admin Clicks on {string} under the {string} menu bar and Clicks Cancel button SS")
	public void admin_Clicks_on_under_the_menu_bar_and__Clicks_Cancel_button_SS(String string, String string2)
			throws InterruptedException {
		ProgramPage.clickProgramLink();
		Thread.sleep(5000);
		ProgramPage.clickAddNewProgram();
		ProgramPage.clickCancelButton();
		Thread.sleep(5000);
		System.out.println("Clicked Cancel button successfully.");
	}

	@Then("Admin can see Program Details Form Disappears SS")
	public void Admin_can_see_program_details_Form_Disappears_SS() {
		try {
			boolean isDisplayed = ProgramPage.isProgramDetailsDisplayed();

			if (!isDisplayed) {
				System.out.println("Program Details form has disappeared successfully.");
			} else {
				System.out.println("Program Details form is still visible!");
			}
		} catch (TimeoutException e) {
			System.out.println(" Timeout: Program Details form is still visible after waiting.");
		} catch (NoSuchElementException e) {
			System.out.println(" Program Details form is not found, assumed disappeared.");
		} catch (Exception e) {
			System.out.println(" Unexpected error: " + e.getMessage());

		}
	}

	@When("Admin searches with newly created {string} SS")
	public void admin_searches_with_newly_created_SS(String programName) {
		ProgramPage.clickProgramLink();
		Assert.assertTrue("Program page is not displayed!", ProgramPage.isProgramPageDisplayed());
		ProgramPage.searchProgram(programName);
	}

	@Then("Records of the newly created  {string} is displayed and match the data entered SS")
	public void records_of_the_newly_created_is_displayed_and_match_the_data_entered_SS(String programName) {
		boolean isDisplayed = ProgramPage.isProgramDisplayed(programName);
		Assert.assertTrue(isDisplayed);

	}

	@When("Admin Click on {string} button SS")
	public void admin_click_on_button_SS(String string) {
		ProgramPage.clickProgramLink();
		ProgramPage.isProgramPageDisplayed();
         ProgramPage.clickAddNewProgram();
		ProgramPage.isProgramDetailPopupDisplayed();
		ProgramPage.clickCloseButton();

	}

	@Then("Admin can see program details form disappear SS")
	public void admin_can_see_program_details_form_disappear_SS() {
		boolean isClosed = ProgramPage.isProgramDetailsFormClosed();
		Assert.assertTrue("Program details form is still visible!", isClosed);

	}

}