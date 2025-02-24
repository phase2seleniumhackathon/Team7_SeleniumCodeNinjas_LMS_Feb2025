Feature: Batch Module Validations

Background: 
	Given Admin gives the correct LMS portal URL
	When Admin enter valid data in all field and clicks login button
	Then Admin should land on home page

#BatchPage3	
	Scenario: Verify Admin Navigate to Batch page successfully
	When Admin Clicks on the Batch menu from the header SB
	Then Admin should be in the Manage Batch Page SB

#BatchPage4	
	Scenario: Validate "Title" in Batch Page
	When Admin Clicks on the Batch menu from the header SB
	Then Admin should see the "LMS" TitleAdmin should be in the Manage Batch Page SB
	
#BatchPage5
	Scenario: Validate "Heading" in Batch Page
	When Admin Clicks on the Batch menu from the header SB
	Then Admin should see the "Manage Batch" Heading SB
	
#BatchPage6
	Scenario: Validate disabled "Delete Icon" under the header in the Batch Page
	When Admin Clicks on the Batch menu from the header SB
	Then Admin should see the disabled "Delete Icon" under the header SB

#BatchPage7
	Scenario: Validate pagination in the Batch Page
	When Admin Clicks on the Batch menu from the header SB
	Then Admin should see the enabled pagination controls under the data table SB

#BatchPage8	
	Scenario: Validate edit icon in each data rows
	When Admin Clicks on the Batch menu from the header SB
	Then Admin should see the edit icon in each row SB

#BatchPage9	
	Scenario: Validate delete icon in each data rows   
	When Admin Clicks on the Batch menu from the header SB
	Then Admin should see the delete icon in each row SB

#BatchPage10	
	Scenario: validate checkbox in each data rows
	When Admin Clicks on the Batch menu from the header SB
	Then Admin should see the checkbox in each row SB

#BatchPage11	
	Scenario: Validate Datatable headers
	When Admin Clicks on the Batch menu from the header SB
	Then Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit/Delete SB

#BatchPage12	
	Scenario: Validate "Checkbox" in the Datatable header row
	When Admin Clicks on the Batch menu from the header SB
	Then Admin should see the checkbox  in the datatable header row SB

#BatchPage13	
	Scenario: Validate "sort icon" next to all the datatable header
	When Admin Clicks on the Batch menu from the header SB
	Then Admin should see the sort icon next to all Datatable headers SB

#BatchPage14	
	Scenario: Verify sub menu displayed in batch menu bar
	When Admin clicks "Batch" on the navigation bar SB
	Then Admin should see sub menu in menu bar as "Add New Batch" SB

#BatchPage15	
	Scenario: Validate Admin able to click on the Add new Batch Option
	When Validate Admin able to click on the Add new Batch Option SB
	Then Admin should see the "Batch Details" pop up window SB

#BatchPage37
Scenario: Validate next page link
Given Admin Clicks on the Batch menu from the header SB
When Admin clicks next page link on the data table SB
Then Admin should see the Next enabled link SB

#BatchPage38
Scenario: validate last page link
Given Admin Clicks on the Batch menu from the header SB
When Admin clicks last page link on the data table SB
Then Admin should see the last page link with next page link disabled on the table SB

#BatchPage39
Scenario: validate the previous page link
Given Admin Clicks on the Batch menu from the header SB
When Admin clicks previous page link on the data table SB
Then Admin should see the previous page on the table SB

#Batch40
Scenario: validate the first page link
Given Admin Clicks on the Batch menu from the header SB
When Admin clicks first page link on the data table SB
Then Admin should see the very first page on the data table SB

#Batch41
Scenario: validate search box functionality
Given Admin Clicks on the Batch menu from the header SB
When Admin enters the batch name in the search text box SB
Then Admin should see the filtered batches in the data table SB

#Batch42
Scenario: Validate logout option in the header is visible and enabled from the batch page
When Admin clicks on the logout button SB
Then Admin should see the "login" screen Page SB
