Feature: Validate Add New Batch Details Pop-Up

  Background:
    Given Admin gives the correct LMS portal URL
	  Given Admin enter valid data in all field and clicks login button  
	  When  Admin is on the Add New Batch pop-up
	
#	#Batch16
  #@ValidateFields
  #Scenario: Validate all the fields exist in the Add New Batch pop-up
    #Given Admin is on the Add New Batch pop-up
    #Then The pop-up should include the following fields:
      #| Field Name            | Field Type    |
      #| Batch Name            | Text Box      |
      #| Number of Classes     | Text Box      |
      #| Description           | Text Box      |
      #| Program Name          | Drop Down     |
      #| Status                | RadioButton   |
#	
	#Batch17
  @ValidateBatchNamePrefix
  Scenario: Validate batch name prefix with selected program name
    Given Admin is on the Batch Details Pop-Up Window
    When Admin selects a program name from the dropdown
    Then Admin should see the selected program name in the batch name prefix box

#	#Batch18
  #@ValidateBatchNameSuffix
  #Scenario: Validate batch name suffix box accepts only numbers
    #Given Admin is on the Batch Details Pop-Up Window
    #When Admin enters alphabets in the batch name suffix box
    #Then Admin should see an error message below the respective text box
#
#	#Batch19
  #@ValidatePrefixBoxNotEditable
  #Scenario: Validate batch name prefix box is not editable
    #Given Admin is on the Batch Details Pop-Up Window
    #When Admin tries to enter alphabets in the batch name prefix box
    #Then Admin should see an empty text box
#	
#	#Batch20
  #@ValidateMandatoryFields
  #Scenario: Validate input data only for mandatory fields
    #Given Admin is on the Batch Details Pop-Up Window
    #When Admin enters data only into mandatory fields and clicks the save button
    #Then Admin should see a success message
#
#	#Batch21
  #@ValidateMissingMandatoryFields
  #Scenario: Validate missing input data for mandatory fields
    #Given Admin is on the Batch Details Pop-Up Window
    #When Admin leaves one of the mandatory fields blank
    #Then Admin should see an error message for the respective field
#
#	#Batch22
  #@ValidateSaveButton
  #Scenario: Validate save button functionality
    #Given Admin is on the Batch Details Pop-Up Window
    #When Admin enters valid data into all mandatory fields and clicks the save button
    #Then Admin should see a success message
#
#	#Batch23
  #@ValidateCancelButton
  #Scenario: Validate cancel button functionality
    #Given Admin is on the Batch Details Pop-Up Window
    #When Admin enters valid data into all mandatory fields and clicks the cancel button
    #Then The batch details pop-up should close without creating any batch
#
#	#Batch24
  #@ValidateCloseIcon
  #Scenario: Validate close icon functionality
    #Given Admin is on the Batch Details Pop-Up Window
    #When Admin clicks the close icon
    #Then The batch details pop-up should close
