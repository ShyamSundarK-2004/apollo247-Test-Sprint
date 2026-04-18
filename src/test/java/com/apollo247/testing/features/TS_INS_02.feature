Feature: Apollo 247 Health Insurance - Member Selection Validation
	
	  Background:
	    
	    Given User navigates to Health Insurance page and enter pincode "601201"
	    
	   @negative @insurance @validation
	  Scenario: Verify validation when no member is selected
	   When User clicks on "View Plans" without selecting any member
	   Then Proper validation error message "Select minimum one adult" should be displayed