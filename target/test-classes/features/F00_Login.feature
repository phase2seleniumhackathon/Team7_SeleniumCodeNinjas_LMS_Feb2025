Feature: Login Page Veification
  
  Background: Admin gives the correct LMS portal URL
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should land on the login page
    
    @TestScenario_Login_01
    Scenario:  Validate login with valid data in all field
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button 
    Then Admin should land on home page 
    
    @TestScenario_Login_02
    Scenario Outline: Validate login with invalid credentials
    Given Admin is on login Page
    When Admin enter invalid "<Sheet>" "<TestCase>" credentials and clicks login button 
    Then Error message displayed is "Invalid username and password Please try again"
    Examples: 
    |Sheet|TestCase|
    |login| LP01 |
    |login| LP02 |
    |login| LP03 |
    
     
    @TestScenario_Login_03
    Scenario Outline:  Validate login credentials with null user name
    Given Admin is on login Page
    When Admin enter value "<Sheet>" "<TestCase>" only in password and clicks login button 
    Then Error message "Please enter your user name"
    Examples: 
    |Sheet|TestCase|
    |NullUserNmae| LP01 |
    |NullUserNmae| LP02 |
    |NullUserNmae| LP03 |
    
    @TestScenario_Login_04
   Scenario Outline:  Validate login credentials with null password
    Given Admin is on login Page
    When Admin enter value "<Sheet>" "<TestCase>" only in user name and clicks login button  
    Then Error message displayed "Please enter your password"
    Examples: 
    |Sheet|TestCase|
    |NullPassword| LP01 |
   
    
    @TestScenario_Login_05
    Scenario: verify login button action through keyboard
    Given Admin is on login Page
    When Admin enter valid credentials  and clicks login button through keyboard
    Then Admin should land on home page
    
    @TestScenario_Login_06
    Scenario: verify login button action through mouse
    Given Admin is on login Page
    When Admin enter valid credentials  and clicks login button through mouse
    Then Admin should land on home page
    
    @TestScenario_Login_07
    Scenario: Verify for broken link
    Given The browser is open
    When Admin gives correct LMS portal URL
    Then HTTP response >= 400. Then the link is broken
    
  
    @TestScenario_Login_08
    Scenario: Validate sign in content
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see "Please login to LMS application"
    
    @TestScenario_Login_09
    Scenario: Verify text field is present
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see two text field
    
    @TestScenario_Login_10
    Scenario: Verify dropdown is present
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see one dropdown
  
    @TestScenario_Login_11
    Scenario: Verify text on the first field
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should "User" in the first text field

    @TestScenario_Login_12
    Scenario: Verify asterisk next to USER text
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see asterisk mark symbol next to text for mandatory fields
    
    @TestScenario_Login_13
    Scenario: Verify Verify text on the second field
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should "Password" in the second text field
    
    @TestScenario_Login_14
    Scenario: Verify asterisk mark symbol next to password text
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see asterisk mark symbol next to password text
  
    @TestScenario_Login_15
    Scenario: Verify placeholder in dropdown to select role
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see "Select the role" placeholder in dropdown
    
    @TestScenario_Login_16
    Scenario: Verify dropdown option to select role
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see "Admin , staff, student" options in dropdown
  
    @TestScenario_Login_17
    Scenario: verify Login button is present
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see login button 
  
    @TestScenario_Login_18
    Scenario:  Verify input descriptive text in user field
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see user in gray color
    
    @TestScenario_Login_19
    Scenario:  Verify input descriptive text in password field
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see password in gray color
  

    @TestScenario_Login_20
    Scenario: Verify the text spelling in the page 
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see correct spellings in all fields 
    
    
   # ##########################
    
    #@TestScenario_Login_04
    #Scenario: Verify application name 
    #Given The browser is open
    #When Admin gives the correct LMS portal URL
    #Then Admin should see  LMS - Learning Management System
    
    #@TestScenario_Login_05
    #Scenario: Verify company name
    #Given The browser is open
    #When Admin gives the correct LMS portal URL
    #Then Admin should see company name below the app name
#
    #@TestScenario_Login_15
    #Scenario: Verify the alignment input field for the logins
    #Given The browser is open
    #When Admin gives the correct LMS portal URL
    #Then Admin should see input field on the centre of the page
    
 #	@TestScenario_Login_01 
    #Scenario: Verify Admin is able to land on home page with invalid URL
    #Given The browser is open
    #When Admin gives the invalid LMS portal URL
    #Then Admin should receive application error
  #
    