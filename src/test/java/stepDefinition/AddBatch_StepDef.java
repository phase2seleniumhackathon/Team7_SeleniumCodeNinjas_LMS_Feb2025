package stepDefinition;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddBatch_POF;
import pageObjects.Batch_POF;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.ExcelReaderShami;


public class AddBatch_StepDef {
	private WebDriver driver;
	private AddBatch_POF addBatch = new AddBatch_POF(DriverFactory.getDriver());
	private Batch_POF batchPage = new Batch_POF(DriverFactory.getDriver());
	ExcelReaderShami reader= new ExcelReaderShami();

	@Given("Admin is on the Add New Batch pop-up SB")
	public void admin_is_on_the_add_new_batch_pop_up() {
		batchPage.clickAddNewBatchButton();    
	}
	@Then("The pop-up should include the following fields {string} and respective {string} SB")
	public void the_pop_up_should_include_the_following_fields_and_respective(String fieldName, String fieldType) {
		WebElement field = null;
	    String actualFieldType = "";

	    switch (fieldName) {
	        case " Batch Name            ":
	            field = (WebElement) addBatch.getBatchNameSuffic();
	            actualFieldType = field.getAttribute("type"); // Should return "text" for text boxes
	            System.out.println(actualFieldType);
	            Assert.assertEquals("text", actualFieldType);
	            break;

	        case " Number of Classes     ":
	            field = (WebElement) addBatch.getNoOfClasses();
	            actualFieldType = field.getAttribute("type"); // Should return "text"
	            Assert.assertEquals("number", actualFieldType);
	            break;

	        case " Description           ":
	            field = (WebElement) addBatch.getBatchDesciption();
	            actualFieldType = field.getAttribute("type"); // Should return "text"
	            Assert.assertEquals("text", actualFieldType);
	            break;

	        case " Program Name          ":
	            field = (WebElement) addBatch.getProgramName();
	            actualFieldType = field.getAttribute("aria-haspopup"); // Should return "select" for dropdowns
	            Assert.assertEquals("listbox", actualFieldType);
	            break;

	        case " Status                ":
	            field = (WebElement) addBatch.getActiveStatus();
	            actualFieldType = field.getAttribute("type"); // Should return "radio"
	            Assert.assertEquals("radio", actualFieldType);
	            break;
	    }

//	    Assert.assertTrue(field.isDisplayed()); // Verify field is visible
	}

	@Given("Admin is on the Batch Details Pop-Up SB")
	public void admin_is_on_the_batch_details_pop_up() {
		batchPage.clickAddNewBatchButton();    
	}
	
	@When("Admin selects a program name from the dropdown SB")
	public void admin_selects_a_program_name_from_the_dropdown() {
	   addBatch.selectProgramName();
	}

	@Then("Admin should see the selected program name in the batch name prefix box SB")
	public void admin_should_see_the_selected_program_name_in_the_batch_name_prefix_box() {
	   addBatch.isProgramAndBatchPrefixSame();
	}
	

	@When("Admin enters alphabets in the batch name suffix box SB")
	public void admin_enters_alphabets_in_the_batch_name_suffix_box() {
	  addBatch.enterText("wrong",addBatch.getBatchNameSuffic());
	}

	@Then("Admin should see an error message below the respective text box SB")
	public void admin_should_see_an_error_message_below_the_respective_text_box() {
	   Assert.assertTrue(addBatch.getErrorMessage());
	}

	@When("Admin tries to enter alphabets in the batch name prefix box SB")
	public void admin_tries_to_enter_alphabets_in_the_batch_name_prefix_box() {
	    addBatch.enterText("TEST", addBatch.getBatchNamePrefix());
	}

	@Then("Admin should see an empty text box SB")
	public void admin_should_see_an_empty_text_box() {
	    addBatch.isEmpty();
	}

