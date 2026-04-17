Feature: Account Module - Manage Family Members & My Appointments

Background:
  Given user opens My Account panel

# ============================================================
# SCENARIO 1: Manage Family Members (currently failing - tagged)
# ============================================================
@ManageFamily
Scenario Outline: Add valid family member

  When user clicks Add New Profile
  And user enters family member details "<FirstName>" "<LastName>" "<DOB>"
  And user selects gender "<Gender>" and relation "<Relation>"
  And user clicks Save
  Then family member should be created successfully

Examples:
  | FirstName | LastName | DOB        | Gender | Relation |
  | abcgdhjd  | K        | 20/05/1991 | Male   | Brother  |


# ============================================================
# SCENARIO 2: My Appointments - Page Load
# ============================================================
@MyAppointments @AppointmentDisplay
Scenario: Verify My Appointments page loads successfully

  When user clicks My Appointments
  Then Appointments section should be displayed


# ============================================================
# SCENARIO 3: My Appointments - Refresh Validation
# ============================================================
@MyAppointments @PageReload
Scenario: Verify My Appointments page persists after refresh

  When user clicks My Appointments
  And user refreshes the page
  Then Appointments section should still be displayed