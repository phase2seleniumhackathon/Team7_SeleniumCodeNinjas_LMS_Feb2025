Feature: Edit Program Management

  Background: 
    Given Admin enter valid data in all field and clicks login button
    And Admin is on Program Page SS
    And Admin is on the Program details form SS
    
    #
  @ProgramPage29
 Scenario: Verify Edit option 
  Given Admin is on Program Page SS
 When Admin clicks on Edit option for particular Program SS
 Then Admin lands on Program details form SS
 #
  @ProgramPage30
 Scenario: Verify title of the pop up window 
  Given Admin is on Program Page SS
 When Admin clicks on Edit option for particular Program SS
 Then Admin should see window title as "Program Details" SS
 #
   @ProgramPage31
 Scenario: Verify mandatory fields with red asterisk mark 
  Given Admin is on Program Page SS
 When Admin clicks on Edit option for particular Program SS
 Then Admin should see red asterisk mark beside mandatory field "Name" SS
 #
    @ProgramPage32
 Scenario: Verify edit Program Name
  Given Admin is on Program Page SS
 When Admin edits the program nameto "New Program Name" and click on save button SS
 #Then Updated Program Name is seen by the Admin SS
 #
 @ProgramPage33
 Scenario: Verify edit Description
  Given Admin is on Program Page SS
 When Admin edits the description textto "New Program Description" and click on save button SS
 #Then Admin can see the description is updated SS
 #
  @ProgramPage34
 Scenario: Verify edit Status
  Given Admin is on Program Page SS
 When Admin can change the status of the program and click on save button SS
 Then Status updated can be viewed by the Admin
 #
   @ProgramPage35
 Scenario: Verify Admin is able to click Save
  Given Admin is on Program Page SS
 When Admin Click On Save Button SS
 #Then Admin Can See The Updated Program Details SS
 
   #@ProgramPage36
 Scenario: Verify Admin is able to click Cancel
  Given Admin is on Program Page SS
 When Admin click on cancel button SS
 Then Admin can see the Program details form disappears SS
 
    #@ProgramPage37
 #Scenario: Verify edited Program details
  #Given Admin is on Program page SS
 #When Admin searches with newly updated "Program Name" SS
 #Then Admin verifies that the details are correctly updated. SS
 #
     #@ProgramPage38
 #Scenario: Verify close the window with "X" 
  #Given Admin is on Program page SS
 #When Admin Click on "X" button SS
 #Then Admin can see program details form disappear SS
    