	@When("Admin enters data only into mandatory fields and clicks the save button SB")
	public void admin_enters_data_only_into_mandatory_fields_and_clicks_the_save_button() {
		   
	}
	@When("Admin enters data only into mandatory fields from {string} and <row number> SB")
	public void admin_enters_data_only_into_mandatory_fields_from_and_row_number(String sheetname) {
		String filePath = new File("src/test/resources/TestData/Team7-TestData.xlsx").getAbsolutePath();
		int rownumber =0;
		System.out.println(filePath);
		   List<Map<String,String>> testData = reader.getData(filePath, sheetname);
		   String programName = testData.get(rownumber).get("ProgramName");
		   String batchName = testData.get(rownumber).get("BatchName");
		   String batchDesc = testData.get(rownumber).get("Description");
		   String status = testData.get(rownumber).get("Status");
		   String noOfClasses = testData.get(rownumber).get("NumberOfClasses");
		   
		   addBatch.selectProgramName(programName);
		   addBatch.enterBatchName(batchName);
		   addBatch.enterBatchDesc(batchDesc);
		   addBatch.selectBatchStatus(status);
		   addBatch.selectNumberOfClasses(noOfClasses);
		   
	}

	@When("clicks the save button SB")
	public void clicks_the_save_button() {
	    addBatch.clickSaveButton();
	}

	@Then("Admin should see a successful message SB")
	public void admin_should_see_a_successful_message() {
	    Assert.assertTrue(addBatch.validateSucessMessage(),"Success Msg not displayed");
	}

	@When("Admin leaves one of the mandatory fields blank SB")
	public void admin_leaves_one_of_the_mandatory_fields_blank() {
	  addBatch.enterValidValueswithOneBlank();
	}

	@Then("Admin should see an error message for the respective field SB")
	public void admin_should_see_an_error_message_for_the_respective_field() {
		addBatch.clickSaveButton();
	  boolean msg= addBatch.getErrorMessage();
	 Assert.assertTrue(msg,"error msg not displayed");
	}

	@When("Admin enters data only into mandatory fields from {string} and <row number> and clicks the save button SB")
	public void admin_enters_data_only_into_mandatory_fields_from_and_row_number_and_clicks_the_save_button (String sheetname){
		String filePath = new File("src/test/resources/TestData/Team7-TestData.xlsx").getAbsolutePath();
		int rownumber =0;
		System.out.println(filePath);
		   List<Map<String,String>> testData = reader.getData(filePath, sheetname);
		   String programName = testData.get(rownumber).get("ProgramName");
		   String batchName = testData.get(rownumber).get("BatchName");
		   String batchDesc = testData.get(rownumber).get("Description");
		   String status = testData.get(rownumber).get("Status");
		   String noOfClasses = testData.get(rownumber).get("NumberOfClasses");
		   
		   addBatch.selectProgramName(programName);
		   addBatch.enterBatchName(batchName);
		   addBatch.enterBatchDesc(batchDesc);
		   addBatch.selectBatchStatus(status);
		   addBatch.selectNumberOfClasses(noOfClasses);
		   
		   addBatch.clickSaveButton();
		   
	}

	@When("Admin enters valid data into all mandatory fields and clicks the cancel button SB")
	public void admin_enters_valid_data_into_all_mandatory_fields_and_clicks_the_cancel_button() {
	    addBatch.enterBatchName(ConfigReader.getBatchName());
	    addBatch.enterBatchDesc(ConfigReader.getBatchDesc());
	    
	    addBatch.selectNumberOfClasses(ConfigReader.getNoOfClasses());
	    addBatch.selectBatchStatus(ConfigReader.getBatchStatus());
	    addBatch.selectProgramName("Playwright");
	    //clicking cancel button
	    addBatch.clickCancelButton();
	}
	

	@Then("The batch details pop-up should close without creating any batch SB")
	public void the_batch_details_pop_up_should_close_without_creating_any_batch() {
	    addBatch.verifyAddNewBatchDetailsWindowClosed();
	}

	@When("Admin clicks the close icon SB")
	public void admin_clicks_the_close_icon() {
	    addBatch.clickClose();
	}

	@Then("The batch details pop-up should close SB")
	public void the_batch_details_pop_up_should_close() {
	   addBatch.verifyAddNewBatchDetailsWindowClosed();
	}
	
}
