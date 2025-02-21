package stepDefinition;

import java.util.List;
import java.util.Map;

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


public class AddBatch_StepDef {
	private WebDriver driver;
	private AddBatch_POF addBatch = new AddBatch_POF(DriverFactory.getDriver());
	private Batch_POF batchPage = new Batch_POF(DriverFactory.getDriver());

	@Given("Admin is on the Add New Batch pop-up")
	public void admin_is_on_the_add_new_batch_pop_up() {
		batchPage.clickAddNewBatchButton();    
	}

	@Then("The pop-up should include the following fields:")
	public void the_pop_up_should_include_the_following_fields(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		    List<Map<String, String>> fields = dataTable.asMaps(String.class, String.class);
		    
		    for (Map<String, String> field : fields) {
		        String fieldName = field.get("Field Name");
		        String fieldType = field.get("Field Type");

		        // Identify the locator dynamically based on field name and type
		        By locator = null;

		        switch (fieldName) {
		            case "Batch Name":
		                locator = null; // Locator for Batch Name text box
		                break;
		            case "Number of Classes":
		                locator = By.xpath("//input[@id='numClasses']"); // Locator for Number of Classes text box
		                break;
		            case "Description":
		                locator = By.xpath("//textarea[@id='description']"); // Locator for Description text area
		                break;
		            case "Program Name":
		                locator = By.xpath("//select[@id='programName']"); // Locator for Program Name dropdown
		                break;
		            case "Status":
		                locator = By.xpath("//input[@name='status']"); // Locator for Status radio buttons
		                break;
		            default:
		                throw new IllegalArgumentException("Unknown field name: " + fieldName);
		        }

		        // Verify field existence based on the determined locator
		        WebElement element = driver.findElement(locator);
		        Assert.assertTrue(element.isDisplayed(), fieldName + " is not displayed as expected.");
		    }
		}


	@Given("Admin is on the Batch Details Pop-Up Window")
	public void admin_is_on_the_batch_details_pop_up_window() {
	    
	}

	@When("Admin selects a program name from the dropdown")
	public void admin_selects_a_program_name_from_the_dropdown() {
	   
	}

	@Then("Admin should see the selected program name in the batch name prefix box")
	public void admin_should_see_the_selected_program_name_in_the_batch_name_prefix_box() {
	   
	}

	@When("Admin enters alphabets in the batch name suffix box")
	public void admin_enters_alphabets_in_the_batch_name_suffix_box() {
	  
	}

	@Then("Admin should see an error message below the respective text box")
	public void admin_should_see_an_error_message_below_the_respective_text_box() {
	    
	}

	@When("Admin tries to enter alphabets in the batch name prefix box")
	public void admin_tries_to_enter_alphabets_in_the_batch_name_prefix_box() {
	    
	}

	@Then("Admin should see an empty text box")
	public void admin_should_see_an_empty_text_box() {
	    
	}

	@When("Admin enters data only into mandatory fields and clicks the save button")
	public void admin_enters_data_only_into_mandatory_fields_and_clicks_the_save_button() {
	    
	}

	@Then("Admin should see a success message")
	public void admin_should_see_a_success_message() {
	    
	}

	@When("Admin leaves one of the mandatory fields blank")
	public void admin_leaves_one_of_the_mandatory_fields_blank() {
	  
	}

	@Then("Admin should see an error message for the respective field")
	public void admin_should_see_an_error_message_for_the_respective_field() {
	  
	}

	@When("Admin enters valid data into all mandatory fields and clicks the save button")
	public void admin_enters_valid_data_into_all_mandatory_fields_and_clicks_the_save_button() {
	    
	}

	@When("Admin enters valid data into all mandatory fields and clicks the cancel button")
	public void admin_enters_valid_data_into_all_mandatory_fields_and_clicks_the_cancel_button() {
	    
	}

	@Then("The batch details pop-up should close without creating any batch")
	public void the_batch_details_pop_up_should_close_without_creating_any_batch() {
	    
	}

	@When("Admin clicks the close icon")
	public void admin_clicks_the_close_icon() {
	    
	}

	@Then("The batch details pop-up should close")
	public void the_batch_details_pop_up_should_close() {
	   
	}
	
}
