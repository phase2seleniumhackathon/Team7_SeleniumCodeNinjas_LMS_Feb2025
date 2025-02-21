Feature: Validate Edit Batch Functionality

  Scenario: Validate Edit icon feature in any row
    Given Admin is on the Batch page
    When Admin clicks the edit icon in any row
    Then Admin should see the Batch details pop-up window

  Scenario: Validate Program Name value is disabled for editing
    Given Admin is on the Batch page
    When Admin clicks the edit icon in any row
    Then Admin should see the Program Name field is disabled for editing

  Scenario: Validate Batch Name value is disabled for editing
    Given Admin is on the Batch page
    When Admin clicks the edit icon in any row
    Then Admin should see the Batch Name field is disabled for editing

  Scenario: Validate editing Description and Number of Classes fields with invalid data
    Given Admin is on the Batch Details Page
    When Admin updates Description or Number of Classes with invalid data and clicks the save button
    Then Admin should see an error message under the respective field

  Scenario: Validate save button in Batch Details pop-up
    Given Admin is on the Batch Details Page
    When Admin enters valid data in all the mandatory fields and clicks the save button
    Then Admin should see a success message for editing the batch

  Scenario: Validate cancel button in Batch Details pop-up
    Given Admin is on the Batch Details Page
    When Admin enters valid data in all the mandatory fields and clicks the cancel button
    Then Admin should see the Batch Details pop-up close without editing the batch