Feature: Validate Add New Batch Details Pop-Up

  Background:
    Given Admin gives the correct LMS portal URL
	  Given Admin enter valid data in all field and clicks login button
	  When  Admin is on the Add New Batch pop-up SB
	
	#Batch16
  @ValidateFields
	  Scenario Outline: Validate all the fields exist in the Add New Batch pop-up 
	#    Given Admin is on the Add New Batch pop-up
	    Then The pop-up should include the following fields "<FieldName>" and respective "<FieldType>" SB 
	    Examples:
	      | FieldName             | FieldType |
	      | Batch Name            | Text      |
	      | Number of Classes     | Text      |
	      | Description           | Text      |
	      | Program Name          | Dropdown  |
	      | Status                | Radio     |
	
  @ValidateBatchNamePrefix
  Scenario: Validate batch name prefix with selected program name 
    When Admin selects a program name from the dropdown SB
    Then Admin should see the selected program name in the batch name prefix box SB

	#Batch18
  @ValidateBatchNameSuffix
  Scenario: Validate batch name suffix box accepts only numbers
    When Admin enters alphabets in the batch name suffix box SB
    Then Admin should see an error message below the respective text box SB

	#Batch19
  @ValidatePrefixBoxNotEditable
  Scenario: Validate batch name prefix box is not editable SB
    When Admin tries to enter alphabets in the batch name prefix box SB
    Then Admin should see an empty text box SB
	
	#Batch20
  @ValidateMandatoryFields
  Scenario Outline: Validate input data only for mandatory fields SB
    When Admin enters data only into mandatory fields from "<sheetname>" and <row number> SB
    And clicks the save button SB
    Then Admin should see a successful message SB
    Examples:
    	|sheetname|rownumber|
    	| Batch   |0        |

	#Batch21
  @ValidateMissingMandatoryFields
  Scenario: Validate missing input data for mandatory fields
    When Admin leaves one of the mandatory fields blank SB
    Then Admin should see an error message for the respective field SB

	#Batch22
  @ValidateSaveButton
  Scenario Outline: Validate save button functionality
    When Admin enters data only into mandatory fields from "<sheetname>" and <row number> and clicks the save button SB
    Then Admin should see a successful message SB
    Examples:
    |sheetname|rownumber|
   	| Batch   |0        |

	#Batch23
  @ValidateCancelButton
  Scenario: Validate cancel button functionality
    When Admin enters valid data into all mandatory fields and clicks the cancel button SB
    Then The batch details pop-up should close without creating any batch SB
#
	#Batch24
  @ValidateCloseIcon
  Scenario: Validate close icon functionality
    When Admin clicks the close icon SB
    Then The batch details pop-up should close SB
