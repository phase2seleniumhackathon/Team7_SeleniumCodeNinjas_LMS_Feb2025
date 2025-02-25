Feature: Class Page Validation

Background: 
Given Admin logged on the home page ML

@ClassPageValidation
@class1
Scenario: Validating the class manage page
 
Given  Admin is on the home Page after login ML
When Admin clicks the Class Navigation bar in the Header ML
Then Admin should land on the Manage class page ML

@class2
Scenario: Validating the Title in the Manage class page

When Admin clicks the Class Navigation bar in the Header ML
Then Admin should see the "LMS - Learning Management System" Title ML

@class3
Scenario: Validating the Header in the Manage class page 

When Admin clicks the Class Navigation bar in the Header ML
Then Admin should see the "Manage Class" Header ML

@class4
Scenario: Validating Search bar in class page

When Admin clicks the Class Navigation bar in the Header ML
Then Admin should see the Search Bar in Manage class page ML

@class5
Scenario: Validating the data table headers in the class page 

When Admin clicks the Class Navigation bar in the Header ML
Then Admin should see all expected column headers ML
  | Batch Name     |
  | Class Topic    |
  | Class Description    |
  | Status        |
  | Class Date    |
  | Staff Name    |
  | Edit / Delete |

@class6
Scenario: Validating the text and pagination icon in the classpage

When Admin clicks the Class Navigation bar in the Header ML
Then Admin should see the " showing x to y of  z entries" and enabled pagination controls under the data table ML

@class7
Scenario: Validate the sort icon of all the field in datatable

When Admin clicks the Class Navigation bar in the Header ML
Then Admin should see the Sort icon of all the field in the datatable ML.

@class8
Scenario: Validating the Delete button under the Manage class 

When Admin clicks the Class Navigation bar in the Header ML
Then Admin should see the Delete button under the Manage class page header ML.
 
@class9
Scenario: Validate the total no of classes in manage class page 

When Admin clicks the Class Navigation bar in the Header ML
Then Admin should see Total no of classes in below of the data table ML.
