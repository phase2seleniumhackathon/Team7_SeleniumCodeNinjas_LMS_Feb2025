Feature: Program Management

  Background: 
    Given Admin enter valid data in all field and clicks login button 
    And Admin is on Program Page SS
    And Admin is on the Program details form SS

  @ProgramPage17
  Scenario: Verify add New Program
    Given Admin is on Program Page SS
    When Admin clicks on "Add New Program" under the "Program" menu bar SS
    Then Admin should see pop up window for program details SS

  @ProgramPage18
  Scenario: Verify title of the pop up window 
    Given Admin is on Program Page SS
    When Admin clicks on "Add New Program" under the "Program" menu bar SS
    Then Admin should see window title as "Program Details" SS

  @ProgramPage19
  Scenario: Verify mandatory fields with red asterisk mark
    Given Admin is on Program Page SS
    When Admin clicks on "Add  New Program" under the "Program" menu bar SS
    Then Admin should see red  asterisk mark  beside mandatory field "Name" SS

  @ProgramPage20
  Scenario: Verify empty form submission
    Given Admin is on Program details form SS
    When Admin clicks on "Add New Program" under the "Program" menu bar and clicks save button without entering mandatory SS
    Then Admin gets message "Program name is required." SS

  @ProgramPage21
  Scenario: Verify cancel button
    Given Admin is on Program Details form SS
    When Admin clicks on "Add New Program" under the "Program" menu bar and clicks Cancel button SS
    Then Admin can see Program Details form disappears SS

  @ProgramPage22
  Scenario: Verify enter program name
  Given Admin is on program details form SS
  When Admin clicks on "Add New Program" under the "Program" menu bar and enters the Name in the text box SS
  Then Admin can see the text entered SS
  
  
  @ProgramPage23
  Scenario: Verify enter description
  Given Admin is on program details form SS
  When Admin clicks on "Add New Program" under the "Program" menu bar and enters the Description in text box SS
  Then Admin can see the text entered in description box SS
  
  @ProgramPage24
  Scenario: Verify select Status
  Given Admin Is On Program Details Form SS
  When Admin clicks on "Add New Program" under the "Program" menu bar and selects the status of the program by clicking on the radio button "(Active/InActive)" SS
  Then Admin can see 'Active/Inactive' status selected SS
  
  @ProgramPage25
  Scenario: Verify Admin is able to save the program details 
  Given Admin is on program details form SS
  When Admin clicks On "Add New Program" under the "Program" menu bar and enter valid details for mandatory fields and Click on save button SS
  Then Admin gets Message 'Successful Program created' SS
  
  @ProgramPage26
  Scenario: Verify cancel button
   Given Admin is on Program Details Form SS
    When admin Clicks on "Add New Program" under the "Program" menu bar and Clicks Cancel button SS
    Then Admin can see Program Details Form Disappears SS
 #
  #@ProgramPage27
  #Scenario: Verify added Program is created
    #Given Admin is on Program page SS
    #When Admin searches with newly created "selenium" SS
    #Then Records of the newly created  "selenium" is displayed and match the data entered SS

  #@ProgramPage28
  #Scenario: Verify close window with "X"
    #Given Admin is on program details form SS
    #When Admin Click on "X" button SS
    #Then Admin can see program details form disappear SS
