Feature: Rebook Appointment Flow

  Scenario: Verify Book Appointment option after rebooking

    When User navigates to My Appointments and clicks View All
    And User clicks on Rebook for a doctor
    And User clicks Continue
    And User click ChangeBtn to Change the patient and click proceed
    Then User should see Book Appointment option