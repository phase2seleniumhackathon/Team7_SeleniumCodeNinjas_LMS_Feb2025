Feature: Batch Module Validations

Background: 
	Given Admin gives the correct LMS portal URL
	When Admin enter valid data in all field and clicks login button
	Then Admin should land on home page

#BatchPage3	
#	Scenario: Verify Admin Navigate to Batch page successfully
#	When Admin Clicks on the Batch menu from the header
#	Then Admin should be in the Manage Batch Page
#
#BatchPage4	
	Scenario: Validate "Title" in Batch Page
	When Admin Clicks on the Batch menu from the header
	Then Admin should see the "LMS" TitleAdmin should be in the Manage Batch Page
	
#BatchPage5
#	Scenario: Validate "Heading" in Batch Page
#	When Admin Clicks on the Batch menu from the header
#	Then Admin should see the "Manage Batch" Heading
#	
#BatchPage6
#	Scenario: Validate disabled "Delete Icon" under the header in the Batch Page
#	When Admin Clicks on the Batch menu from the header
#	Then Admin should see the disabled "Delete Icon" under the header
#
#BatchPage7
#	Scenario: Validate pagination in the Batch Page
#	When Admin Clicks on the Batch menu from the header
#	Then Admin should see the enabled pagination controls under the data table
#
#BatchPage8	
#	Scenario: Validate edit icon in each data rows
#	When Admin Clicks on the Batch menu from the header
#	Then Admin should see the edit icon in each row
#
#BatchPage9	
#	Scenario: Validate delete icon in each data rows   
#	When Admin Clicks on the Batch menu from the header
#	Then Admin should see the delete icon in each row
#
#BatchPage10	
#	Scenario: validate checkbox in each data rows
#	When Admin Clicks on the Batch menu from the header
#	Then Admin should see the checkbox in each row
#
#BatchPage11	
#	Scenario: Validate Datatable headers
#	When Admin Clicks on the Batch menu from the header
#	Then Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit/Delete
#
#BatchPage12	
#	Scenario: Validate "Checkbox" in the Datatable header row
#	When Admin Clicks on the Batch menu from the header
#	Then Admin should see the checkbox  in the datatable header row	
#
#BatchPage13	
#	Scenario: Validate "sort icon" next to all the datatable header
#	When Admin Clicks on the Batch menu from the header
#	Then Admin should see the sort icon next to all Datatable headers
#
#BatchPage14	
#	Scenario: Verify sub menu displayed in batch menu bar
#	When Admin clicks "Batch" on the navigation bar
#	Then Admin should see sub menu in menu bar as "Add New Batch"
#
#BatchPage15	
#	Scenario: Validate Admin able to click on the Add new Batch Option
#	When Validate Admin able to click on the Add new Batch Option
#	Then Admin should see the "Batch Details" pop up window
#	
#BatchPage35
#Scenario: Validate single row delete with checkbox
#When Admin clicks on the delete icon under the Manage batch header
#Then The respective row in the table should be deleted

#BatchPage36
#Scenario: Validate multiple row delete with checkbox
#When 	Admin clicks on the delete icon under the Manage batch header
#Then The respective row in the table should be deleted

#BatchPage37
#Scenario: Validate next page link
#When Admin clicks next page link on the data table
#Then Admin should see the Next enabled link

#BatchPage38
#Scenario: validate last page link
#When Admin clicks last page link on the data table
#Then Admin should see the last page link with next page link disabled on the table 

#BatchPage39
#Scenario: validate the previous page link
#When Admin clicks previous page link on the data table 
#Then Admin should see the previous page on the table

#Batch40
#Scenario: validate the first page link
#When Admin clicks first page link on the data table
#Then Admin should see the very first page on the data table

#Batch41
#Scenario: validate search box functionality
#When Admin enters the batch name in the search text box
#Then Admin should see the filtered batches in the data table

#Batch42
Scenario: Validate logout option in the header is visible and enabled from the batch page
When Admin clicks on the logout button
Then Admin should see the "login" screen Page

	
	
	
	