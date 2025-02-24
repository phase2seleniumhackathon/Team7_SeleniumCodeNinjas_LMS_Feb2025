Feature: Validate Edit Batch Functionality

Background: 
	Given Admin gives the correct LMS portal URL
	When Admin enter valid data in all field and clicks login button
	Then Admin should land on home page

  Scenario: Validate Edit icon feature in any row
    Given Admin is on the Batch page SB
    When Admin clicks the edit icon in any row SB
    Then Admin should see the Batch details pop-up window SB

  Scenario: Validate Program Name value is disabled for editing
    Given Admin is on the Batch page SB
    When Admin clicks the edit icon in any row SB
    Then Admin should see the Program Name field is disabled for editing SB

  Scenario: Validate Batch Name value is disabled for editing
    Given Admin is on the Batch page SB
    When Admin clicks the edit icon in any row SB
    Then Admin should see the Batch Name field is disabled for editing SB

  Scenario: Validate editing Description and Number of Classes fields with invalid data
    Given Admin is on the Batch Details Page SB
    When Admin updates Description or Number of Classes with invalid data and clicks the save button SB
    Then Admin should see an error message under the respective field SB

  Scenario: Validate save button in Batch Details pop-up
    Given Admin is on the Batch Details Page SB
    When Admin enters valid data in all the mandatory fields and clicks the save button SB
    Then Admin should see a success message for editing the batch SB

   Scenario: Validate cancel button in Batch Details pop-up
    Given Admin is on the Batch Details Page SB
    When Admin enters valid data in all the mandatory fields and clicks the cancel button SB
    Then Admin should see the Batch Details pop-up close without editing the batch SB