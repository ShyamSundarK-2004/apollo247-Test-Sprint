Feature: Account Module - Manage Family Members & My Appointments

Background:
  Given user opens My Account panel
  

# ============================================================
# SCENARIO 1: Manage Family Members (currently failing - tagged)
# ============================================================
@ManageFamily
Scenario Outline: Add valid family member

  When user navigates to Manage Family Members
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
  
  
# ============================================================
  # SCENARIO 4: My Memberships - Corporate Email Error (Scenario Outline)
  # Uses Scenario Outline to test multiple invalid corporate emails
  # ============================================================
  @MyMemberships @CorporateEmail
  Scenario Outline: Verify error for invalid corporate email

    When user navigates to My Memberships
    And user clicks Activate Corporate Membership
    And user enters corporate email "<Email>"
    And user clicks Get OTP
    Then corporate benefits error message should be displayed
    And user dismisses the error popup

    Examples:
      | Email                  |
      | abc@capgemini.com      |
      | test@benz.com |

  # ============================================================
  # SCENARIO 5: My Memberships - Buy Now Plan Validation (DataTable)
  # Uses DataTable to verify expected plan details on the page
  # ============================================================
  @MyMemberships @PlanValidation
  Scenario: Verify membership plan details after clicking Buy Now

    When user navigates to My Memberships
    And user clicks BUY NOW
    And user scrolls to 12 months plan and clicks Join Now
    Then the following plan details should be visible on the page
      | planDetail |
      | 12 Months  |
      | 199        |