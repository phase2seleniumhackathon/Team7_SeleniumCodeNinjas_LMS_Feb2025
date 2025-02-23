@Home
Feature: HomePage

  Background:
Given Admin is on login Page VH
When Admin enter valid data in all field and clicks login button VH
@Home1
Scenario:Verify LMS title

Then Admin should see LMS -Learning management system as title VH
@Home2
Scenario:Verify LMS title alignment

Then LMS title should be on the top left corner of page VH
@Home3
Scenario:Validate navigation bar text

Then Admin should see correct spelling in navigation bar text VH
@Home4
Scenario:Validate LMS title has correct spelling and space

Then Admin should see correct spelling and space in LMS title VH
@Home5
Scenario:Validate alignment for navigation bar

Then Admin should see the navigation bar text on the top right side VH
@Home6
Scenario:Validate navigation bar order 1st home

Then Admin should see home in the 1st place VH
@Home7
Scenario:Validate navigation bar order 2nd Program

Then Admin should see program in the 2nd place VH
@Home8
Scenario:Validate navigation bar order 3rd  batch

Then Admin should see batch in the 3rd place VH
@Home9
Scenario:Validate navigation bar order 4th  class

Then Admin should see class in the 4th place VH
@Home10
Scenario:validate navigation bar order 5th logout

Then Admin should see logout in the 5th place VH
@Home11
Scenario:verify pie-chart presence

Then Admin should see piechart VH
@Home12
Scenario:Verify user details

Then Admin should see welcome message with username and role VH
@Home13
Scenario:Verify bar chart

Then Admin should see bar chart for Active and inactive user VH
@Home14
Scenario:Verify user count

Then Admin should see user count VH
@Home15
Scenario:Verify staff count

Then Admin should see staff count VH
@Home16
Scenario:verify program count

Then Admin should see program count VH
@Home17
Scenario:Verify batch count 
 
Then Admin should see batch count VH
@Home18
Scenario:Verify staff table pagination

Then Admin should see staff table with pagination icons VH
@Home19
Scenario:Verify staff data page split

Then Admin should see 5 staff data in a page VH
@Home20
Scenario:verify previous page icon disable

Then Admin should see previous page icon disabled VH
@Home21
Scenario:verify first page icon disabled

Then Admin should see first page icon disabled VH
  
 
