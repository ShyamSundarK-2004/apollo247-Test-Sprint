Feature: Filter the docter and book appoinment
Scenario:
  And User click the general Physician
  When user applies sorting as "Price - low to high"
  And user filters doctors by experience "6-10"
  And user filters doctors by language "English"
  And user clicks on first displayed docter 
  And select the slot and continue to book
  Then verify the booking details