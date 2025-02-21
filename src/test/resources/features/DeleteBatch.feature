Feature: Validate Delete Functionality in Batch Page

  Scenario: Validate Delete icon on any row
    Given Admin is on the Batch page
    When Admin clicks the delete icon on any row
    Then Admin should see the confirm alert box with Yes and No buttons

  Scenario: Validate Yes button on the confirm alert box
    Given Admin is on the batch confirm popup page
    When Admin clicks on the delete icon and clicks the Yes button
    Then Admin should see a success message and the batch should be deleted

  Scenario: Validate No button on the confirm alert box
    Given Admin is on the batch confirm popup page
    When Admin clicks on the delete icon and clicks the No button
    Then Admin should see the alert box close and the batch should not be deleted

  Scenario: Validate Close icon on the alert box
    Given Admin is on the batch confirm popup page
    When Admin clicks on the close icon
    Then Admin should see the alert box close

  Scenario: Validate single row delete with checkbox
    Given Admin is on the Batch page
    When Admin selects a row using the checkbox and clicks the delete icon under the Manage Batch header
    Then The respective row in the table should be deleted

  Scenario: Validate multiple row delete with checkbox
    Given Admin is on the Batch page
    When Admin selects multiple rows using checkboxes and clicks the delete icon under the Manage Batch header
    Then The respective rows in the table should be deleted
