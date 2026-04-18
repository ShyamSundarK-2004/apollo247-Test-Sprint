      Feature: Apollo 247 Health Insurance - Member Selection Validation
	
	  Background:
	    
	    Given User navigates to Health Insurance page and enter pincode "601201"
	    
	     @regression @insurance @memberSelection
	Scenario: Verify multiple member selection (Self, Wife, Father)/ // .
	    When User selects Gender "Female" "Self" at age "28", "Husband" at age "25", and "Father"  at age "55" as members
	    And User clicks on "View Plans"
	    Then Family insurance plans should be displayed correctly