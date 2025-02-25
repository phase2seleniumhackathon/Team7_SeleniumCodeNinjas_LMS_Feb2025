Feature: Add new class

Background: 
Given Admin Is on the Manage class page after login ML

@AddClass

@class10
Scenario: Validate Class Details Popup window
Given  Admin is on the Manage class page ML
When Admin clicks a add new class under the class menu bar ML.
Then Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window ML

@class11
Scenario: Validate input fields and their text boxes in Class details form 
Given  Admin is on the Manage class page ML
When Admin clicks a add new class under the class menu bar ML.
Then Admin should see few input fields and their respective text boxes in the class details window ML
