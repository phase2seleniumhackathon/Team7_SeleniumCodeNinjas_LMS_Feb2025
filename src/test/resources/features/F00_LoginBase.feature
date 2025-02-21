Feature: Login Valid Case

  Background: Admin gives the correct LMS portal URL
    Scenario:  Validate login with valid data in all field
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button 
    Then Admin should land on home page 
    
    @TestScenario_Login_00
    Scenario: verify login button action through keyboard
    Given Admin is on login Page
    When Admin enter valid credentials  and clicks login button through keyboard
    Then Admin should land on home page
    
    @TestScenario_Login_01
    Scenario: verify login button action through mouse
    Given Admin is on login Page
    When Admin enter valid credentials  and clicks login button through mouse
    Then Admin should land on home page
    