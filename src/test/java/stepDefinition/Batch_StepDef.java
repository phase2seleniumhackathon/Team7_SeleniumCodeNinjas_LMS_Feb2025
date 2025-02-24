package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.Batch_POF;

public class Batch_StepDef {
	private WebDriver driver;
	private Batch_POF batchPage = new Batch_POF(DriverFactory.getDriver());
	

	@When("Admin Clicks on the Batch menu from the header SB")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
	    batchPage.clickBatchFromHeader();
	}

	@Then("Admin should be in the Manage Batch Page SB")
	public void admin_should_be_in_the_manage_batch_page() {
	   String currentURL = batchPage.getCurrentUrl();
	   Assert.assertEquals( "https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/batch", currentURL);
	}

	@Then("Admin should see the {string} TitleAdmin should be in the Manage Batch Page SB")
	public void admin_should_see_the_title_admin_should_be_in_the_manage_batch_page(String title) {
	   String currentTitle = batchPage.getTitle();
	   System.out.println(currentTitle);
	   Assert.assertEquals(title, currentTitle);
	}

	@Then("Admin should see the {string} Heading SB")
	public void admin_should_see_the_heading(String heading) {
	   String currentHeading =batchPage.BatchHeading().getText();
	   Assert.assertEquals(heading, currentHeading);
	}

	@Then("Admin should see the disabled {string} under the header SB")
	public void admin_should_see_the_disabled_under_the_header(String string) {
	    boolean value = batchPage.isButtonEnabled();
	    if (!value){
	    	System.out.println("Button is disabled");
	    }
	    else 
	    	System.out.println("Button is enabled");
	    
	}

	@Then("Admin should see the enabled pagination controls under the data table SB")
	public void admin_should_see_the_enabled_pagination_controls_under_the_data_table() {
	 batchPage.scrollUntilVisibleWithWait(DriverFactory.getDriver(), batchPage.getPaginationPanel());
	batchPage.isElementDisplayed(DriverFactory.getDriver(), batchPage.getPaginationPanel());
	}

	@Then("Admin should see the edit icon in each row SB")
	public void admin_should_see_the_edit_icon_in_each_row() {
	    batchPage.areAllEditOrDeleteOrCheckBoxOrSortIconDisplayed(DriverFactory.getDriver(), batchPage.allEditButtons());
	}

	@Then("Admin should see the delete icon in each row SB")
	public void admin_should_see_the_delete_icon_in_each_row() {
	    batchPage.areAllEditOrDeleteOrCheckBoxOrSortIconDisplayed(DriverFactory.getDriver(), batchPage.allDeleteButtons());
	}

	@Then("Admin should see the checkbox in each row SB")
	public void admin_should_see_the_checkbox_in_each_row() {
	    batchPage.areAllEditOrDeleteOrCheckBoxOrSortIconDisplayed(DriverFactory.getDriver(), batchPage.allCheckBoxes());	    
	}

	@Then("Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit\\/Delete SB")
	public void admin_should_see_the_datatable_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {
	    batchPage.isElementDisplayed(DriverFactory.getDriver(), batchPage.getBatchName());
	    batchPage.isElementDisplayed(DriverFactory.getDriver(), batchPage.getBatchDesc());
	    batchPage.isElementDisplayed(DriverFactory.getDriver(), batchPage.getBatchStatus());
	    batchPage.isElementDisplayed(DriverFactory.getDriver(), batchPage.getEditOrDeleteHeader());
	    batchPage.isElementDisplayed(DriverFactory.getDriver(), batchPage.getNoOfClasses());
	    batchPage.isElementDisplayed(DriverFactory.getDriver(), batchPage.getProgramName());
	}

	@Then("Admin should see the checkbox  in the datatable header row SB")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row() {
		batchPage.isElementDisplayed(DriverFactory.getDriver(), batchPage.getCheckBoxHeader());
	}

	@Then("Admin should see the sort icon next to all Datatable headers SB")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {
	    batchPage.areAllEditOrDeleteOrCheckBoxOrSortIconDisplayed(DriverFactory.getDriver(), batchPage.getAllSortIcons());
	}

	@When("Admin clicks {string} on the navigation bar SB")
	public void admin_clicks_on_the_navigation_bar(String string) {
	   batchPage.clickBatchFromHeader();
	}

	@Then("Admin should see sub menu in menu bar as {string} SB")
	public void admin_should_see_sub_menu_in_menu_bar_as(String string) {
		
	    batchPage.isElementDisplayed(DriverFactory.getDriver(), batchPage.getMenuAddNewBatchButton());
	}

	@When("Validate Admin able to click on the Add new Batch Option SB")
	public void validate_admin_able_to_click_on_the_add_new_batch_option() {
	   batchPage.clickAddNewBatchButton();
	}

	@Then("Admin should see the {string} pop up window SB")
	public void admin_should_see_the_batch_details_pop_up_window(String string) throws InterruptedException {
	    batchPage.verifyAddNewBatchDetailsWindowOpened(string);
	}
	

	@When("Admin clicks next page link on the data table SB")
	public void admin_clicks_next_page_link_on_the_data_table() {
	  batchPage.clicktheOption(DriverFactory.getDriver(), batchPage.getNextLink());
	}

	@Then("Admin should see the Next enabled link SB")
	public void admin_should_see_the_next_enabled_link() {
	    Assert.assertTrue(batchPage.isElementEnabled(DriverFactory.getDriver(), batchPage.getNextLink()));
	}

	@When("Admin clicks last page link on the data table SB")
	public void admin_clicks_last_page_link_on_the_data_table() {
	  // batchPage.clicktheOption(DriverFactory.getDriver(), batchPage.getlastPage());
		batchPage.clickLast();
	}

	@Then("Admin should see the last page link with next page link disabled on the table SB")
	public void admin_should_see_the_last_page_link_with_next_page_link_disabled_on_the_table() {
	    //Assert.assertFalse(batchPage.isElementEnabled(DriverFactory.getDriver(), batchPage.getNextLink()),"Next page button should be disabled but it is enable");
		boolean bool = batchPage.isDisabled();
		System.out.println(bool);
		Assert.assertFalse(bool);
	}

	@When("Admin clicks previous page link on the data table SB")
	public void admin_clicks_previous_page_link_on_the_data_table() {
	    batchPage.clicktheOption(DriverFactory.getDriver(), batchPage.getpreviousLink());
	}

	@Then("Admin should see the previous page on the table SB")
	public void admin_should_see_the_previous_page_on_the_table() {
	    
	}

	@When("Admin clicks first page link on the data table SB")
	public void admin_clicks_first_page_link_on_the_data_table() {
	   batchPage.clicktheOption(DriverFactory.getDriver(), batchPage.getFirstPage());
	}

	@Then("Admin should see the very first page on the data table SB")
	public void admin_should_see_the_very_first_page_on_the_data_table() {
		boolean bool = batchPage.isDisabled();
		System.out.println(bool);
		Assert.assertFalse(bool);
		Assert.assertFalse(batchPage.isDisabled());
	}

	@When("Admin enters the batch name in the search text box SB")
	public void admin_enters_the_batch_name_in_the_search_text_box() {
	   batchPage.enterSearchText();
	}

	@Then("Admin should see the filtered batches in the data table SB")
	public void admin_should_see_the_filtered_batches_in_the_data_table() {
	    Assert.assertTrue(batchPage.searchResultsValidate());
	}

	@When("Admin clicks on the logout button SB")
	public void admin_clicks_on_the_logout_button() {
	  batchPage.isElementDisplayed(DriverFactory.getDriver(), batchPage.getlogout());
	  batchPage.clickLogout();
	}

	@Then("Admin should see the {string} screen Page SB")
	public void admin_should_see_the_login_screen_page(String expectedURL) {
	    String actualURL = batchPage.getCurrentUrl();
	    System.out.println(actualURL);
	    System.out.println(expectedURL);
	    Assert.assertTrue(actualURL.endsWith(expectedURL));
	}

}
