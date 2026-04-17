Feature: Apollo 247 Health Insurance - Member Selection Validation
	
	  Background:
	    Given  close the popup shown
	  When User logs in with mobile number "9003598838"
    Then User should be prompted for OTP verification
	    Given User navigates to Health Insurance page and enter pincode "601201"
	
	  @smoke @insurance @memberSelection
	  Scenario: Verify valid member selection (Female and Self)
	    When User selects "Female" and "Self" as members
	    And User clicks on "View Plans"
	    Then Insurance plans should be loaded successfully
	
	#  @regression @insurance @memberSelection
	#  Scenario: Verify multiple member selection (Self, Wife, Father)
	   # When User selects "Self", "Wife", and "Father" as members
	  #  And User clicks on "View Plans"
	  #  Then Family insurance plans should be displayed correctly
	
	#@negative @insurance @validation
	 # Scenario: Verify validation when no member is selected
	  #  When User clicks on "View Plans" without selecting any member
	  #  Then Proper validation error message should be displayed