package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage_POF;
import utilities.ConfigReader;

public class Homepage_StepDef {
	HomePage_POF homepage = new HomePage_POF();
	
	@Given("Admin is on login Page VH")
	public void admin_is_on_login_page_vh() {
		homepage.launchpage();
	}

	@When("Admin enter valid data in all field and clicks login button VH")
	public void admin_enter_valid_data_in_all_field_and_clicks_login_button_vh() {
		homepage.enteruser();
		homepage.enterpassword();
		homepage.SelectingTheRole();
		homepage.clicklogin();;
	}

	@Then("Admin should see LMS -Learning management system as title VH")
	public void admin_should_see_lms_learning_management_system_as_title_vh() {
		 homepage.validateLMS();
	}

	@Then("LMS title should be on the top left corner of page VH")
	public void lms_title_should_be_on_the_top_left_corner_of_page_vh() {
	   homepage.validatelocationLMS();
	}

	@Then("Admin should see correct spelling in navigation bar text VH")
	public void admin_should_see_correct_spelling_in_navigation_bar_text_vh() {
	   homepage.validatehomepagespelling();
	}

	@Then("Admin should see correct spelling and space in LMS title VH")
	public void admin_should_see_correct_spelling_and_space_in_lms_title_vh() {
	   homepage.LMSspelling();
	}

	@Then("Admin should see the navigation bar text on the top right side VH")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side_vh() {
	   homepage.validatenavigationbar();
	}

//	@Then("Admin should see home in the 1st place VH")
//	public void admin_should_see_home_in_the_1st_place_vh() {
//	homepage.homefirst();
//	}
	@Then("Admin should see home in the 1st place VH")
	public void admin_should_see_home_in_the_1st_place_vh() {
	homepage.StaffDataRowsCheck();
	}
	@Then("Admin should see program in the 2nd place VH")
	public void admin_should_see_program_in_the_2nd_place_vh() {
	 homepage.programsecond();
	}

	@Then("Admin should see batch in the 3rd place VH")
	public void admin_should_see_batch_in_the_3rd_place_vh() {
	   homepage.batchthird();
	}

	@Then("Admin should see class in the 4th place VH")
	public void admin_should_see_class_in_the_4th_place_vh() {
	   homepage.classfourth();
	}

	@Then("Admin should see logout in the 5th place VH")
	public void admin_should_see_logout_in_the_5th_place_vh() {
	   homepage.logoutfifth();
	}

	@Then("Admin should see piechart VH")
	public void admin_should_see_piechart_vh() {
	    homepage.validatepiechart();
	}

	@Then("Admin should see welcome message with username and role VH")
	public void admin_should_see_welcome_message_with_username_and_role_vh() {
	    homepage.validatewelcomemsg();
	}

	@Then("Admin should see bar chart for Active and inactive user VH")
	public void admin_should_see_bar_chart_for_active_and_inactive_user_vh() {
	    homepage.validatebarchart();
	}

	@Then("Admin should see user count VH")
	public void admin_should_see_user_count_vh() {
	    homepage.validateuservalue();
	}

	@Then("Admin should see staff count VH")
	public void admin_should_see_staff_count_vh() {
	   homepage.validatestaffvalue();
	}

	@Then("Admin should see program count VH")
	public void admin_should_see_program_count_vh() {
	    homepage.validateprogramvalue();
	}

	@Then("Admin should see batch count VH")
	public void admin_should_see_batch_count_vh() {
	    homepage.validatebatchvalue();
	}

	@Then("Admin should see staff table with pagination icons VH")
	public void admin_should_see_staff_table_with_pagination_icons_vh() {
		homepage.validatestaffdataandpagination();
	}

	@Then("Admin should see {int} staff data in a page VH")
	public void admin_should_see_staff_data_in_a_page_vh(Integer int1) {
		homepage.validatestaffdata();
	}

	@Then("Admin should see previous page icon disabled VH")
	public void admin_should_see_previous_page_icon_disabled_vh() {
	   homepage.validateprviouspage();
	}

	@Then("Admin should see first page icon disabled VH")
	public void admin_should_see_first_page_icon_disabled_vh() {
	   homepage.validatefirstpage();

}
}
