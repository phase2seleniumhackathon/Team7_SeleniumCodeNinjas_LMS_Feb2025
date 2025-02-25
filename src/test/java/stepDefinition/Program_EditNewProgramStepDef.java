package stepDefinition;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.Program_POF;

public class Program_EditNewProgramStepDef {

	private static WebDriver driver;
	private Program_POF ProgramPage;

	public Program_EditNewProgramStepDef() {
		this.driver = DriverFactory.getDriver();
		this.ProgramPage = new Program_POF(driver);
	}

//ProgramPage29
	@When("Admin clicks on Edit option for particular Program SS")
	public void admin_clicks_on_edit_option_for_particular_Program_SS() {

		ProgramPage.ClickEditButton();

	}

	@Then("Admin lands on Program details form SS")
	public void admin_lands_on_program_details_form_SS() {
		ProgramPage.isProgramDetailPopupDisplayed();

	}

//ProgramPage31
	@Then("Admin should see red asterisk mark beside mandatory field {string} SS")
	public void admin_should_see_red_asterisk_mark_beside_mandatory_field_SS(String fieldName) {
		try {
			boolean isRedAsteriskVisible = ProgramPage.isRedasteriskDisplayed();
			Assert.assertTrue("Red asterisk mark is not displayed for the mandatory field: " + fieldName,
					isRedAsteriskVisible);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
//ProgramPage32

	@When("Admin edits the program nameto {string} and click on save button SS")
	public void admin_edits_the_program_nameto_and_click_on_save_button_SS(String NewProgramName)
			throws InterruptedException {
		try {
			ProgramPage.clickProgramLink();
			ProgramPage.isProgramPageDisplayed();
			ProgramPage.ClickEditButton();
			ProgramPage.isProgramDetailPopupDisplayed();
			ProgramPage.EditProgramSteps(NewProgramName);
			ProgramPage.clickStatus();
			ProgramPage.clickSaveButton();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element not clickable");
		} catch (TimeoutException e) {
			System.out.println("Timeout: SaveButton is still visible after waiting.");
		}
	}

	@Then("Updated Program Name is seen by the Admin SS")
	public void Updated_Program_Name_is_seen_by_the_admin_SS() {

		ProgramPage.updateProgramSteps();

	}

//ProgramPage33

	@When("Admin edits the description textto {string} and click on save button SS")
	public void admin_edits_the_description_textto_and_click_on_save_button_SS(String NewProgramDescription) {
		try {
			ProgramPage.clickProgramLink();
			ProgramPage.isProgramPageDisplayed();
			ProgramPage.ClickEditButton();
			ProgramPage.isProgramDetailPopupDisplayed();
			ProgramPage.EditProgramDescriptionSteps(NewProgramDescription);
			ProgramPage.clickStatus();
			ProgramPage.clickSaveButton();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element not clickable");
		} catch (TimeoutException e) {
			System.out.println("Timeout: SaveButton is still visible after waiting.");
		}
	}

	@Then("Admin can see the description is updated SS")
	public void admin_can_see_the_description_is_updated_SS() {

		ProgramPage.updateProgramDescriptionSteps();

	}
	
//Program34
@When("Admin can change the status of the program and click on save button SS")
public void admin_can_change_the_status_of_the_program_and_click_on_save_button_SS() {
	
	try {
		ProgramPage.clickProgramLink();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    ProgramPage.ClickEditButton();
		ProgramPage.isProgramDetailPopupDisplayed();
		ProgramPage.clickStatus();
	} catch (Exception e) {
		System.out.println("Error clicking status: " + e.getMessage());
	}
}
	
@Then("Status updated can be viewed by the Admin")
public void status_updated_can_be_viewed_by_the_admin() {
	ProgramPage.isStatusSelected();
    
}

//Program35
@When("Admin Click On Save Button SS")
public void admin_Click_on_save_button_SS() throws InterruptedException {
    
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	ProgramPage.clickProgramLink();
	ProgramPage.isProgramPageDisplayed();
	ProgramPage.ClickEditButton();
	ProgramPage.isProgramDetailPopupDisplayed();
	ProgramPage.editform();
	ProgramPage.clickStatus();
	ProgramPage.clickSaveButton();
	Thread.sleep(5000);
}


@Then("Admin Can See The Updated Program Details SS")
public void Admin_Can_See_The_Updated_Program_Details_SS(String expected) {
	String successMsg = ProgramPage.successMsgSave();
	expected = "Program Created Successfully";
	Assert.assertEquals(expected, successMsg);
   
}

	
//ProgramPage36
	@When("Admin click on cancel button SS")
	public void admin_click_on_cancel_button_SS() throws InterruptedException {

		ProgramPage.clickProgramLink();
		ProgramPage.isProgramPageDisplayed();
		ProgramPage.clickAddNewProgram();
		ProgramPage.isProgramDetailPopupDisplayed();
		ProgramPage.clickCancelButton();
		Thread.sleep(5000);
		System.out.println("Clicked Cancel button successfully.");
	}

	@Then("Admin can see the Program details form disappears SS")
	public void admin_can_see_the_program_details_form_disappears_SS() {
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
}
