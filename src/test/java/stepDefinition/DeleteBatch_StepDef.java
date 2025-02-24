package stepDefinition;

import org.testng.Assert;

import com.github.dockerjava.api.model.Driver;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DeleteBatch_POF;

public class DeleteBatch_StepDef {
	
	DeleteBatch_POF deleteBatch = new DeleteBatch_POF(DriverFactory.getDriver());
	
	@When("Admin clicks the delete icon on any row SB")
	public void admin_clicks_the_delete_icon_on_any_row() {
	   // deleteBatch.clickDeleteIcon();
		deleteBatch.clicktheOption(DriverFactory.getDriver(), deleteBatch.getdeleteIcon());
	}

	@Then("Admin should see the {string} alert box with Yes and No buttons SB")
	public void admin_should_see_the_confirm_alert_box_with_yes_and_no_buttons(String expHeading) {
		String heading = deleteBatch.getConfrimHeading();
		Assert.assertEquals(heading, expHeading);
		Assert.assertTrue(deleteBatch.verifyYesNoButtonPresent());
	}

	@Given("Admin is on the batch confirm popup page SB")
	public void admin_is_on_the_batch_confirm_popup_page() {
	    deleteBatch.clicktheOption(DriverFactory.getDriver(), deleteBatch.getdeleteIcon());
	}

	@When("Admin clicks on the delete icon and clicks the Yes button SB")
	public void admin_clicks_on_the_delete_icon_and_clicks_the_yes_button() {
		deleteBatch.clicktheOption(DriverFactory.getDriver(), deleteBatch.getdeleteIcon());
	    deleteBatch.clicktheOption(DriverFactory.getDriver(), deleteBatch.getYesButton());
	}

	@Then("Admin should see a success message and the batch should be deleted SB")
	public void admin_should_see_a_success_message_and_the_batch_should_be_deleted() {
	    Assert.assertTrue(deleteBatch.validateSucessMessage().contains("Successful"));
	}

	@When("Admin clicks on the delete icon and clicks the No button SB")
	public void admin_clicks_on_the_delete_icon_and_clicks_the_no_button() {
		deleteBatch.clicktheOption(DriverFactory.getDriver(), deleteBatch.getdeleteIcon());
	    deleteBatch.clicktheOption(DriverFactory.getDriver(), deleteBatch.getNoButton());
	}

	@Then("Admin should see the alert box close and the batch should not be deleted SB")
	public void admin_should_see_the_alert_box_close_and_the_batch_should_not_be_deleted() {
	    deleteBatch.verifyBatchDeleteWindowClosed();
	}

	@When("Admin clicks on the delete icon and clicks on the close icon SB")
	public void admin_clicks_on_the_close_icon() {
		deleteBatch.clicktheOption(DriverFactory.getDriver(), deleteBatch.getdeleteIcon());
	    deleteBatch.clicktheOption(DriverFactory.getDriver(), deleteBatch.getClose());
	}

	@Then("Admin should see the alert box close SB")
	public void admin_should_see_the_alert_box_close() {
	    deleteBatch.verifyBatchDeleteWindowClosed();
	}

	@When("Admin selects a row using the checkbox and clicks the delete icon under the Manage Batch header SB")
	public void admin_selects_a_row_using_the_checkbox_and_clicks_the_delete_icon_under_the_manage_batch_header() {
	   deleteBatch.singleRowSelect();
	   deleteBatch.clicktheOption(DriverFactory.getDriver(), deleteBatch.getdeleteIcon());
		deleteBatch.clicktheOption(DriverFactory.getDriver(), deleteBatch.getYesButton());
	}

	@Then("The respective row in the table should be deleted SB")
	public void the_respective_row_in_the_table_should_be_deleted() {
		Assert.assertTrue(deleteBatch.validateSucessMessage().contains("Successful"));
	}

	@When("Admin selects multiple rows using checkboxes and clicks the delete icon under the Manage Batch header SB")
	public void admin_selects_multiple_rows_using_checkboxes_and_clicks_the_delete_icon_under_the_manage_batch_header() {
	    deleteBatch.multipleDeleteBatch();
	}

	@Then("The respective rows in the table should be deleted SB")
	public void the_respective_rows_in_the_table_should_be_deleted() {
		Assert.assertTrue(deleteBatch.validateSucessMessage().contains("Successful"));
	}

}
