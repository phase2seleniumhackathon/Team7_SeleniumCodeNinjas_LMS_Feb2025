package stepDefinition;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Program_POF;

public class Program_ManageProgramPagevalidationStepDef {
	private WebDriver driver;
	private Program_POF ProgramPage;

	public Program_ManageProgramPagevalidationStepDef() {
		this.driver = DriverFactory.getDriver();
		this.ProgramPage = new Program_POF(driver);
	}
//Background

	@Given("Admin is on the Program page_SS")
	public void admin_is_on_the_program_page_SS() {
		ProgramPage.clickProgramLink();
		ProgramPage.isProgramPageDisplayed();
	}

//@ProgramPage1
	@When("Admin clicks {string} on the navigation bar SS")
	public void admin_clicks_on_the_navigation_bar_SS(String string) {

		ProgramPage.clickProgramLink();
	}

	@Then("Admin should be navigated to Program page SS")
	public void admin_should_be_navigated_to_program_page_SS() {

		ProgramPage.isProgramPageDisplayed();
	}

// @ProgramPage2
	@Then("Admin should see Logout in menu bar SS")
	public void admin_should_see_logout_in_menu_bar_SS() {

		ProgramPage.isProgramLogoutisDisplayed();
	}

// @ProgramPage3
	@Then("Admin should see the heading {string} SS")
	public void admin_should_see_the_heading_SS(String expectedHeading) throws InterruptedException {

		Thread.sleep(2000);
		boolean isHeadingCorrect = ProgramPage.isLMSHeadingCorrect(expectedHeading);
		Assert.assertTrue("Heading does not match!", isHeadingCorrect);
	}

//
// //@ProgramPage4
//	//@Then("admin should see the page names as in order {string},{string},{string},{string}")
//	public void admin_should_see_the_page_names_as_in_order(String page1, String page2, String page3, String page4) {
//		List<WebElement> pageNames = ProgramPage.getPageNames();
//       String[] expectedPageNames= {page1,page2,page3,page4};
//       String[] actualPageNames = new String[pageNames.size()];
//       
//       for (int i = 0; i < pageNames.size(); i++) {
//           actualPageNames[i] = pageNames.get(i).getText().trim();
//           Assert.assertArrayEquals("Page names do not match the expected order!", expectedPageNames, actualPageNames);
//       }
//		
//	}
//@ProgramPage5
	@Then("Admin should see sub menu in menu bar as {string} SS")
	public void admin_should_see_sub_menu_in_menu_bar_as_SS(String string) {

		ProgramPage.isMenuAddNewProgramisDisplayed();
	}
//
//@PProgramPage6
//
// @ProgramPage7	
//@Then("Admin should be able to see program name {string}, description {string}, and status {string}")
//public void admin_should_able_to_see_program_name_description_and_status_for_each_program(String expectedProgramName, String expectedDescription, String expectedStatus) {
//		    List<WebElement> ProgramNames= ProgramPage.getProgramNames();
//		    List<WebElement> ProgramDescription=ProgramPage.getProgramDescription();
//		    List<WebElement> ProgramStatus=ProgramPage.getProgramStatus();
//		    
//		    for (int i=0;i< ProgramNames.size();i++){
//		    	String actualprogramname= ProgramNames.get(i).getText().trim();
//		    	String actualprogramdescription=ProgramDescription.get(i).getText().trim();
//		    	String actualprogramstatus=ProgramStatus.get(i).getText().trim();
//		    	
//		    	Assert.assertEquals(expectedProgramName, actualprogramname,"Program name does not match");
//		    	Assert.assertEquals(expectedDescription, actualprogramdescription,"Program description does not match");
//		    	Assert.assertEquals(expectedStatus,actualprogramstatus, "Program Status does not match");
//		    }
//	

//@ProgramPage8
	@Then("Admin should see a Delete button in left top is disabled SS")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled_SS() {

	}

//
// @ProgramPage9
	@Then("Admin should see Search bar with text as {string} SS")
	public void admin_should_see_search_bar_with_text_as_SS(String expectedText) {

		boolean searchTextIsDisplayed = ProgramPage.isSearchBarDisplayed();
		Assert.assertTrue("Search bar is not displayed!", searchTextIsDisplayed);
	}

//@@ProgramPage10
//	@When("Admin clicks {string} on the navigation barr SS")
//	public void admin_clicks_on_the_navigation_barr_SS(String string) {
//
//	}
//
//	@Then("Admin should see data table with column header on the Manage Program Page as   Program Name, Program Description, Program Status, Edit\\/Delete SS")
//	public void admin_should_see_data_table_with_column_header_on_the_manage_program_page_as_program_name_program_description_program_status_edit_delete_SS() {
//
//	}

//@ProgramPage11
	@Then("Admin should see checkbox default state as unchecked beside Program Name column header SS")
	public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header_SS() {

		ProgramPage.ischeckboxselected();
	}

//
//  @ProgramPage12
//	@Then("Admin should see check box default state as unchecked on the left side in all rows against program name SS")
//	public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name_SS() {
//
//	}

//  @ProgramPage13
	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete SS")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete_SS() {

		ProgramPage.isSortArrowHeaderDisplayed();
	}

// @ProgramPage14
	@Then("Admin should see the Edit and Delete buttons on each row of the data table SS")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table_SS() {

		ProgramPage.isEditDeleteTextDisplayed();
	}

// @ProgramPage15
//	@Then("Admin should see the text as {string} along with Pagination icon below the table SS")
//	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table_SS(String string) {
//
//	}

//@ProgramPage16
//	@Then("Admin should see the footer as {string} SS")
//	public void admin_should_see_the_footer_as_SS(String string) {

//	}

}
