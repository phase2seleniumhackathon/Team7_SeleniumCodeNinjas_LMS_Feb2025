Feature: Add new class popup

Background: 
Given Admin Is on the Manage class page after login ML

@class12
Scenario Outline: Check if class is created when only mandatory fields are entered with valid data
Given Admin is on the Class Popup window ML
When Admin enters mandatory fields in the form and clicks on save button from "<sheetName>" with scenario name "<scenarioName>" in class module ML
Then Admin gets message Class added Successfully from "<sheetName>" with scenario name "<scenarioName>" in class module ML

 Examples: 
      | sheetName | scenarioName                    |
      | Class     | addClassWithOnlyMandatoryFields |
    
     

@class13
Scenario: Check no classes value added when selecting class dates

When Admin selects class date in date picker ML
Then Admin should see no of class value is added automatically ML

@class14
Scenario: Check weekend dates are disabled in calendar

When Admin clicks date picker ML
Then Admin should see weekends dates are disabled to select ML

@class15
Scenario: Check if class is created when only optional fields are entered with valid data

When Admin skips to add value in mandatory field and enter only the optional field ML
Then Admin should see error message below the test field and the field will be highlighted in red color ML

                 

@class16
Scenario: check if class is created when invalid data is entered in all of the fields 

When Admin enters invalid data in all of the  fields in the form and clicks on save button ML
Then Admin gets error message and class is not created ML

@class17
Scenario: Empty form submission

When Admin clicks on save button without entering data ML
Then class won't be created and Admin gets error message ML. 

@class18
Scenario: Validate Cancel/Close(X) icon on class Details form 

When Admin clicks Close(X) Icon on Admin Details form ML
Then Class Details popup window should be closed without saving ML

@class19
Scenario: Validate Save button on class Details form

When Admin clicks save button ML
Then Admin can see the class details popup closed and adding new class ML
#
