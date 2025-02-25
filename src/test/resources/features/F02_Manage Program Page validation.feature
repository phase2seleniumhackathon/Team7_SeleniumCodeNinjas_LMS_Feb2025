Feature: Program page functionality

 Background: 
   Given Admin enter valid data in all field and clicks login button 
    And Admin is on Program Page SS
  

  @ProgramPage1
 Scenario: Verify that Admin is able to navigate to Program page
   When Admin clicks "Program" on the navigation bar SS
   Then Admin should be navigated to Program page SS

@ProgramPage2
  Scenario: Verify Logout displayed in menu bar 
   When Admin clicks "Program" on the navigation bar SS
   Then Admin should see Logout in menu bar SS
  
 @ProgramPage3
  Scenario: Verify heading in menu bar
  When Admin clicks "Program" on the navigation bar SS
   Then Admin should see the heading "LMS - Learning Management System" SS
  
#@ProgramPage4
  #Scenario Outline: Verify other page's name displayed in menu bar
  #When Admin clicks "Program" on the navigation bar SS
   #Then Admin should see the page names as in order "<page1>", "<page2>", "<page3>", "<page4>" SS
#
#Examples:
      #| page1 | page2  | page3 | page4 |
      #| Home  | Program | Batch | Class |
      #
 @ProgramPage5
  Scenario: Verify sub menu displayed in program menu bar
   When Admin clicks "Program" on the navigation bar SS
  Then Admin should see sub menu in menu bar as "Add New Program" SS
  
  @ProgramPage6
  Scenario: Verify heading in manage program
   When Admin clicks "Program" on the navigation bar SS
  Then Admin should see the heading "Manage Program" SS
  
  #@ProgramPage7
  #Scenario Outline: Verify view details of programs
   #When Admin clicks "Program" on the navigation bar SS
  #Then Admin should be able to see program name "<programName>", description "<description>", and status "<status>" SS
#Examples:
      #| programName | description       | status   |
      #| Program1    | Description1      | Active   |
      #| Program2    | Description2      | Inactive |
  
    #@ProgramPage8
   #Scenario: Verify the Multiple Delete button state
    #When Admin clicks "Program" on the navigation bar SS
   #Then Admin should see a Delete button in left top is disabled SS
  #
    @ProgramPage9
  Scenario: Verify the Search button
    When Admin clicks "Program" on the navigation bar SS
   Then Admin should see Search bar with text as "Search..." SS
 
    #@ProgramPage10
   #Scenario: Verify column header name of data table
    #When Admin clicks "Program" on the navigation barr SS
   #Then Admin should see data table with column header on the Manage Program Page as   Program Name, Program Description, Program Status, Edit/Delete
  #
    @ProgramPage11
   Scenario: Verify checkbox default state beside Program Name column header
   When Admin clicks "Program" on the navigation bar SS
   Then Admin should see checkbox default state as unchecked beside Program Name column header SS
   
    #@ProgramPage12
   #Scenario: Verify checkboxes default state beside each Program names in the data table
    #When Admin clicks "Program" on the navigation bar SS
   #Then Admin should see check box default state as unchecked on the left side in all rows against program name SS
  
   @ProgramPage13
  Scenario: Verify Sort icon in manage program
   When Admin clicks "Program" on the navigation bar SS
   Then Admin should see the sort arrow icon beside to each column header except Edit and Delete SS
   
   @ProgramPage14
   Scenario: Verify edit and delete icon in manage program
    When Admin clicks "Program" on the navigation bar SS
   Then Admin should see the Edit and Delete buttons on each row of the data table SS
  
  
 #@ProgramPage15
   #Scenario: Verify pagination icons below data table in manage program
    #When Admin clicks "Program" on the navigation bar SS
   #Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table.SS
  #x- starting record number on that page
  #y-ending record number on that page
  #z-Total number of records
  #
  #
  #@ProgramPage16
  #Scenario: Verify footer message in manage program
  #When Admin clicks "Program" on the navigation bar SS
   #Then Admin should see the footer as "In total there are z programs".SS
  #z- Total number of records
  #
  #
 