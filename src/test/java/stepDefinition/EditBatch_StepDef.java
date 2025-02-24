package stepDefinition;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.EditBatch_POF;
import utilities.ConfigReader;
import utilities.ExcelReaderShami;

public class EditBatch_StepDef {
	
	EditBatch_POF editBatch = new EditBatch_POF(DriverFactory.getDriver());
	ExcelReaderShami reader = new ExcelReaderShami();
	
	@Given("Admin is on the Batch page SB")
	public void admin_is_on_the_batch_page() {
	    editBatch.clicksBatchLinkHomePAge();
	}

	@When("Admin clicks the edit icon in any row SB")
	public void admin_clicks_the_edit_icon_in_any_row() {
	    editBatch.clickEditIcon();
	}

	@Then("Admin should see the Batch details pop-up window SB")
	public void admin_should_see_the_batch_details_pop_up_window() {
	    Assert.assertTrue(editBatch.verifyEditBatchWindowOpened());
	}

	@Then("Admin should see the Program Name field is disabled for editing SB")
	public void admin_should_see_the_program_name_field_is_disabled_for_editing() {
		Assert.assertFalse(editBatch.isPrgNameEnabled());
	}

	@Then("Admin should see the Batch Name field is disabled for editing SB")
	public void admin_should_see_the_batch_name_field_is_disabled_for_editing() {
	   Assert.assertTrue(editBatch.isBatchNameEnabled());
	}

	@Given("Admin is on the Batch Details Page SB")
	public void admin_is_on_the_batch_details_page() {
		editBatch.clicksBatchLinkHomePAge();
	   editBatch.clickEditIcon();
	}

	@When("Admin updates Description or Number of Classes with invalid data and clicks the save button SB")
	public void admin_updates_description_or_number_of_classes_with_invalid_data_and_clicks_the_save_button() {
	    editBatch.enterInvalidvalues();
	    editBatch.clickSaveButton();
	}

	@Then("Admin should see an error message under the respective field SB")
	public void admin_should_see_an_error_message_under_the_respective_field() {
	  Assert.assertTrue(editBatch.getErrorMessage());
	}

	@When("Admin enters valid data in all the mandatory fields and clicks the save button SB")
	public void admin_enters_valid_data_in_all_the_mandatory_fields_and_clicks_the_save_button() {
		String filePath = new File("src/test/resources/TestData/Team7-TestData.xlsx").getAbsolutePath();
		int rownumber =0;
		String sheetname="EditBatch";
		System.out.println(filePath);
		   List<Map<String,String>> testData = reader.getData(filePath,sheetname );
		   String description = testData.get(rownumber).get("Description");
		   String NoOfClasses = testData.get(rownumber).get("NumberOfClasses");
		   String Status = testData.get(rownumber).get("Status");
		   
		   editBatch.enterAllValidValues(description,NoOfClasses);
		   editBatch.selectStatus(Status);
		   
		   editBatch.clickSaveButton();
	}

	@Then("Admin should see a success message for editing the batch SB")
	public void admin_should_see_a_success_message_for_editing_the_batch() {
	    Assert.assertTrue(editBatch.validateSucessMessage());
	}

	@When("Admin enters valid data in all the mandatory fields and clicks the cancel button SB")
	public void admin_enters_valid_data_in_all_the_mandatory_fields_and_clicks_the_cancel_button() {
		String filePath = new File("src/test/resources/TestData/Team7-TestData.xlsx").getAbsolutePath();
		int rownumber =0;
		String sheetname="EditBatch";
		System.out.println(filePath);
		   List<Map<String,String>> testData = reader.getData(filePath,sheetname );
		   String description = testData.get(rownumber).get("Description");
		   String NoOfClasses = testData.get(rownumber).get("NumberOfClasses");
		   String Status = testData.get(rownumber).get("Status");
		   
		   editBatch.enterAllValidValues(description,NoOfClasses);
		   editBatch.selectStatus(Status);
		   
		   editBatch.clickCancelButton();
	}

	@Then("Admin should see the Batch Details pop-up close without editing the batch SB")
	public void admin_should_see_the_batch_details_pop_up_close_without_editing_the_batch() {
	//	Assert.assertTrue(editBatch.ManageBatchHeadingdisplayed());
		Assert.assertTrue(editBatch.isElementDisplayed(DriverFactory.getDriver(), editBatch.getmanageBatchHeading()));
	}

}
