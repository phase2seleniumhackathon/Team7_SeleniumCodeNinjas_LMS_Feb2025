Feature: Validate Delete Functionality in Batch Page

Background: 
	Given Admin gives the correct LMS portal URL SR
	When Admin enter valid data in all field and clicks login button SR
	Then Admin should land on home page SR

  Scenario: Validate Delete icon on any row
    Given Admin is on the Batch page SB
    When Admin clicks the delete icon on any row SB
    Then Admin should see the "Confirm" alert box with Yes and No buttons SB

  Scenario: Validate Yes button on the confirm alert box
    Given Admin is on the Batch page SB
    When Admin clicks on the delete icon and clicks the Yes button SB
    Then Admin should see a success message and the batch should be deleted SB

  Scenario: Validate No button on the confirm alert box
    Given Admin is on the Batch page SB
    When Admin clicks on the delete icon and clicks the No button SB
    Then Admin should see the alert box close and the batch should not be deleted SB

  Scenario: Validate Close icon on the alert box
    Given Admin is on the Batch page SB
    When Admin clicks on the delete icon and clicks on the close icon SB
    Then Admin should see the alert box close SB

  Scenario: Validate single row delete with checkbox
    Given Admin is on the Batch page SB
    When Admin selects a row using the checkbox and clicks the delete icon under the Manage Batch header SB
    Then The respective row in the table should be deleted SB

  Scenario: Validate multiple row delete with checkbox
    Given Admin is on the Batch page SB
    When Admin selects multiple rows using checkboxes and clicks the delete icon under the Manage Batch header SB
    Then The respective rows in the table should be deleted SB
